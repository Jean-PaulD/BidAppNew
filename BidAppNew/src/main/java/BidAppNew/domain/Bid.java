package BidAppNew.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Bid implements Serializable {


    private String id;
    private String username;
    private String itemID;
    private Date bidTimer;
    //relationship
    @OneToMany
    @JoinColumn(name = "User_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "Item_id")
    private Item item;

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    private Bid(){}

    public Bid(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.itemID = builder.itemID;
        this.bidTimer = builder.bidTimer;
        this.user = builder.user;
        this.item = builder.item;
    }

    public static class Builder{


        private String id;
        private String username;
        private String itemID;
        private Date bidTimer;
        private User user;
        private Item item;

        public Builder user(User value){
            this.user = value;
            return this;
        }

        public Builder item(Item value){
            this.item = value;
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

        public Builder itemID(String value){
            this.itemID = value;
            return this;
        }

        public Builder bidTimer(Date value){
            this.bidTimer = value;
            return this;
        }

        public Bid build(){
            return new Bid(this);
        }
    }




    public String getid() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getItemID() {
        return itemID;
    }

    public Date getBidTimer() {
        return bidTimer;
    }



}
