package fsp.java.vue.Booking;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus
@Builder
public class BookingResponseList {

    List<BookingResponse> bookingResponseList;

}
