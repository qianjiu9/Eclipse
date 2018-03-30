package sw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sw.entity.Type;
import sw.repo.TypeRepo;

@Controller
@RequestMapping("/type")
public class TypeController {
	@Autowired
	private TypeRepo typeRepo;


	@GetMapping("/")
	public String showTypePage(Model model){
		Iterable<Type> type=typeRepo.findAll();
		model.addAttribute("type", type);
		return "type/index";
	}
	
	@GetMapping("/form")
	public String showFormPage(@RequestParam(value="id",required=false) Type type,
			Model model){
		if(type!=null)
		model.addAttribute(type);
		return "type/form";
	}
	
	@PostMapping("/type")
	public String AddType(Type type,Model model){
			typeRepo.save(type);
			return "redirect:/type/";
	}
	
	@GetMapping("/delType")
	public String DelType(Long id){
		typeRepo.delete(id);
		return "redirect:/type/";
	}
	
}
