package fsp.java.vue.Booking;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "BOOKING")

   public class Booking implements Serializable {
        @Id
        @Column
        private int number;
        @Column
        private String customer;

    public Booking(int number, String customer) {
        this.number = number;
        this.customer = customer;
    }

    public int getNumber() {
        return number;
    }

    public String getCustomer() {
        return customer;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}

