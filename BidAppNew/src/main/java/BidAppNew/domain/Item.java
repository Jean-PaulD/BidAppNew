package BidAppNew.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Item implements Serializable {

    @Id
    private String id;
    private String username;
    private String description;
    private String itemName;
    private double itemValue;
    private double bidAmount;

    @OneToMany
    private List<CommentBid> comment;
    @ManyToOne
    private User currentBidOwner;

    @ManyToOne
    private User poster;

    public double
    getBidAmount() {
        return bidAmount;
    }

    public User getUser() {
        return poster;
    }

    private Item(){}

    public Item(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.description = builder.description;
        this.itemName = builder.itemName;
        this.itemValue = builder.itemValue;
        this.currentBidOwner = builder.currentBidOwner;
        this.comment = builder.comment;
        this.poster = builder.poster;
        this.bidAmount = builder.bidAmount;

    }

    public static class Builder {


        private String id;
        private String username;
        private String description;
        private String itemName;
        private double itemValue;
        private User currentBidOwner;
        private List<CommentBid> comment;
        private User poster;
        private double bidAmount;

        public Builder bidAmount(double value){
            this.bidAmount = value;
            return this;
        }

        public Builder poster(User value){
            this.poster = value;
            return this;
        }

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder username(String value){
            this.username = value;
            return this;
        }

        public Builder description(String value){
            this.description = value;
            return this;
        }

        public Builder itemName(String value){
            this.itemName = value;
            return this;
        }

        public Builder itemValue(double value){
            this.itemValue = value;
            return this;
        }

        public Builder currentBidOwner(User value){
            this.currentBidOwner = value;
            return this;
        }

        public Builder comment(List<CommentBid> value){
            this.comment = value;
            return this;
        }


        public Item build(){
            return new Item(this);
        }
    }



    public String getid() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemValue() {
        return itemValue;
    }

    public User getCurrentBidOwner() {
        return currentBidOwner;
    }

    public List<CommentBid> getComment() {
        return comment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
