package com.luv2code.springdemo.restapp.notes;

import com.luv2code.springdemo.restapp.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesRepository extends JpaRepository<NoteEntity,Integer> {
 List <User> findByNotesid(String id);
}
