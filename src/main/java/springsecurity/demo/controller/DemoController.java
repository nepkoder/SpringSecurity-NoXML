package springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {

		return "home";
	}

	@RequestMapping({ "/customlogin" })
	public String customLogin() {
		return "custom-login";
	}
	
	@GetMapping("/manager")
	public String manager() {
		return "manager";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/access-failed")
	public String showFailedPage() {
		return "access-failed";
	}
}
