package az.edu.itbrains.accesacademyapiblog.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private Boolean succes;
    private HttpStatus httpStatus;
    private String message;

    public ApiResponse(Boolean succes,String message){
        this.succes=succes;
        this.message=message;
    }

}
