package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Messages {


    private String title;
    private String body;
    private User sender;
    private User receiver;
    private User status;

}
