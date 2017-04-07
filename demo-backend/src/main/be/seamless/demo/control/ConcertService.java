package be.seamless.demo.control;


import be.seamless.demo.entity.Concert;

import javax.ejb.Stateless;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@Stateless
public class ConcertService {


    public List<Concert> getAllConcerts() {
        System.out.println("ZoneId.default() = " + ZoneId.systemDefault());
        List<Concert> concerts = new ArrayList<>();
        concerts.add(new Concert(1L, "Ed Sheeran", "Brussels", LocalDateTime.of(2017, 6, 5, 20, 00)));
        concerts.add(new Concert(2L, "Muse", "Werchter", LocalDateTime.of(2017, 6, 30, 10, 30)));
        concerts.add(new Concert(3L, "Lady Gaga", "Antwerp", LocalDateTime.of(2017, 10, 25, 20, 00)));

        return concerts;
    }

}
