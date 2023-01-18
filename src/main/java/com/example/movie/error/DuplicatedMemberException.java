package com.example.movie.error;


public class DuplicatedMemberException extends RuntimeException {

    public DuplicatedMemberException(String message) {
        super(message);
    }
}
