package BidAppNew.domain;

import java.io.Serializable;

public class UserRating implements Serializable {


    private String id;
    private String username;
    private int rating;
    private User user;



    private UserRating(){}

    public UserRating(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.rating = builder.rating;
        this.user = builder.user;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getRating() {
        return rating;
    }

    public User getUser() {
        return user;
    }

    public static class Builder{

        private String id;
        private String username;
        private int rating;
        private User user;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder username(String value){
            this.username = value;
            return this;
        }

        public Builder rating(int value){
            this.rating = value;
            return this;
        }

        public Builder user(User value){
            this.user = value;
            return this;
        }

        public UserRating build(){
            return new UserRating(this);
        }
    }


}
