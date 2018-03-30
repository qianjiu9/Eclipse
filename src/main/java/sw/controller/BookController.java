package sw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sw.entity.Book;
import sw.entity.Type;
import sw.repo.BookRepo;
import sw.repo.TypeRepo;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private TypeRepo typeRepo;

	@GetMapping("/")
	public String showBookPage(Long typeId,Model model){
		Iterable<Book> book=null;
		model.addAttribute("types",typeRepo.findAll());
		if(typeId==null||typeId==-1)
			book=bookRepo.findAll();
		else
			book=bookRepo.findByTypeId(typeId);
		model.addAttribute("book", book);
		return "book/index";
	}
	
	@GetMapping("/order")
	public String showOrderPage(){
		return "book/order";
	}
	
	@GetMapping("/search")
	public String showSearchPage(){
		return "book/search";
	}
	
	@GetMapping("/form")
	public String showForm(@RequestParam(value="id",required=false)Book book,
			Model model){
		if(book==null)
			book=new Book();
			//model.addAttribute(book);
			model.addAttribute("type",typeRepo.findAll());
			model.addAttribute("book",book);
		return "book/form";
	}
	
	
	
	@PostMapping("/save")
	public String saveBook(Book book){
		bookRepo.save(book);
		return "redirect:/book/";
	}
	
	@GetMapping("delBook")
	public String delBook(Long id){
		bookRepo.delete(id);
		return "redirect:/book/";
	}
	//订购提醒		 
			@PostMapping("tixin")
			public String tixin(@RequestParam(value="count",required=false) int count,Model model) {
				Iterable<Book> book=bookRepo.findAll();
				ArrayList<Book> books = new ArrayList<Book>();
				for(Book i:book)
				{
		
					if(i.count!=null&&i.count<=count)
						books.add(i);
				}
				model.addAttribute("book",books);
				return "/book/order";
			}
			
	//按名称查找
			@GetMapping("/SearchByName/{name}")
			public String SearchByName(@PathVariable String name,
					Model model){
				Iterable<Book> book = null;
				if(name == null)
					book = bookRepo.findAll();
				else
					book = bookRepo.findByNameLike(name);
				
				model.addAttribute("book", book);
				//返回到视图book/books视图中的"booksTable" fragment
				return "book/search::booksTable";
			}
			

}
