package model;

import enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Boolean status;
    private Role role;
    private boolean signedIn;



    @Override
    public String toString() {
        String status = this.status ?"active":"blocked";
        return String.format("%1$-5s", id) +
                String.format("%1$-10s", firstname) +
                String.format("%1$-15s", lastname) +
                String.format("%1$-25s", email) +
                String.format("%1$-15s", password) +
                String.format("%1$-15s", role) +
                String.format("%1$-15s", status);
    }


    // Id       Name            Email               Role    Status
    // 1        Ali Valiev      ali@gmail.com       admin   active

    public boolean validateEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();


    }

    public void activate(){
         setStatus(true);
    }
    public void deactivate(){
        setStatus(false);
    }

}
