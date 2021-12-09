package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data       // bu getter, setter, toString uchun
@AllArgsConstructor         // hamma parametrlari bor constructor
@NoArgsConstructor          // parametrlarsiz constructor
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
