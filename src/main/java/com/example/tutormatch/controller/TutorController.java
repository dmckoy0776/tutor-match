package com.example.tutormatch.controller;

import com.example.tutormatch.models.Tutor;
import com.example.tutormatch.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutor")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping("/find-all")
    public ResponseEntity<List<Tutor>> getAllTutors(){
        List<Tutor> tutors = tutorService.findAllTutors();
        return new ResponseEntity<>(tutors, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Tutor> findTutorById(@PathVariable Long id){
        Tutor requested = tutorService.findTutor(id);
        return new ResponseEntity<>(requested, HttpStatus.OK);
    }
    //find by all variables in service

    @PostMapping("/add")
    public ResponseEntity<Tutor> addTutor(@RequestBody Tutor tutor){
        Tutor newTutor = tutorService.addTutor(tutor);
        return new ResponseEntity<>(newTutor, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Tutor> updateTutor(@RequestBody Tutor tutor){
        Tutor newTutorInfo = tutorService.updateTutor(tutor);
        return new ResponseEntity<>(newTutorInfo, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Tutor> deleteTutor(@PathVariable Long id){
       Tutor deleted = tutorService.deleteById(id);
       return new ResponseEntity<>(deleted, HttpStatus.OK);
    }


}
