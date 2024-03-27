package tn.bal.pi.handlers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tn.bal.pi.exceptions.ObjectValidationException;
import tn.bal.pi.exceptions.OperationNonPremittedExceptions;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectValidationException.class)
    public ResponseEntity<ExceptionRepresentation> handleException(ObjectValidationException exception){
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage("Object not valid exception has occured")
                .errorSource(exception.getViolationSource())
                .validationErros(exception.getViolations())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(representation);

    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionRepresentation> handleNotFoundException(EntityNotFoundException exception){
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage("entity not found "+exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(representation);
    }
    @ExceptionHandler(OperationNonPremittedExceptions.class)
    public ResponseEntity<ExceptionRepresentation> handleoperationNotPermittedException(OperationNonPremittedExceptions exception){
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage(exception.getErrorMsg())
                .errorSource(exception.getSource())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(representation);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionRepresentation> handledataIntegrityViolationException(){
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage("a user already exist with that email")
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(representation);
    }
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ExceptionRepresentation> handleusernameNotFoundException(UsernameNotFoundException exception){
        ExceptionRepresentation representation =  ExceptionRepresentation.builder()
                .errorMessage(exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(representation);
    }
    /*@ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity<ExceptionRepresentation> classNotFoundException(ClassNotFoundException exception){
        ExceptionRepresentation representation =  ExceptionRepresentation.builder()
                .errorMessage(exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(representation);
    }*/

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<ExceptionRepresentation> handledisabledException(){
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage("you cannot acces your account please activate it")
                .build();
        return  ResponseEntity.status(HttpStatus.FORBIDDEN).body(representation);
    }
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionRepresentation> handlebadCredentialsException(BadCredentialsException e){
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage("bad credentials please try again")
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(representation);
    }
}
