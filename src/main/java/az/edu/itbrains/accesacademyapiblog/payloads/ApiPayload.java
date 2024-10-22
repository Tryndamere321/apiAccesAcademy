package az.edu.itbrains.accesacademyapiblog.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiPayload<T> {
    private Boolean succes;
    private List<T> data;
    private HttpStatus httpStatus;


    public ApiPayload(Boolean succes, HttpStatus httpStatus) {
        this.succes = succes;
        this.httpStatus = httpStatus;
    }

}
