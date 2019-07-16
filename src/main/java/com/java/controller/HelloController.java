package com.java.controller;  


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.model.User;
import com.java.service.UserService;  
@Controller  
public class HelloController {  
	@Autowired
	private UserService userService;
	 @RequestMapping("/")  
	    public String redirect1()  
	    {  
	        return "index";  
	    }  	
	 @RequestMapping("/index")  
	    public String redirect2()  
	    {  
	        return "index";  
	    }  	
	 @RequestMapping("/final")  
	    public String redirect22(Model m)  
	    { 
		 List<User> list=userService.getAll();
		 System.out.println(list);
	        m.addAttribute("list",list);
	        return "final";  
	    }  	
	  
	 @RequestMapping("/register")  
    public String redirect()  
    {  
        return "register";  
    }   
@RequestMapping(value = "/action", method = RequestMethod.POST)
public ModelAndView submitForm(Model model, @Validated User user, BindingResult result) {
	System.out.println(user.getCaptcha1()+" "+user.getCaptcha2());
	ModelAndView mv = new ModelAndView();
	if(!user.getCaptcha1().equals(user.getCaptcha2()))
	{
		mv.addObject("message","captcha incorrect");
		mv.setViewName("register");
	}
	else if(result.hasErrors())
	{
		//mv.addObject("message", "duplicate entry");
		mv.setViewName("register");
	}
	else {
		try {
			userService.create(user);
			//userService.getAll();
			/*
			 * if (mysql_errno() == 1062) { yatem.out.println("Duplicate"); }
			 */
			mv.setViewName("index");
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("error", "Duplicate Entry");
			mv.addObject("message", "Duplicate entry");
			mv.setViewName("register");
		}
	}
	return mv;
}

@RequestMapping(value="/update",method = RequestMethod.POST)    
public ModelAndView editsave(@ModelAttribute("emp") User emp){ 
	System.out.println("hallo");
	ModelAndView mv = new ModelAndView();
    userService.update(emp); 
    mv.setViewName("index");
    return mv;    
}

@RequestMapping(value = "/action1", method = RequestMethod.POST)
public String UserLogin(@ModelAttribute("user") User user,Model m) {
	//System.out.println(user);
	ModelAndView mv = new ModelAndView();
	String name = userService.loginUser(user);
	if(!user.getCaptcha1().equals(user.getCaptcha2()))
	{
		m.addAttribute("message", "captcha incorrect");
		return "index";
	}
	else
	{
		System.out.println(name);
	if (name != null) {
		 /*mv.addObject("message", "Welcome " + name + ", You have successfully logged in.");
		return "redirect:/editemp/{username}";*/
		//User emp=userService.getEmpById(username);    
	    //m.addAttribute("command",emp);  
	    //System.out.println(emp);
		List<User> list=userService.get(user);
		 System.out.println(list);
	     m.addAttribute("list",list);
		
	    return "final";
	} else {
		//m.addObject("message", "Invalid user id or password.");
		m.addAttribute("message", "Invalid user id or password.");
		return "index";
	}
	}
}

@RequestMapping(value="/editemp/{id}")    
public String edit(@PathVariable Long id, Model m){  
	//System.out.println(username);

    //System.out.println(username);
    User emp=userService.getEmpById(id); 
    //System.out.println(emp);
    m.addAttribute("command",emp);  
    //System.out.println("vanthuta");
    return "login";    
}
/*@RequestMapping(value = "/action1", method = RequestMethod.GET)
public List UserLogin1() {

	ModelAndView mv = new ModelAndView();
	List<User> name = userService.getAll();
	return  login;
}*/
}
