package weapon.db.controller.error;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {
	
@ResponseStatus(code = HttpStatus.NOT_FOUND)
@ExceptionHandler(NoSuchElementException.class)
public Map<String, String> NoSuchElementExceptionHandler(NoSuchElementException e) {
	log.info("No Such Element Exception happened", e.getMessage());
	Map <String, String> errMap = Map.of("message", e.toString());
	return errMap;
} // NSEEH
	
}// CLASS
