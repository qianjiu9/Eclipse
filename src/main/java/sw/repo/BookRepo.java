package sw.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sw.entity.Book;

public interface BookRepo extends CrudRepository<Book,Long>{
	Iterable <Book> findByTypeId(Long typeId);
	Iterable<Book> findByName(String name);
	List<Book> findByNameLike(String num);

}
