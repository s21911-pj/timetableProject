package pl.pjatk.timetable.exception;

public class TimetableExceptions extends RuntimeException {

    public TimetableExceptions(Long message) {
        super(message + " not found");
    }
}
