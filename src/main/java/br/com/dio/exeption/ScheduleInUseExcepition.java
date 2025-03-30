package br.com.dio.exeption;

public class ScheduleInUseExcepition extends RuntimeException {
    public ScheduleInUseExcepition(String message) {
        super(message);
    }
}
