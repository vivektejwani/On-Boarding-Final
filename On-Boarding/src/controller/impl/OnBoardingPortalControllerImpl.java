package controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import controller.OnBoardingPortalController;
import DAO.OnBoardingPortalDAO;
import Entities.*;

@Controller
public class OnBoardingPortalControllerImpl implements
		OnBoardingPortalController {

	@Autowired
	OnBoardingPortalDAO onBoardingPortalDAO;

	// TODO: put url and model attribute
	@RequestMapping("validate")
	public ModelAndView loginUser(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("user") User user) {

		ModelAndView modelAndView = new ModelAndView();

		if (user.getType().equalsIgnoreCase("employee")) {

			Employee employee = new Employee(user.getEmail(),
					user.getPassword());
			Employee employeeFromDAO = onBoardingPortalDAO.validateEmployee(employee);
			if (employeeFromDAO != null) {

				HttpSession session = request.getSession();
				session.setAttribute("user", employeeFromDAO);
				// session.setMaxInactiveInterval(1800);
				// TODO:set view name for page after successful login
				modelAndView.setViewName("");
				return modelAndView;
			}
		} else if (user.getType().equalsIgnoreCase("hr")) {

			HR hr = new HR(user.getEmail(), user.getPassword());

			HR hrFromDAO = onBoardingPortalDAO.validateHr(hr);

			if (hrFromDAO != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", hrFromDAO);
				// session.setMaxInactiveInterval(1800);
				// TODO:set view name for page after successful login
				modelAndView.setViewName("");
				return modelAndView;
			}
		} else if (user.getType().equalsIgnoreCase("admin")) {

			Admin admin = new Admin(user.getEmail(), user.getPassword());

			Admin adminFromDAO = onBoardingPortalDAO.validateAdmin(admin);

			if (adminFromDAO != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", admin);
				// session.setMaxInactiveInterval(1800);
				// TODO:set view name for page after successful login
				modelAndView.setViewName("");
				return modelAndView;
			}
		}

		// TODO: set view name for error page
		return new ModelAndView("");

	}

	// TODO: put url and model attribute
	@RequestMapping("")
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();

		HttpSession session = request.getSession();
		session.invalidate();

		// TODO: set view name
		modelAndView.setViewName("");
		return modelAndView;
	}

	// TODO: put url and model attribute
	@RequestMapping("")
	public ModelAndView addHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr) {
		return null;
	}

	@RequestMapping("")
	public ModelAndView removeHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr) {
		return null;
	}

	@RequestMapping("")
	public ModelAndView generatePassword(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr) {
		return null;
	}

	@RequestMapping("")
	public ModelAndView createGroup(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Group group) {
		return null;
	}

	@RequestMapping("")
	public ModelAndView removeGroup(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Group group) {
		return null;
	}

	@RequestMapping("")
	public ModelAndView createPost(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Message message) {
		return null;
	}

	@RequestMapping("")
	public ModelAndView removePost(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Message message) {
		return null;
	}

	@RequestMapping("")
	public ModelAndView updateProfileOfEmployee(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") Employee employee) {
		return null;

	}

	@RequestMapping("")
	public ModelAndView updateProfileOfHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr) {
		return null;

	}


	@RequestMapping("newSession.htm")
	public ModelAndView newSession(HttpServletRequest request,HttpServletResponse response, ModelMap map){
		
		ModelAndView modelAndView = new ModelAndView();
		
		User user = new User();
		map.addAttribute("user", user);
		System.out.println("Passing user");
		// TODO: set view name
		modelAndView.setViewName("index");
		return modelAndView;
	}
	

}
