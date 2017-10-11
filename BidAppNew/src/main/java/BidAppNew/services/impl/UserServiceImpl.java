package BidAppNew.services.impl;

import BidAppNew.domain.User;
import BidAppNew.repositories.UserRepository;
import BidAppNew.services.UserService;
import com.sun.javafx.collections.ArrayListenerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
//
//    User user = new User.Builder()
//            .id(oldItem.get(0).getid())
//            .firstname(oldUser.get(0).getFirstname())
//            .lastName(oldUser.get(0).getLastName())
//            .password(oldUser.get(0).getPassword())
//            .userType(oldUser.get(0).getUserType())
//            .reportCounter(oldUser.get(0).getReportCounter())
//            .username(oldUser.get(0).getUsername())
//
    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User findById(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public User update(String id, User entity) {
        return userRepository.save(entity);
    }
}
