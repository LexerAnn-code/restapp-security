package com.luv2code.springdemo.restapp.rest;

import com.luv2code.springdemo.restapp.notes.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/notes")

public class NotesController{
    @Autowired
    NotesService notesService;


    @PostMapping("/user/{id}")
public void uploadNotes(@RequestBody NoteEntity notesreq, @PathVariable String id){
    ModelMapper modelMapper=new ModelMapper();
    NotesDto notesDto=modelMapper.map(notesreq,NotesDto.class);

    notesService.uploadNotes(notesDto,id);
}

}
