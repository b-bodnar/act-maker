package src.b.bodnar.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Apartment {

    private  String flor;
    private  String section;
    private  String apartmentNumber;
    private  String countRooms;
    private  String totalArea;
    private  String livingArea;
}
