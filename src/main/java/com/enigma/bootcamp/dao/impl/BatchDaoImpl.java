package com.enigma.bootcamp.dao.impl;

import com.enigma.bootcamp.dao.BatchDao;
import com.enigma.bootcamp.dto.BatchDto;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.Batch;
import com.enigma.bootcamp.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchDaoImpl implements BatchDao {

    // inject batch repository
    @Autowired
    private BatchRepository repository;


    // get batch list
    @Override
    public List<Batch> getListBatch(){
        return repository.findAll();
    }


    // input batch
    @Override
    public Batch inputBatch(BatchDto dto){
       return repository.save(setBatch(dto));
    }


    // update batch
    @Override
    public Batch updateBatch(BatchDto dto) throws UserException {
        Batch batch = repository.findById(dto.getBatchId()).orElseThrow(()-> new UserException(44, "Batch Not Found"));
        Batch newBatch = setBatch(dto);
        newBatch.setBatchId(batch.getBatchId());
        return repository.save(newBatch);
    }


    // delete batch
    @Override
    public Batch deleteBatch(Integer id) throws UserException {
        Batch batch = repository.findById(id).orElseThrow(()-> new UserException(44, "Batch Not Found"));
        batch.setStatus("deleted");
        repository.save(batch);
        return batch;
    }

    // set batch
    private Batch setBatch(BatchDto dto){
        Batch batch = new Batch();
        batch.setDescription(dto.getDescription());
        batch.setStart(dto.getStart());
        batch.setFinish(dto.getFinish());
        batch.setStatus(dto.getStatus());
        return batch;
    }

}
