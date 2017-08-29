package BidAppNew.controller;

import BidAppNew.domain.CommentBid;
import BidAppNew.domain.Item;
import BidAppNew.domain.User;
import BidAppNew.factories.UserFactory;
import BidAppNew.repositories.CommentBidRepository;
import BidAppNew.repositories.ItemRepository;
import BidAppNew.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private CommentBidRepository commentBidRepository;

    @GetMapping(path="/addItem") // Map ONLY GET Requests
    public @ResponseBody
    String addNewItem (@RequestParam String userName, @RequestParam  String higherBidder,
                       @RequestParam String itemID,
                       @RequestParam String description, @RequestParam String itemName,
                       @RequestParam double itemValue, @RequestParam double bidAmount){

        //localhost:8080/demo/addItem?userName=Abraham&higherBidder=Leon&itemID=item100&description=This_is_a_toilet&itemName=Toilet&itemValue=3000&bidAmount=3500


        List<User> poster = userRepository.findByusername(userName);
        List<User> highBid = userRepository.findByusername(higherBidder);
//        List<CommentBid> comments = commentBidRepository.findByItem(
//                itemRepository.findById(itemID).get(0)
//        );

        User poster1 = poster.get(0);
        User highBid1 = highBid.get(0);

        Item item = new Item.Builder()
                .id(itemID)
                .itemName(itemName)
                .currentBidOwner(highBid1)
                .itemValue(itemValue)
                .bidAmount(bidAmount)
                .description(description)
                .poster(poster1)
                .build();

        itemRepository.save(item);
        return "item saved";
    }




    @GetMapping(path="/allItems")
    public @ResponseBody Iterable<Item> getAllUsers() {
        return itemRepository.findAll();
    }



}
