package BidAppNew.services.impl;

import BidAppNew.domain.CommentBid;
import BidAppNew.repositories.CommentBidRepository;
import BidAppNew.services.CommentBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentBidServiceImpl implements CommentBidService {

    @Autowired
    private CommentBidRepository commentBidRepository;


//    public List<CommentBid> getAllCommentsForItem(String id){
//        List<CommentBid> comments = new ArrayList<>();
//        //commentBidRepository.findBy
//        commentBidRepository.findAll().forEach(comments::add);
//        return comments;
//    }

}
