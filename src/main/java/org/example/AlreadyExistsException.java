package org.example;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(int id) {
        super("Element with id: \" + id + \" is already added");
    }
}