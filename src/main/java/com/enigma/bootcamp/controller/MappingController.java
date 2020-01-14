package com.enigma.bootcamp.controller;

import com.enigma.bootcamp.dao.MappingDao;
import com.enigma.bootcamp.dto.MaterialMappingDto;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.helper.response.CommonResponse;
import com.enigma.bootcamp.model.MaterialMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MappingController {

    // constant url path
    private static final String MAPPING = "material/mapping";
    private static final String MAPPING_LIST = "materials";


    @Autowired
    private MappingDao mappingDao;


    // get mapping list
    @GetMapping(path = MAPPING_LIST)
    public CommonResponse<List<MaterialMapping>> getMappingList(){
        return new CommonResponse<>(mappingDao.getMappingList());
    }


    // post mapping
    @PostMapping(path = MAPPING)
    public CommonResponse<MaterialMapping> postMapping(@RequestBody MaterialMappingDto dto) throws UserException {
        return new CommonResponse<>(mappingDao.postMapping(dto));
    }

}
