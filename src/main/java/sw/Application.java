package sw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sw.repo.BookRepo;
import sw.repo.TypeRepo;
import sw.entity.Book;
import sw.entity.Type;


@SpringBootApplication
public class Application {
	
	@Autowired
	private TypeRepo typeRepo;
	@Autowired
	private BookRepo bookRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    //备忘关于调试出现 “throw new SilentExitException()” 异常的不得已处理方法
    //toggle the "suspend execution on uncaught exceptions" checkbox in 
    //Java -> Debug preferences to prevent it from happening.
    
    //本项目用下面方法初始化数据库数据，防止应用程序每次启动后内存数据库都没有数据
	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
//			typeRepo.save(new Type("LS","历史类","历史文化"));
			Type type1=new Type("LS","历史类","历史文化");
//			typeRepo.save(new Type("KX","科学类","现代科学"));
			Type type2=new Type("KX","科学类","现代科学");
//			typeRepo.save(new Type("WX","文学类","文字作品"));
			Type type3=new Type("WX","文学类","文字作品");
			Type type4=new Type("WY","外语类","外国语言");
			
			typeRepo.save(type1);
			typeRepo.save(type2);
			typeRepo.save(type3);
			typeRepo.save(type4);
			Book book1=new Book("GMMT","乖,摸摸头","大冰","穷游故事");
			Book book2=new Book("SHL","撒哈拉沙漠的故事","三毛","撒哈拉沙漠的生活");
			Book book3=new Book("LSWH","历史文化","张三","中国历史文化");
			Book book4=new Book("SJJS","时间简史","霍金","关于宇宙的最前沿");
			Book book5=new Book("SHN","茶花女","小仲马","一个交际花凄婉的爱情故事");
			
			book1.setType(type3);book1.setCount(5);
			book2.setType(type3);book2.setCount(10);
			book3.setType(type1);book3.setCount(5);
			book4.setType(type2);book4.setCount(20);
			book5.setType(type4);book5.setCount(10);
			
			bookRepo.save(book1);
			bookRepo.save(book2);
			bookRepo.save(book3);
			bookRepo.save(book4);
			bookRepo.save(book5);
//			book1.setCount();
					};
    }

}
