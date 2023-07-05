package fsp.java.vue.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByBookingName(String bookingName);

    Booking getBookingByNumber(int number);


}
