package BidAppNew.domain;

import javax.persistence.Id;
import java.io.Serializable;

public class Item implements Serializable {

    private String id;
    private String username;
    private String description;
    private String itemName;
    private double itemValue;
    private String currentBidOwner;
    private String comment;

//    private User user;

//    public User getUser() {
//        return user;
//    }

    private Item(){}

    public Item(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.description = builder.description;
        this.itemName = builder.itemName;
        this.itemValue = builder.itemValue;
        this.currentBidOwner = builder.currentBidOwner;
        this.comment = builder.comment;
//        this.user = builder.user;

    }

    public static class Builder {


        private String id;
        private String username;
        private String description;
        private String itemName;
        private double itemValue;
        private String currentBidOwner;
        private String comment;
//        private User user;

//        public Builder user(User value){
//            this.user = value;
//            return this;
//        }

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

        public Builder currentBidOwner(String value){
            this.currentBidOwner = value;
            return this;
        }

        public Builder comment(String value){
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

    public String getCurrentBidOwner() {
        return currentBidOwner;
    }

    public String getComment() {
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
