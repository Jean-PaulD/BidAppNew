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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //check all comments under a certain item
    //get all items and their details
    @GetMapping(path="/allItemDetails")
    public @ResponseBody List<String> getAllItemDetails() {

        List<Item> itemDetails = new ArrayList<>();

        List<Item> itemList = new ArrayList<>();

        itemRepository.findAll().forEach(itemList::add);

        List<String> stringListOfItems = new ArrayList<>();


        for(int i = itemList.size()-1; i >= 0; i--){
//            Item tempItem = new Item.Builder()
//                    .id(itemList.get(i).getid())
//                    .username(itemList.get(i).getUser().getUsername())
//                    .itemName(itemList.get(i).getItemName())
//                    .description(itemList.get(i).getDescription())
//                    .itemValue(itemList.get(i).getItemValue())
//                    .bidAmount(itemList.get(i).getBidAmount())
//                    .bidOwnerName(itemList.get(i).getCurrentBidOwner().getUsername())
//                    .comment(itemList.get(i).getComment())
//                    .build();

                    String tempHolder = "---------- Item{" +
                    "id='" + itemList.get(i).getid() + '\'' +
                    ", username='" + itemList.get(i).getUser().getUsername() + '\'' +
                    ", description='" + itemList.get(i).getDescription() + '\'' +
                    ", item Name='" + itemList.get(i).getItemName() + '\'' +
                    ", item Value=" + itemList.get(i).getItemValue() +
                    ", bid Amount=" + itemList.get(i).getBidAmount() +
                    ", comment=" + itemList.get(i).getComment() +
                    ", Highest Bidder=" + itemList.get(i).getCurrentBidOwner().getUsername() +
                    " " +
                    '}';


                    stringListOfItems.add(tempHolder);
        }

        return stringListOfItems;
    }


    @GetMapping(path="/allItems")
    public @ResponseBody Iterable<Item> getAllItems() {
        return itemRepository.findAll();
    }

    //finditem by name
    @GetMapping(path="/getSingleItem")
    public @ResponseBody Iterable<Item> getOneItem(@RequestParam String id) {
        //return new Gson().toJson(itemRepository);

        List<Item> item = new ArrayList<>();

        itemRepository.findById(id).forEach(item::add);

        String tempHolder = "---------- Item{" +
                "id='" + item.get(0).getid() + '\'' +
                ", Poster='" + item.get(0).getUser().getUsername() + '\'' +
                ", description='" + item.get(0).getDescription() + '\'' +
                ", item Name='" + item.get(0).getItemName() + '\'' +
                ", item Value=" + item.get(0).getItemValue() +
                ", bid Amount=" + item.get(0).getBidAmount() +
                ", comment=" + item.get(0).getComment() +
                ", Highest Bidder=" + item.get(0).getCurrentBidOwner().getUsername() +
                " " +
                '}';

        return itemRepository.findById(id);
    }

    @GetMapping(path="/BidOnOneitem")
    public @ResponseBody String bidOnItem(@RequestParam String username, @RequestParam double bidAmount,
                                                      @RequestParam String itemId) {

        List<User> oldUser = userRepository.findByusername(username);
        List<Item> oldItem = itemRepository.findById(itemId);
        String bidApprovedMessage = "bid not approved";

        if(bidAmount > oldItem.get(0).getBidAmount()){

            Item item = new Item.Builder()
                    .id(oldItem.get(0).getid())
                    .bidOwnerName(oldItem.get(0).getBidOwnerName())
                    .currentBidOwner(oldUser.get(0))
                    .bidAmount(bidAmount)
                    .poster(oldUser.get(0))
                    .username(oldUser.get(0).getUsername())
                    .itemValue(oldItem.get(0).getItemValue())
                    .build();

            itemRepository.save(item);
            bidApprovedMessage = "bid for R" + bidAmount+" has been approved";
        }
        return bidApprovedMessage;
    }

    @GetMapping(path="/deleteItem")
    public @ResponseBody String deleteItem(@RequestParam String itemID) {
        //return new Gson().toJson(itemRepository);
        itemRepository.delete(itemRepository.findById(itemID));
        return "item "+itemID+" deleted";
    }

    @GetMapping(path="/getcomments")
    public @ResponseBody Iterable<Item> getComments(@RequestParam String OP) {
        //return new Gson().toJson(itemRepository);
        return itemRepository.findItemsByItemName(OP);
    }



}
