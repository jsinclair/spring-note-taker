package com.example.notetaker.exception;

public class NoteNotFoundException extends RuntimeException {
    NoteNotFoundException(Long id) {
        super("Could not find note with ID: " + id);
    }
}
