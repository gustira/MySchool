package com.enigma.bootcamp.dao.impl;

import com.enigma.bootcamp.dao.MaterialDao;
import com.enigma.bootcamp.dto.MaterialDto;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.model.Material;
import com.enigma.bootcamp.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MaterialDaoImpl implements MaterialDao {

    // inject material repository
    @Autowired
    private MaterialRepository repository;

    // inject material
    @Autowired
    private Material material;


    // get list material
    @Override
    public List<Material> getMaterials(){
        return repository.findAll();
    }


    // post material
    @Override
    public MaterialDto postMaterial(MaterialDto dto){
        material.setDescription(dto.getDescription());
        repository.save(material);
        return dto;
    }


    // upload material
    @Override
    public Material uploadFile(Integer id, String filepath) throws UserException {
        Material material = repository.findById(id).orElse(null);
        if (material==null) {
            throw new UserException(44, "Material Not Found");
        } else {
            material.setFile(filepath);
            return repository.save(material);
        }
    }


    // upload material
    @Override
    public MaterialDto udateMaterial(Integer id, MaterialDto dto) throws UserException {
        Material material = repository.findById(id).orElse(null);
        if (material==null) {
            throw new UserException(44, "Material Not Found");
        } else {
            material.setDescription(dto.getDescription());
            repository.save(material);
            return dto;
        }
    }


    // delete material
    @Override
    public Material deleteMaterial(Integer id) throws UserException {
        Material material = repository.findById(id).orElse(null);
        if (material==null) {
            throw new UserException(44, "Material Not Found");
        } else {
            repository.deleteById(id);
            return material;
        }
    }

}
