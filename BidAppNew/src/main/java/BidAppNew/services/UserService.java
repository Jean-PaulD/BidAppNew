package BidAppNew.services;

import BidAppNew.domain.User;

import java.util.List;

public interface UserService extends BaseService<User, String> {

    User save(User entity);
    User findById(String id);
    User update(String id);
    //User findbyUserName(String username);
    //List<User> findByUserName(String userName);
}
