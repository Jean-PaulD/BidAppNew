package BidAppNew.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String username;
    private String firstname;
    private String lastName;
    private String password;
    private String userType;
    private int reportCounter;

    private Item item;
    private CommentBid commentBid;
    private Bid bid;
    private UserRating userRating;
    private ReportUser reportUser;


    public static class Builder{

        private String id;
        private String username;
        private String firstname;
        private String lastName;
        private String password;
        private String userType;
        private int reportCounter;

        private Item item;
        private CommentBid commentBid;
        private Bid bid;
        private UserRating userRating;
        private ReportUser reportUser;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder username(String value){
            this.username = value;
            return this;
        }

        public Builder firstname(String value){
            this.firstname = value;
            return this;
        }

        public Builder lastName(String value){
            this.lastName = value;
            return this;
        }

        public Builder password(String value){
            this.password = value;
            return this;
        }

        public Builder userType(String value){
            this.userType = value;
            return this;
        }

        public Builder reportCounter(int value){
            this.reportCounter = value;
            return this;
        }

        public Builder item(Item value){
            this.item = value;
            return this;
        }

        public Builder bid(Bid  value){
            this.bid = value;
            return this;
        }

        public Builder userRating(UserRating  value){
            this.userRating = value;
            return this;
        }

        public Builder reportUser(ReportUser  value){
            this.reportUser = value;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    private User(){}

    public User(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.firstname = builder.firstname;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.userType = builder.userType;
        this.reportCounter = builder.reportCounter;
        this.item = builder.item;
        this.commentBid = builder.commentBid;
        this.bid = builder.bid;
        this.userRating = builder.userRating;
        this.reportUser = builder.reportUser;
    }


    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public int getReportCounter() {
        return reportCounter;
    }

    public Item getItem() {
        return item;
    }

    public CommentBid getCommentBid() {
        return commentBid;
    }

    public Bid getBid() {
        return bid;
    }

    public UserRating getUserRating() {
        return userRating;
    }

    public ReportUser getReportUser() {
        return reportUser;
    }



}
