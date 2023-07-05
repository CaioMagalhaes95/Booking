package fsp.java.vue.Booking;
import fsp.java.vue.Booking.BookingService;
import org.intellij.lang.annotations.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import javax.management.RuntimeErrorException;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

@RestController
@RequestMapping("/Booking")
public class Controller {
    @Autowired
    BookingService bookingService;

    @Autowired
    BookingMapper bookingMapper;

    @GetMapping
    public ResponseEntity<BookingResponseList> getBooking(){
       List<Booking> bookings = bookingService.getAllBooking();
       BookingResponseList bookingMapper = this.bookingMapper.fromBookingList(bookings);

       return new ResponseEntity<>(bookingMapper, HttpStatus.OK);
   }

   @PutMapping(path="{booking}")
   public ResponseEntity<BookingResponse> updateBookings(@RequestBody BookingUpdateRequest bookingUpdateRequest, int bookingNumber){
        Booking bookingToEdit = this.bookingService.getBookingByNumber(bookingNumber);

        if (bookingToEdit != null){
            Booking bookingMapper = this.bookingMapper.editBooking(bookingToEdit, bookingUpdateRequest);
            Booking booking = bookingService.updateBooking(bookingMapper);

            BookingResponse bookingResponse = this.bookingMapper.fromBooking(booking);
            return new ResponseEntity<>(bookingResponse, HttpStatus.ACCEPTED);
        }
        else{
            return null;
        }

   }


   @DeleteMapping(path="/{booking}")
    public ResponseEntity<Void> deleteBooking(@PathVariable int booking) {

       Booking bookingToDelete = this.bookingService.getBookingByNumber(booking);

       if (bookingToDelete != null) {
           this.bookingService.deleteBooking(bookingToDelete);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       else {
           throw new Error();
       }
   }

   @PostMapping(path="/Booking")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Booking create(@RequestBody Booking booking){
        return this.bookingService.updateBooking(booking);
   }



}
