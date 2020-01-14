package com.enigma.bootcamp.controller;

import com.enigma.bootcamp.dao.BatchDao;
import com.enigma.bootcamp.dto.BatchDto;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.helper.response.CommonResponse;
import com.enigma.bootcamp.model.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BatchController {

    // declare const url
    private static final String BATCH = "/batch";
    private static final String BATCH_ID = "/batch/{id}";
    private static final String BATCH_LIST = "/batchs";


    // inject dao
    @Autowired
    private BatchDao batchDao;

    // get list batch
    @GetMapping(path = BATCH_LIST)
    public CommonResponse<List<Batch>> getListBatch(){
        return new CommonResponse<>(batchDao.getListBatch());
    }


    // insert batch
    @PostMapping(path = BATCH)
    public CommonResponse<Batch> postBatch(@RequestBody BatchDto dto) throws UserException {
        if (dto.getDescription().equals("") || dto.getStart().equals(null) || dto.getFinish().equals(null)) {
            throw new UserException(34, "Data Cannot Empty");
        } else {
            return new CommonResponse<>(batchDao.inputBatch(dto));
        }
    }


    // update batch
    @PatchMapping(path = BATCH)
    public CommonResponse<Batch> updateBatch(@RequestBody BatchDto dto) throws UserException {
        if (dto.getDescription().equals("") || dto.getStart().equals(null) || dto.getFinish().equals(null)) {
            throw new UserException(34, "Data Cannot Empty");
        } else {
            return new CommonResponse<>(batchDao.updateBatch(dto));
        }
    }


    // delete
    @DeleteMapping(path = BATCH_ID)
    public CommonResponse<Batch> deleteBatch(@PathVariable(name = "id") Integer id) throws UserException {
        return new CommonResponse<>(batchDao.deleteBatch(id));
    }

}
