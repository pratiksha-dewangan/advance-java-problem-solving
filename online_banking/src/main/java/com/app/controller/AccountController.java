package com.app.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Account;
import com.app.service.IAccountService;

@Controller
@RequestMapping("/acnt")
public class AccountController {

	@Autowired
	private IAccountService accntServ;
	
	public AccountController() {
		System.out.println("in const of Account Controller");
	}
	
	@GetMapping("/create")
	public String showCreateAccountForm(Account acnt, HttpSession hs, @RequestParam int userId) {
		System.out.println("in show create accnt form .. "+acnt+" "+userId);
		hs.setAttribute("user_id", userId);
		return "/acnt/create";
	}
	
	@PostMapping("/create")
	public String processCreateAccountForm(Account acntDetails , HttpSession hs, RedirectAttributes flashMap, Model map) {
		System.out.println("in process create account form..");
		int userId = (Integer)hs.getAttribute("user_id");
		System.out.println(userId+" "+acntDetails);
		map.addAttribute("msg","Account created");
		flashMap.addFlashAttribute(accntServ.createAccount(userId, acntDetails));
		return "redirect:/user/list";
	}
	
	@GetMapping("/close")
	public String deleteCourse(@RequestParam int aId, RedirectAttributes flashMap) {
		System.out.println("in delete account..!!");
		System.out.println(aId);
		flashMap.addFlashAttribute("message",accntServ.closeAccount(aId));
		return "redirect:/user/list";
	}
	
}
