package model;


import enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Groups {

    private Long id;
    private String name;
    private Role admin;
    private User owner;
    private Role user;
    private List<User> users;





}
