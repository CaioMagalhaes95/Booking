package fsp.java.vue.Booking;

import lombok.Builder;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.intellij.lang.annotations.Pattern;

@Data

@Builder
public class BookingResponse {

    @NotNull
    String customer;

    @NotNull
    Integer number;



}
