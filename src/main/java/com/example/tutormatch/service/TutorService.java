package com.example.tutormatch.service;

import com.example.tutormatch.exception.UserNotFoundException;
import com.example.tutormatch.models.Tutor;
import com.example.tutormatch.repo.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepo;


    public Tutor findTutor(Long id){
        return tutorRepo.findById(id)
                .orElseThrow(()-> new UserNotFoundException("Tutor with id " + id + " not found"));

    }
    public Tutor addTutor(Tutor tutor){
        return tutorRepo.save(tutor);
    }

    public List<Tutor> findAllTutors(){
        return tutorRepo.findAll();
    }

    public Tutor updateTutor(Tutor tutor){
        return tutorRepo.save(tutor);
    }

    public Tutor deleteTutor(Tutor tutor){
        tutorRepo.delete(tutor);
        return tutor; //returns deleted entity as a courtesy
    }

    public Tutor deleteById(Long id){
        tutorRepo.deleteById(id);
        return findTutor(id);
    }
}
