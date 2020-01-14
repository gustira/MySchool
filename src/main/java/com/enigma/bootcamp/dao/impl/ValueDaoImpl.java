package com.enigma.bootcamp.dao.impl;

import com.enigma.bootcamp.dao.ValueDao;
import com.enigma.bootcamp.dto.ValueDto;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.Material;
import com.enigma.bootcamp.model.Student;
import com.enigma.bootcamp.model.Trainer;
import com.enigma.bootcamp.model.Value;
import com.enigma.bootcamp.repository.MaterialRepository;
import com.enigma.bootcamp.repository.StudentRepository;
import com.enigma.bootcamp.repository.TrainerRepository;
import com.enigma.bootcamp.repository.ValueRepository;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValueDaoImpl implements ValueDao {

    @Autowired
    private ValueRepository repository;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private Value value;


    // post value
    @Override
    public Value postValue(ValueDto dto) throws UserException {
        if (dto.getValue().equals(null)){
            throw new UserException(40, "Value cannot empty");
        }
        Trainer trainer = trainerRepository.findById(dto.getTrainerId()).orElseThrow(()-> new UserException(44, "Trainer Not Found"));
        Material material = materialRepository.findById(dto.getMaterialId()).orElseThrow(()-> new UserException(44, "Material Not Found"));
        Student student = studentRepository.findById(dto.getStudentId()).orElseThrow(()-> new UserException(44, "Student Not Found"));
        value.setValue(dto.getValue());
        value.setMaterial(material);
        value.setTrainer(trainer);
        value.setStudent(student);
        return repository.save(value);
    }


}
