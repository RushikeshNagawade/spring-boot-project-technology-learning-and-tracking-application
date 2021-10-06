package technology.learning.and.tracking.application.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(UsernamePasswordInvalidException.class)
	public final ResponseEntity<Object> handleUsernamePasswordInvalidException() {
		LOG.error("handleUsernamePasswordInvalidException");
		return new ResponseEntity<Object>("Invalid username and Password", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidUserLoginException.class)
	public final ResponseEntity<Object> handleInvalidUserLoginExceptionException() {
		LOG.error("handleInvalidUserLoginExceptionException");
		return new ResponseEntity<Object>("Invalid user login", HttpStatus.NOT_FOUND);
	}

	// create more methods to handle other custom exceptions
	
	@ExceptionHandler(IdNotFoundException.class)
	public final ResponseEntity<Object> handleIdNotFoundException() {
		LOG.error("handleIdNotFoundException");
		return new ResponseEntity<Object>("Id Not Found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	public final ResponseEntity<Object> handleEmailNotFoundException() {
		LOG.error("handleEmailNotFoundException");
		return new ResponseEntity<Object>("Email Not Found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CourseNotFoundException.class)
	public final ResponseEntity<Object> handleCourseNotFoundException() {
		LOG.error("handleCoursenotFoundException");
		return new ResponseEntity<Object>("Course Not Found", HttpStatus.NOT_FOUND);
	}
}
