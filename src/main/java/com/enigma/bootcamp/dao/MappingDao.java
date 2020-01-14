package com.enigma.bootcamp.dao;

import com.enigma.bootcamp.dto.MaterialMappingDto;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.MaterialMapping;

import java.util.List;

public interface MappingDao {
    // get mapping list
    List<MaterialMapping> getMappingList();

    //
    MaterialMapping postMapping(MaterialMappingDto dto) throws UserException;
}
