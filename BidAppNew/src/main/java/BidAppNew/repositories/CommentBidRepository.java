package BidAppNew.repositories;

import BidAppNew.domain.CommentBid;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentBidRepository extends CrudRepository<CommentBid, String> {

    public List<CommentBid> getCommentBidsByItem(String id);
}
