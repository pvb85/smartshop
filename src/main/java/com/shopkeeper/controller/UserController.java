package com.shopkeeper.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shopkeeper.exceptions.UserNotFoundException;
import com.shopkeeper.model.User;
import com.shopkeeper.service.UserService;

/**
 * @author vykuntarao.erothu
 *
 */
@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	// displaying home page
	@GetMapping("/")
	public ModelAndView showMenu() {
		return new ModelAndView("Home");
	}

	// display login page
	@GetMapping("/loginPage")
	public ModelAndView displayLoginPage(@ModelAttribute("user") User user) {
		LOGGER.info("----- inside loginPage()--------");
		return new ModelAndView("loginUser");

	}

	// login with username and password
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("user") User user) {
		ModelAndView m = null;
		String result = null;
		try {

			if (user.getUserName().isEmpty() && user.getUserPasword().isEmpty()) {
				LOGGER.info("--inside login method-- username or password empty -----");
				result = "enter the username and password";
				m = new ModelAndView("loginUser", "result", result);

			} else {
				String userName = user.getUserName();
				String password = user.getUserPasword();

				User userdb = userService.login(userName, password);

				if (userdb == null) {
					LOGGER.info("----inside userLogin()-- not found-----" + userdb);
					result = "either username or password is invalid";
					throw new UserNotFoundException("user not found ");
				}

				else if (userdb.getRole().equalsIgnoreCase("A")) {
					LOGGER.info("this is a info message----inside userLogin()--Admin-----");

					m = new ModelAndView("itemMenu");
					return m;

				} else {
					LOGGER.info("----inside userLogin()--- user-----");
					m = new ModelAndView("search");
					return m;

				}
			}

		} catch (UserNotFoundException e) {
			LOGGER.info("----inside -UserNotFoundException catch block-- " + e);
			m = new ModelAndView("loginUser", "result", result);
			return m;

		} catch (Exception e) {
			LOGGER.info("----inside Exception catch block-----" + e);
			return m;
		}

		return m;

	}

	// displaying user registration page
	@GetMapping(value = "/registerPage")
	public ModelAndView showRegistrationPage() {
		LOGGER.info("----showRegistrationPage-- ");
		return new ModelAndView("userRegistration");

	}

	// user registration
	@PostMapping("/registerUser")
	public ModelAndView userRegistration(@ModelAttribute("user") @Validated User user, BindingResult bindingResult) {
		String result = null;
		ModelAndView m = null;
		try {
			if (bindingResult.hasErrors()) {
				LOGGER.info("----inside registerUser()--hasErrors-----");
				m = new ModelAndView("userRegistration");
				return m;
			} else {
				LOGGER.info("----inside registerUser()-no-hasErrors-----");
				result = userService.registerUser(user);
				m = new ModelAndView("Home", "result", result);
				return m;
			}
		} catch (Exception e) {

			LOGGER.info("----inside Exception catch block-----" + e);

			return m;

		}
	}

}
