package kodlama.io.rentacar;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.io.rentacar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentacar.core.utilities.exceptions.ProblemDetails;
import kodlama.io.rentacar.core.utilities.exceptions.ValidationProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class RentacarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentacarApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessExceptions(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ValidationProblemDetails handleValidationExceptions(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return validationProblemDetails;
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
