package BidAppNew.domain;

import java.io.Serializable;

public class CommentBid implements Serializable {

    private String id;
    private String itemId;
    private String username;
    private String comment;
    //relationship.
    private Item item;
    private User user;

    public Item getItem() {
        return item;
    }

    public User getUser() {
        return user;
    }

    private CommentBid(){}

    public CommentBid(Builder builder) {
        this.id = builder.id;
        this.itemId = builder.itemId;
        this.username = builder.username;
        this.comment = builder.comment;
        this.item = builder.item;
        this.user = builder.user;
    }

    public static class Builder{


        private String id;
        private String itemId;
        private String username;
        private String comment;
        private Item item;
        private User user;

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

        public Builder itemId(String value){
            this.itemId = value;
            return this;
        }

        public Builder username(String value){
            this.username = value;
            return this;
        }

        public Builder comment(String value){
            this.comment = value;
            return this;
        }

        public CommentBid build(){
            return new CommentBid(this);
        }
    }



    public String getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public String getUsername() {
        return username;
    }

    public String getComment() {
        return comment;
    }


}
