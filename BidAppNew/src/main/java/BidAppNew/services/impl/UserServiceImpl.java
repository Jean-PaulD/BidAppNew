package BidAppNew.services.impl;

import BidAppNew.domain.User;
import BidAppNew.repositories.UserRepository;
import BidAppNew.services.UserService;
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
    private UserService userService;
//    @Autowired
//    private EntityManager entityManager;

//    //@Override
//    public User  findbyUserName1(String u){
//
//
//        List<User> findByUserName = userService.findByUserName(u);
//
//    //        (findByUserName).extracting(Customer::getLastName).containsOnly(customer.getLastName())
//
//        //findByUserName.lastIndexOf()
//
//        return findByUserName.get(0);
//    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User findById(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public User update(String id) {
        return null;
    }
}
