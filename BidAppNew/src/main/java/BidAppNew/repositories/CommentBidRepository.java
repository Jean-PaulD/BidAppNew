package BidAppNew.repositories;

import BidAppNew.domain.CommentBid;
import BidAppNew.domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentBidRepository  extends CrudRepository<CommentBid, String> {

//    public List<CommentBid> getCommentBidsByItem(String id);
//    public List<CommentBid> findByUsername(String name);
//    public List<CommentBid> findByItem(Item item);
}
