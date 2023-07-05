package fsp.java.vue.Booking;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service

public class BookingService {
    @Autowired
    BookingRepository bookingRepository;


    public List<Booking> getAllBooking(){
        return this.bookingRepository.findAll();
    }

    public Booking updateBooking(Booking booking){
        return this.bookingRepository.save(booking);
    }

    public Booking getBookingByNumber(int bookingNumber){
        return this.bookingRepository.getBookingByNumber(bookingNumber);
    }

    public Boolean deleteBooking(Booking booking){
        this.bookingRepository.delete(booking);
        return true;
    }


}
