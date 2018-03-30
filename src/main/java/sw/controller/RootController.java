package sw.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class RootController {
	
	//应用根请求
	@GetMapping("/")
	public String showIndexPage(Model model){
		model.addAttribute("today", new Date());
		return "index"; //返回index.html视图
	}
	

	
//	@GetMapping("/classes/")
//	public String showClassesPage(){
//		return "classes/index";
//	}
	
//	@GetMapping("/student/")
//	public String showStudentPage(){
//		return "student/index";
//	}
}
