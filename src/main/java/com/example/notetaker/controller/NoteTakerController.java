package com.example.notetaker.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.example.notetaker.model.Note;
import com.example.notetaker.repository.NoteRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class NoteTakerController {

    private final NoteRepository repository;

    private static final int PAGE_SIZE = 6;

    public NoteTakerController(NoteRepository repository) {
        this.repository = repository;
    }

    @GetMapping(params = { "page" })
    List<Note> all(int page) {
        PageRequest pagable = PageRequest.of(page, PAGE_SIZE);
        Page<Note> result = repository.findAll(pagable);

        if (!result.isEmpty()) {
            return result.getContent();
        } else {
            return new LinkedList<>();
        }
    }

    @PostMapping()
    Note newNote(@RequestBody Note newNote) {
        return repository.save(newNote);
    }

    @DeleteMapping("/{id}")
    void deleteNote(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    Optional<Note> updateNote(@RequestBody Note updateNote, @PathVariable Long id) {
        return repository.findById(id).map(note -> {
            note.setTitle(updateNote.getTitle());
            note.setContent(updateNote.getContent());
            return repository.save(note);
        });
    }
}
