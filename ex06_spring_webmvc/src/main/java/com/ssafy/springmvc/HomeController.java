package com.ssafy.springmvc;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ssafy.springmvc.model.HelloDto;
import com.ssafy.springmvc.model.ParameterDto;
import com.ssafy.springmvc.model.service.HelloService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "index";   // /WEB-INF/views/index.jsp
	}
	
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		HelloDto helloDto = new HelloDto();
		helloDto.setMessage("Hello Spring Web MVC!!!");
		mav.addObject("ex", helloDto);  // 리케스트명:ex, 보낼객체: Hello Spring Web MVC!!!
		mav.setViewName("step01/hello");   // /WEB-INF/views/step01/hello.jsp 
		return mav;
	}
	
	@RequestMapping("/hellomvc")
	public ModelAndView helloMvc() {
		ModelAndView mav = new ModelAndView();
		HelloDto helloDto = helloService.greeting();
		mav.addObject("hello", helloDto);
		mav.setViewName("step02/hello");
		return mav;
	}
	
	@RequestMapping("/parameter")
	public String parameter() {
		return "step03/form";
	}
	
	@RequestMapping(value = "/sendparam", method = RequestMethod.GET)
	public String parameterTest(@RequestParam("userid") String id, @RequestParam("username") String name, String area) {
		System.out.println(id+"   "+name+"  "+area);
		
		return "step03/form";
	}

	@RequestMapping(value = "/sendparam", method = RequestMethod.POST)
	public String parameterTest(ParameterDto parameterDto, Model model) {
		System.out.println(parameterDto.getUserid());
		System.out.println(parameterDto.getUsername());
		System.out.println(parameterDto.getFruit());
		
		model.addAttribute("data", parameterDto);
		return "step03/result";
	}
	
}










