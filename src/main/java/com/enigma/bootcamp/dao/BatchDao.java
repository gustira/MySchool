package com.enigma.bootcamp.dao;

import com.enigma.bootcamp.dto.BatchDto;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.Batch;

import java.util.List;

public interface BatchDao {
    // get batch list
    List<Batch> getListBatch();

    // input batch
    Batch inputBatch(BatchDto dto);

    // update batch
    Batch updateBatch(BatchDto dto) throws UserException;

    // delete batch
    Batch deleteBatch(Integer id) throws UserException;
}
