package BidAppNew.controller;

import BidAppNew.domain.Item;
import BidAppNew.services.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo")
//@WebServlet(name = "GetItems", urlPatterns = {"/demo"})
public class NewItemController {

    @Autowired
    ItemServiceImpl itemService;

    @CrossOrigin
    @GetMapping(path="/addItemNew") // Map ONLY GET Requests
    public @ResponseBody
    Iterable<Item> addNewItem ( @RequestParam Long userID,
                       //@RequestParam String itemID,
                       @RequestParam String description, @RequestParam String itemName,
                       @RequestParam double itemValue){

       return itemService.addItem(userID, description, itemName, itemValue);

    }

    @CrossOrigin
    @GetMapping(path="/getOneItem") // Map ONLY GET Requests
    public @ResponseBody
    Iterable<Item> getOneItem (@RequestParam Long itemID){
        return itemService.getSingleItem(itemID);
    }


}
