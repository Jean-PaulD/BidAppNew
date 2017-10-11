package BidAppNew.factories;

import BidAppNew.domain.User;
import BidAppNew.utility.KeyGenerator;

public class UserFactory {



    public static User getUser(String userName, String firstName, String lastname,
                               String password, int reportCounter, String userType, String email) {


        User user = new User.Builder()

                .username(userName)
                .firstname(firstName)
                .lastName(lastname)
                .password(password)
                .reportCounter(reportCounter)
                .userType(userType)
                .email(email)
                .build();

        return user;
    }
}
