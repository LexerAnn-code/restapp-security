package com.luv2code.springdemo.restapp.notes;

import com.luv2code.springdemo.restapp.auth.User;
import com.luv2code.springdemo.restapp.auth.UserAuthRespository;
import com.luv2code.springdemo.restapp.auth.UserAuthService;
import com.luv2code.springdemo.restapp.dto.Util;
import com.luv2code.springdemo.restapp.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServiceImpl implements  NotesService{

    @Autowired
    Util util;
    @Autowired
    NotesRepository notesRepository;
    @Autowired
    UserAuthRespository userAuthRespository;
//    @Override
//    public void uploadNotes(NotesDto notesDto) {
//        ModelMapper modelMapper=new ModelMapper();
//        notesDto.setNotesid(util.generateUserId(10));
//        NoteEntity noteEntity=modelMapper.map(notesDto,NoteEntity.class);
//       notesRepository.save(noteEntity);
//
//
//    }

    @Override
    public void uploadNotes(NotesDto notesDto, String id) {
        ModelMapper modelMapper=new ModelMapper();
        notesDto.setNotesid(util.generateUserId(10));

        NoteEntity noteEntity=modelMapper.map(notesDto,NoteEntity.class);
         User ed= userAuthRespository.findByEmail(id);


        noteEntity.setUser(ed);
        notesRepository.save(noteEntity);
//
//        notesRepository.save(noteEntity);

    }




}
