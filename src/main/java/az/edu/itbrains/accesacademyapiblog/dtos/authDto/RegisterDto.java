package az.edu.itbrains.accesacademyapiblog.dtos.authDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String passwordRepeat;
}
