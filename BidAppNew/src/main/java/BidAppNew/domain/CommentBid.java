package BidAppNew.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class CommentBid implements Serializable {

    @Id
    private String id;
    //private String StringId;
    private String username;
    private String comment;
    //relationship.
    //@ManyToOne
    private String String;
    @ManyToOne
    private User user;

    public String getString() {
        return String;
    }

    public User getUser() {
        return user;
    }

    private CommentBid(){}

    public CommentBid(Builder builder) {
        this.id = builder.id;
       // this.StringId = builder.StringId;
        this.username = builder.username;
        this.comment = builder.comment;
        this.String = builder.String;
        this.user = builder.user;
    }


    public static class Builder{


        private String id;
        private String StringId;
        private String username;
        private String comment;
        private String String;
        private User user;

        public Builder user(User value){
            this.user = value;
            return this;
        }

        public Builder String(String value){
            this.String = value;
            return this;
        }

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder StringId(String value){
            this.StringId = value;
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

//    public String getStringId() {
//        return StringId;
//    }

    public String getUsername() {
        return username;
    }

    public String getComment() {
        return comment;
    }


}
