package br.com.dio.exceptionHandler;

import br.com.dio.controller.response.ProblemResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class BarberShopExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(BarberShopExceptionHandler.class);

    public BarberShopExceptionHandler() {
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUncaught(final Exception ex, final WebRequest request) {
        log.error("handleUncaught: ", ex);
        var status = INTERNAL_SERVER_ERROR;

        ProblemResponse response = new ProblemResponse(
                status.value(),
                OffsetDateTime.now(),
                ex.getMessage()
        );

        return handleExceptionInternal(ex, response, new HttpHeaders(), status, request);
    }
}
