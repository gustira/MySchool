package com.enigma.bootcamp.dao;

import com.enigma.bootcamp.dto.ValueDto;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.Value;

public interface ValueDao {
    // post value
    Value postValue(ValueDto dto) throws UserException;
}
