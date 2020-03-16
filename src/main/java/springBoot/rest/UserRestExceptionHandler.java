package springBoot.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserRestExceptionHandler {

    // Add an exception handler for UserNotFoundException

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handlerException(UserNotFoundException exc) {

        // create UserErrorResponse

        UserErrorResponse error = new UserErrorResponse(
                                        HttpStatus.NOT_FOUND.value(),
                                        exc.getMessage(),
                                        System.currentTimeMillis());
        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //Add another exception handler ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handlerException(Exception exc) {
        // create UserErrorResponse
        UserErrorResponse error = new UserErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
