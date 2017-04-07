package be.seamless.demo.entity;


import javax.json.Json;
import javax.json.JsonObject;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Concert {

    private Long id;
    private String artist;
    private String venue;
    private LocalDateTime startTime;

    public Concert(Long id, String artist, String venue, LocalDateTime startTime) {

        this.id = id;
        this.artist = artist;
        this.venue = venue;
        this.startTime = startTime;
    }

    public JsonObject toJsonObject() {

        return Json.createObjectBuilder().add("id", this.getId()).
                add("artist", this.getArtist()).
                add("venue", this.getVenue()).
                add("starttime", this.getStartTime().atZone(ZoneId.of("Europe/Brussels")).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)).
                build();
    }


    public Long getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getVenue() {
        return venue;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}
