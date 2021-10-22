package com.app.controller;


import java.util.ArrayList;
import java.util.List;
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
import com.app.pojos.Card;
import com.app.pojos.Flight;
import com.app.pojos.Passenger;
import com.app.service.IPassengerService;

@Controller
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	private IPassengerService passengerServ;
	
	public PassengerController() {
		System.out.println("in passenger controller");
	}
	
	@GetMapping("/login")
	public String showLoginForm(Passenger passenger) {
		System.out.println("in show log in form");
		System.out.println(passenger);
		return "/passenger/login";
	}
	
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model modelMap,HttpSession session) {
		try{
	
		Passenger passenger = passengerServ.validatePassenger(email, password);
		System.out.println(passenger);
		session.setAttribute("pass_details", passenger);
		session.setAttribute("flight_details", passenger.getFlights());
		modelMap.addAttribute("message", "Log in successful...!!");
		return "redirect:/passenger/search";
		}
		catch (RuntimeException e) {
			modelMap.addAttribute("message", "Invalid Credential..!!");
			return "/passenger/login";
		}
	}
	
	@GetMapping("/search")
	public String showSearchFlight(HttpSession session) {
		System.out.println("In  show search flight....");
		return "/passenger/search";
	}
	
	
	@PostMapping("/search")
	public String processSearchFlight(@RequestParam String depCity, @RequestParam String arrivalCity, Model modelMap,HttpSession session) {
		System.out.println("In process search flight....");
		try{
			List<Flight> flights = new ArrayList<>();
			System.out.println(flights);
			flights = passengerServ.getFlightList(depCity, arrivalCity);
			System.out.println(flights);
			session.setAttribute("flights", flights);
			modelMap.addAttribute("message", "List of flights are...");
			return "redirect:/passenger/display";
		}
	catch (RuntimeException e) {
		modelMap.addAttribute("message", "error in this page");
		return "/passenger/search";
		}
	}
	
	@GetMapping("/display")
	public String showDisplayPage(Flight flight, HttpSession session) {
		System.out.println("In display page");
		return "/passenger/display";
	}
	
	@GetMapping("/details")
	public String showDetailsPage(Passenger passenger) {
		System.out.println(passenger);
		System.out.println("in show details page...");
		return "/passenger/details";
	}
	
	@PostMapping("/details")
	public String processDetailsPage(@RequestParam String name,@RequestParam String email, @RequestParam String phoneNum, Model modelMap,HttpSession session) {
		System.out.println("in process details page..");
		try{
			
			Passenger passenger = passengerServ.validatePassAllDetails(name,email,phoneNum);
			System.out.println(passenger);
			session.setAttribute("passenger_details", passenger);
			modelMap.addAttribute("message", "Redirecting to next page");
			return "redirect:/passenger/card";
			}
			catch (RuntimeException e) {
				modelMap.addAttribute("message", "Credentials does not match with originally provided");
				return "/passenger/details";
			}
	}
	
	@GetMapping("/card")
	public String showCardPage(Passenger passenger, Card card) {
		System.out.println("In display page");
		return "/passenger/card";
	}
	
	@PostMapping("/card")
	public String processCardPage(Passenger pass, Card card, Model modelMap,HttpSession session) {
		System.out.println("in process details page..");
		try{
				Card passCard = pass.getCard();
				System.out.println(card);
				System.out.println(pass.getCard());
				session.setAttribute("card_details", card);
				modelMap.addAttribute("message", "Valid credentials");
				return "redirect:/passenger/status";	
						
			}
			catch (RuntimeException e) {
				modelMap.addAttribute("message", "Invalid Card details");
				return "/passenger/card";
			}
		
	}
	
	@GetMapping("/status")
	public String userLogOut(HttpSession session, Model modelMap, HttpServletRequest req , HttpServletResponse resp) {
		System.out.println("in passenger's logout...");
		resp.setHeader("refresh", "7;url= "+ req.getContextPath());
		return "/passenger/status";
	}
	
}
