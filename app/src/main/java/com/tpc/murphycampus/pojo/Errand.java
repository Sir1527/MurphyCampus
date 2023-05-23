package com.tpc.murphycampus.pojo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Errand {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String details;
    private String price;
    private String pickUpAddress;
    private String shippingAddress;
    private String addressee;
    private String addresseePhone;
    private String status;
    private int PublisherId;
    private int acceptId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPickUpAddress() {
        return pickUpAddress;
    }

    public void setPickUpAddress(String pickUpAddress) {
        this.pickUpAddress = pickUpAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getAddresseePhone() {
        return addresseePhone;
    }

    public void setAddresseePhone(String addresseePhone) {
        this.addresseePhone = addresseePhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPublisherId() {
        return PublisherId;
    }

    public void setPublisherId(int publisherId) {
        PublisherId = publisherId;
    }

    public int getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(int acceptId) {
        this.acceptId = acceptId;
    }

    @Override
    public String toString() {
        return "Errand{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", price=" + price +
                ", pickUpAddress='" + pickUpAddress + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", addressee='" + addressee + '\'' +
                ", addresseePhone='" + addresseePhone + '\'' +
                ", status='" + status + '\'' +
                ", PublisherId=" + PublisherId +
                ", acceptId=" + acceptId +
                '}';
    }
}
