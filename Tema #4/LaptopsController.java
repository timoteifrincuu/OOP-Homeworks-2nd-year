package ro.emanuel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.pojo.Laptop;

@Controller
public class LaptopsController {
	
	@GetMapping("/laptops")
	public ModelAndView brand() {
		Laptop l = new Laptop("Dell", 4, "par");
		ModelAndView mav = new ModelAndView("laptops.jsp");
		mav.addObject("brand", l.toStringBasic());
		return mav;
	}
	
	
	@GetMapping("/laptop")
	public ModelAndView specificatii() {
		Laptop l = new Laptop("Dell", 2500, 16);
		ModelAndView mav = new ModelAndView("laptop.jsp");
		mav.addObject("specificatii", l.toStringFull());
		return mav;
	}
}


