package study.hash.let;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="/encodingText",produces = "application/text; charset=utf8") 
	public String encodingText(@RequestParam("targetText")String targetText) throws UnsupportedEncodingException {
		
		String result = "";
		
		result += "utf-8(1) : " + new String(targetText.getBytes("utf-8"), "euc-kr") + "\n";
		result += "utf-8(2) : " + new String(targetText.getBytes("utf-8"), "ksc5601") + "\n";
		result += "utf-8(3) : " + new String(targetText.getBytes("utf-8"), "x-windows-949") + "\n";
		result += "utf-8(4) : " + new String(targetText.getBytes("utf-8"), "iso-8859-1") + "\n";
		
		result += "iso-8859-1(1) : " + new String(targetText.getBytes("iso-8859-1"), "euc-kr") + "\n";
		result += "iso-8859-1(2) : " + new String(targetText.getBytes("iso-8859-1"), "ksc5601") + "\n";
		result += "iso-8859-1(3) : " + new String(targetText.getBytes("iso-8859-1"), "x-windows-949") + "\n";
		result += "iso-8859-1(4) : " + new String(targetText.getBytes("iso-8859-1"), "utf-8") + "\n";
		
		result += "euc-kr(1) : " + new String(targetText.getBytes("euc-kr"), "ksc5601") + "\n";
		result += "euc-kr(2) : " + new String(targetText.getBytes("euc-kr"), "utf-8") + "\n";
		result += "euc-kr(3) : " + new String(targetText.getBytes("euc-kr"), "x-windows-949") + "\n";
		result += "euc-kr(4) : " + new String(targetText.getBytes("euc-kr"), "iso-8859-1") + "\n";
		
		result += "ksc5601(1) : " + new String(targetText.getBytes("ksc5601"), "euc-kr") + "\n";
		result += "ksc5601(2) : " + new String(targetText.getBytes("ksc5601"), "utf-8") + "\n";
		result += "ksc5601(3) : " + new String(targetText.getBytes("ksc5601"), "x-windows-949") + "\n";
		result += "ksc5601(4) : " + new String(targetText.getBytes("ksc5601"), "iso-8859-1") + "\n";
		
		result += "x-windows-949(1) : " + new String(targetText.getBytes("x-windows-949"), "euc-kr") + "\n";
		result += "x-windows-949(2) : " + new String(targetText.getBytes("x-windows-949"), "utf-8") + "\n";
		result += "x-windows-949(3) : " + new String(targetText.getBytes("x-windows-949"), "ksc5601") + "\n";
		result += "x-windows-949(4) : " + new String(targetText.getBytes("x-windows-949"), "iso-8859-1") + "\n";
		
		logger.info("targetText : " + targetText);
		logger.info("result\n" + result);
		
		return result;
	}
}
