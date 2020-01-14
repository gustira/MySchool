package com.enigma.bootcamp.dao.impl;

import com.enigma.bootcamp.dao.MappingDao;
import com.enigma.bootcamp.dto.MaterialMappingDto;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.Batch;
import com.enigma.bootcamp.model.Material;
import com.enigma.bootcamp.model.MaterialMapping;
import com.enigma.bootcamp.repository.BatchRepository;
import com.enigma.bootcamp.repository.MappingRepository;
import com.enigma.bootcamp.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MappingDaoImpl implements MappingDao {

    // inject mapping repository
    @Autowired
    private MappingRepository repository;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private MaterialMapping mapping;

    // get mapping list
    @Override
    public List<MaterialMapping> getMappingList(){
        return repository.findAll();
    }

    // post mapping
    @Override
    public MaterialMapping postMapping(MaterialMappingDto dto) throws UserException {
        Batch batch = batchRepository.findById(dto.getBatchId()).orElseThrow(()-> new UserException(44, "Batch not found"));
        Material material = materialRepository.findById(dto.getIdMateri()).orElseThrow(()-> new UserException(44, "Material not found"));
        mapping.setBatch(batch);
        mapping.setMaterial(material);
        return repository.save(mapping);
    }

}
