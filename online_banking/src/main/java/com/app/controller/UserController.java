package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;

	public UserController() {
		System.out.println("in cons of User Controller..");
	}
	
	@GetMapping("/login")
	public String showLoginForm(User user,HttpSession hs) {
		System.out.println("in show login form...");
		return "/user/login";
	}
	
	
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model modelMap,HttpSession session) {
		System.out.println("in process login form "+email+" "+password);
		try {
			User validatedUser= userService.validateUser(email, password);
			session.setAttribute("user_detail", validatedUser);
			session.setAttribute("accnt_details",validatedUser.getAccounts());
			session.setAttribute("message", "Login successful.....");
			return "/user/list";
		}
		catch (RuntimeException e) {
			System.out.println("Error message.............");
			e.printStackTrace();
			modelMap.addAttribute("message", "Invalid Credential...! Pls retry..!!");
			return "/user/login";
		}		
	}

	@GetMapping("/logout")
	public String userLogOut(HttpSession session, Model modelMap, HttpServletRequest req , HttpServletResponse resp) {
		System.out.println("in user's logout..");
		modelMap.addAttribute("details", session.getAttribute("user_detail"));
		resp.setHeader("refresh", "5;url= "+ req.getContextPath());
		return "/user/logout";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(User userDetails) {
			System.out.println(userDetails);
			return "/user/register";
	}
	@PostMapping("/register")
	public String processRegistrationForm(User user, RedirectAttributes flashMap) {
		System.out.println(user);
		flashMap.addFlashAttribute("msg", userService.registerUser(user));
		return "redirect:/user/register";
	}

}
