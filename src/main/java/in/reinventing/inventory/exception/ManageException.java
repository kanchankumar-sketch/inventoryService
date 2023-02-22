package in.reinventing.inventory.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManageException {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Map<String,String> fieldvalidation(MethodArgumentNotValidException ex){
		
		Map<String,String> error=new HashMap<>();
		ex.getBindingResult().getAllErrors().stream().forEach(e->{
			FieldError fe=(FieldError)e;
			error.put(fe.getField(),fe.getDefaultMessage());
		});
		return error;
	}
}
