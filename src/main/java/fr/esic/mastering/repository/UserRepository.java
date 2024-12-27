package fr.esic.mastering.repository;
 
import java.util.Optional;
 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
 
import fr.esic.mastering.entities.User;
 
public interface UserRepository extends CrudRepository<User, Long> {
	public Optional<User> findByEmailAndPassword(String email, String password);
	
	@Query("select u from User u where u.email = ?1 and u.password = ?2 ")
	public Optional<User> getByLoginAndPassword(String email, String password);
 
 
}