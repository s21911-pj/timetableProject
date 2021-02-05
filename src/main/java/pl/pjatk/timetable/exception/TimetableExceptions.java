package pl.pjatk.timetable.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TimetableExceptions extends RuntimeException {

    public TimetableExceptions(Long message) {
        super(message + " not found");
    }
}
