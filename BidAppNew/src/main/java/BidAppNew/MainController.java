package BidAppNew;

import BidAppNew.domain.Item;
import BidAppNew.domain.User;
import BidAppNew.factories.UserFactory;
import BidAppNew.repositories.UserRepository;
import BidAppNew.services.UserService;
import BidAppNew.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {

    private int reportCounter;
    private String userType;


    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;
    private UserServiceImpl userServiceImpl;

    @CrossOrigin
    @GetMapping(path="/createNewUser") // Map ONLY GET Requests
    public @ResponseBody
    Iterable<User> addNewUser2 (@RequestParam String userName, @RequestParam String firstName, @RequestParam String lastname,
                        @RequestParam String password, @RequestParam int reportCounter, @RequestParam String userType,
                           @RequestParam String email ) {


        /*this.reportCounter = 0;
        reportCounter = this.reportCounter;
        this.userType = "Normal";
        userType = this.userType;*/
        User user = UserFactory.getUser(userName, firstName, lastname, password, reportCounter, userType, email);

        List<User> findUserName = userRepository.findByusername(userName);

        if(findUserName.size() == 0){

            userRepository.save(user);
            findUserName = userRepository.findByusername(userName);
        }
        else {
            findUserName.clear();
        }
        return findUserName;
    }


    /*
    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser ( @RequestParam String userName, @RequestParam String firstName, @RequestParam String lastname,
                       @RequestParam String password, @RequestParam int reportCounter, @RequestParam String userType) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        //Country country = CountryFactory.buildCountry(countryName);
        //countryService.save(country);
        //return new Gson().toJson(country);

        User user = UserFactory.getUser(userName, firstName, lastname, password, reportCounter, userType, email);
//        User user2 = UserFactory.getUser("Username1", "Jean", "Paul", "1234",
//                4, "admin");
//        localhost:8080/demo/add?userName=John&firstName=John1&lastname=Paul1&password=1234&reportCounter=3&userType=admin1
//        localhost:8080/demo/add?userName=Abraham&firstName=Abraham1&lastname=Paul1&password=1234&reportCounter=3&userType=admin1
//        localhost:8080/demo/add?userName=lincoln&firstName=lincoln1&lastname=Paul1&password=1234&reportCounter=3&userType=admin1
//        localhost:8080/demo/add?userName=Leon&firstName=Leon1&lastname=Paul1&password=1234&reportCounter=3&userType=admin1
//        localhost:8080/demo/add?userName=Justin&firstName=Justin1&lastname=Paul1&password=1234&reportCounter=3&userType=admin1
//        localhost:8080/demo/add?userName=Lorenzo&firstName=Lorenzo1&lastname=Paul2&password=1234&reportCounter=3&userType=admin2
//        localhost:8080/demo/add?userName=banna&firstName=banna1&lastname=Paul3&password=1234&reportCounter=3&userType=admin3
//        localhost:8080/demo/add?userName=Brian&firstName=Brian1&lastname=Paul4&password=1234&reportCounter=3&userType=admin4



        userRepository.save(user);
        return "Saved";
    }
    */

    @CrossOrigin
    @GetMapping(path="/allUserNames")
    public @ResponseBody Iterable<String> getAllUserNames() {
        // This returns a JSON or XML with the users

        List<User> userList = new ArrayList<>();

        userRepository.findAll().forEach(userList::add);

        List<String> stringListOfItems = new ArrayList<>();

        for(int i = userList.size()-1; i >= 0; i--){

            String tempHolder = "---------- User{" +
                    "id='" + userList.get(i).getId() + '\'' +
                    ", username='" + userList.get(i).getUsername() + '\'' +
                    "First Name: " + userList.get(i).getFirstname()  + '\'' +

                    '}';


            stringListOfItems.add(tempHolder);
        }

        //return userRepository.findAll();
        //return userRepository.findAll();
        return stringListOfItems;
        //return userServiceImpl.findbyUserName("username99");
    }

    @CrossOrigin
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users

        //return userRepository.findAll();
        return userRepository.findAll();
        //return userServiceImpl.findbyUserName("username99");
    }

    //get all items
//    @GetMapping(path="/allItems")
//    public @ResponseBody Iterable<Item> getAllItems(){
//        return
//    }

    @CrossOrigin
    @GetMapping(path="/deleteUser")
    public @ResponseBody String deleteUser(@RequestParam String userName) {
        //return new Gson().toJson(itemRepository);
        userRepository.delete(userRepository.findByusername(userName));

        return "User "+userName+" deleted";
        //return itemService.deleteItem(itemID);
    }

    @CrossOrigin
    @GetMapping(path="/login")
    public @ResponseBody Iterable<User> getLoginDetails(@RequestParam String userName, @RequestParam String password) {

        List<User> findUserName = userRepository.findByusername(userName);
        List<User> findUserName2;


        String tempPassowrd = "";
        if (findUserName.size() != 0){
            tempPassowrd = findUserName.get(0).getPassword()+"";
        }

        if(tempPassowrd.equals(password) ){
            findUserName2 = userRepository.findByusername(userName);
        }
        else {
            findUserName2 =  userRepository.findByusername("not found");
        }

        return findUserName2;

    }

    @CrossOrigin
    @GetMapping(path="/username")
    public @ResponseBody Iterable<User> getUserName(String id) {

        List<User> findUserName = userRepository.findByusername(id);



        return findUserName;

    }



}
