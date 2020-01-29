package kr.co.fastcampus.eatgo;

public class EmailExistedException extends RuntimeException {

    public EmailExistedException(String email) {
        super("Email is already registered : " + email);
    }
}
