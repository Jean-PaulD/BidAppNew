package BidAppNew.controller;

import BidAppNew.services.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.annotation.WebServlet;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo")
//@WebServlet(name = "GetItems", urlPatterns = {"/demo"})
public class NewItemController {

    @Autowired
    ItemServiceImpl itemService;

    @GetMapping(path="/addItemNew") // Map ONLY GET Requests
    public @ResponseBody
    String addNewItem ( @RequestParam String userName, @RequestParam  String higherBidder,
                       @RequestParam String itemID,
                       @RequestParam String description, @RequestParam String itemName,
                       @RequestParam double itemValue, @RequestParam double bidAmount){



        return itemService.addItem(userName,higherBidder, itemID, description, itemName, itemValue, bidAmount);
    }


}
