package sw.repo;

import org.springframework.data.repository.CrudRepository;

import sw.entity.Type;

public interface TypeRepo extends CrudRepository<Type,Long>{
	
}
