package exceptions;

public class AttendanceRecordAlreadyExistsException extends RuntimeException {
    public AttendanceRecordAlreadyExistsException(String message){
        super(message);
    }
}
