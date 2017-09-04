package BidAppNew.factories;

import BidAppNew.domain.User;
import BidAppNew.utility.KeyGenerator;

public class UserFactory {



    public static User getUser(String id, String userName, String firstName, String lastname,
                               String password, int reportCounter, String userType) {


        User user = new User.Builder()
                .id(id)
                .username(userName)
                .firstname(firstName)
                .lastName(lastname)
                .password(password)
                .reportCounter(reportCounter)
                .userType(userType)
                .build();

        return user;
    }
}
