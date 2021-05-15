package mx.com.tt.RegisterService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RepeatedEmailException extends RuntimeException{

    public RepeatedEmailException(String message) {
        super(message);
    }
}
