package fsp.java.vue.Booking;

import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Builder
public class BookingMapper {
    public BookingResponse fromBooking(Booking booking){
        return BookingResponse.builder()
                .customer(booking.getCustomer())
                .number(booking.getNumber())
                .build();
    }

    public BookingResponseList fromBookingList(List<Booking> bookingList){
        return BookingResponseList.builder()
                .bookingResponseList(bookingList.stream().map(this::fromBooking).collect(Collectors.toList()))
                .build();
    }

    public Booking editBooking(Booking booking, BookingUpdateRequest bookingUpdateRequest){
        booking.setNumber(bookingUpdateRequest.getNumber());
        booking.setCustomer(bookingUpdateRequest.getCustomer());

        return booking;
    }
}
