package br.com.dio.exeption;

public class EmailInUseExeption extends RuntimeException {
    public EmailInUseExeption(String message) {
        super(message);
    }
}
