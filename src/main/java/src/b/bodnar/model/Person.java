package src.b.bodnar.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

    private String fullName;
    private String passport;
    private String address;
    private String taxID;
    private Apartment apartment;
}
