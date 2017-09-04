package BidAppNew.services.impl;

import BidAppNew.domain.Item;
import BidAppNew.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl {

    @Autowired
    ItemRepository itemRepository;


//    public void makeBid(String id, Item item){
//        List<Item> items = new ArrayList<>();
//        itemRepository.findAll().forEach();
//        for (int i = 0; item)
//    }
}
