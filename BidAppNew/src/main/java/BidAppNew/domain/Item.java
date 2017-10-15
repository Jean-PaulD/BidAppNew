package BidAppNew.domain;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Item implements Serializable {

    @Id
    @Expose
    @GeneratedValue
    private Long id;
    @Expose
    private String username;
    @Expose
    private String description;
    @Expose
    private String itemName;
    @Expose
    private double itemValue;
    @Expose
    private double bidAmount;
    @Expose
    private String bidOwnerName;

    @OneToMany
    @Expose
    private List<CommentBid> comment;
    @ManyToOne
    @Expose
    private User currentBidOwner;

    @ManyToOne
    @Expose
    private User poster;

    public String getBidOwnerName() {
        return bidOwnerName;
    }

    public double
    getBidAmount() {
        return bidAmount;
    }

    public User getUser() {
        return poster;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", username='" + poster.getUsername() + '\'' +
                ", description='" + description + '\'' +
                ", item Name='" + itemName + '\'' +
                ", item Value=" + itemValue +
                ", bid Amount=" + bidAmount +
                ", comment=" + comment +
                ", Highest Bidder=" + currentBidOwner.getUsername() +
                "," +
                '}';
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
        this.bidOwnerName = builder.bidOwnerName;

    }

    public static class Builder {


        private Long id;
        private String username;
        private String description;
        private String itemName;
        private double itemValue;
        private User currentBidOwner;
        private List<CommentBid> comment;
        private User poster;
        private double bidAmount;
        private String bidOwnerName;

        public Builder bidOwnerName(String value){
            this.bidOwnerName = value;
            return this;
        }

        public Builder bidAmount(double value){
            this.bidAmount = value;
            return this;
        }

        public Builder poster(User value){
            this.poster = value;
            return this;
        }

        public Builder id(Long value){
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



    public Long getid() {
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
