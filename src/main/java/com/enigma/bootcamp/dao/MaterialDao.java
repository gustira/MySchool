package com.enigma.bootcamp.dao;

import com.enigma.bootcamp.dto.MaterialDto;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.Material;

import java.util.List;

public interface MaterialDao {
    // get list material
    List<Material> getMaterials();

    MaterialDto postMaterial(MaterialDto dto);

    // upload material
    Material uploadFile(Integer id, String filepath) throws UserException;

    // upload material
    MaterialDto udateMaterial(Integer id, MaterialDto dto) throws UserException;

    // delete material
    Material deleteMaterial(Integer id) throws UserException;
}
