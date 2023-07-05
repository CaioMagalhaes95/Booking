package fsp.java.vue.Booking;

import jakarta.persistence.Column;

public class BookingUpdateRequest {

    @Column
    private int number;
    @Column
    private String customer;

    public BookingUpdateRequest(int number, String customer) {
        this.number = number;
        this.customer = customer;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
