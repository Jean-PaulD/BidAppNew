package BidAppNew.repositories;

import BidAppNew.domain.Item;
import BidAppNew.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, String>
{

   public List<Item> findItemByusername(String username);
   public List<Item> findById(Long id);
   public List<Item> findItemsByItemName(String name);
   public List<Item> deleteById(Long id);
}
