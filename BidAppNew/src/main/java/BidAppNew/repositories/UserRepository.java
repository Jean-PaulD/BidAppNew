package BidAppNew.repositories;

import BidAppNew.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    List<User> findByusername(String userName);
    List<User> findById(Long id);
    List<User> findBypassword(String password);
}
