package com.example.notetaker.repository;

import java.util.List;

import com.example.notetaker.model.Note;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note, Long> {
    List<Note> findByTitle(String title);

    Note findById(long id);
}
