package BidAppNew.domain;

import java.io.Serializable;

public class ReportUser implements Serializable {


    private String id;
    private String username;
    private int numberOfReports;

    private Item item;
//    private User user;

//    public Item getItem() {
//        return item;
//    }
//
//    public User getUser() {
//        return user;
//    }

    private ReportUser(){}

    public ReportUser(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.username = builder.username;
        this.numberOfReports = builder.numberOfReports;
//        this.item = builder.item;
//        this.user = builder.user;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public static class Builder{

        private String id;
        private String username;
        private int numberOfReports;

        private Item item;
//        private User user;

        public Builder item(Item value){
            this.item = value;
            return this;
        }

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

        public Builder numberOfReports(int value){
            this.numberOfReports = value;
            return this;
        }

        public ReportUser build(){
            return new ReportUser(this);
        }
    }
}
