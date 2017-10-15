package BidAppNew.services.impl;

import BidAppNew.domain.Item;
import BidAppNew.domain.User;
import BidAppNew.repositories.ItemRepository;
import BidAppNew.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    public Iterable<Item> addItem(Long userId,  //String higherBidder,
                           //String itemID,
                           String description,  String itemName,
                           double itemValue //,  double bidAmount
                            ){

        List<User> poster = userRepository.findById (userId);

        User poster1 = poster.get(0);


        Item item = new Item.Builder()
                //.id(itemID)
                //.bidOwnerName(highBid1.getUsername())
                .username(poster1.getUsername())
                .itemName(itemName)
                //.currentBidOwner(highBid1)
                .itemValue(itemValue)

                .description(description)
                .poster(poster1)
                .build();

        itemRepository.save(item);

        return itemRepository.findById(item.getid());
    }

    public String deleteItem(Long itemID){
        itemRepository.delete(itemRepository.findById(itemID));
        return "item "+itemID+" deleted";
    }

    public Iterable<Item> getAllItems(){
        return  itemRepository.findAll();
    }

    public void addSingleItem( String userName,  String higherBidder,
                               //String itemID,
                               String description,  String itemName,
                               double itemValue,  double bidAmount){
        List<User> poster = userRepository.findByusername(userName);
        List<User> highBid = userRepository.findByusername(higherBidder);
//        List<CommentBid> comments = commentBidRepository.findByItem(
//                itemRepository.findById(itemID).get(0)
//        );

        User poster1 = poster.get(0);
        User highBid1 = highBid.get(0);

        Item item = new Item.Builder()
                //.id(itemID)
                .itemName(itemName)
                .currentBidOwner(highBid1)
                .itemValue(itemValue)
                .bidAmount(bidAmount)
                .description(description)
                .poster(poster1)
                .build();

        itemRepository.save(item);
    }


    public List<String> getAllItemDetails(){

        List<Item> itemList = new ArrayList<>();

        itemRepository.findAll().forEach(itemList::add);

        List<String> stringListOfItems = new ArrayList<>();


        for(int i = itemList.size()-1; i >= 0; i--){

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

    public Iterable<Item> getSingleItem(Long id){
        //List<Item> item = new ArrayList<>();

        return itemRepository.findById(id);
/*
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
        return tempHolder;*/
    }

    public String bidonItem( String username,  double bidAmount,
                             Long itemId){

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

}
