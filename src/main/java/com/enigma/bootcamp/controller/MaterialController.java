package com.enigma.bootcamp.controller;

import com.enigma.bootcamp.dao.MaterialDao;
import com.enigma.bootcamp.dto.MaterialDto;
import com.enigma.bootcamp.exception.UserException;
import com.enigma.bootcamp.helper.response.CommonResponse;
import com.enigma.bootcamp.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class MaterialController {

    // declare constant routing path
    private static final String BACK_LIST_MATERIAL = "/back-office/materials";
    private static final String BACK_UPLOAD_MATERIAL_FILE = "/back-office/upload/{mid}";
    private static final String BACK_MATERIAL = "/back-office/material";
    private static final String BACK_MATERIAL_ID = "/back-office/material/{mid}";


    @Autowired
    private MaterialDao materialDao;

    // get list meterial
    @GetMapping(path = BACK_LIST_MATERIAL)
    public CommonResponse<List<Material>> getListMaterial(){
        return new CommonResponse<>(materialDao.getMaterials());
    }


    // upload materi material
    @PostMapping(path = BACK_UPLOAD_MATERIAL_FILE)
    public CommonResponse<Material> uploadFileMaterial(@RequestParam(name = "file") MultipartFile file, @PathVariable(name = "mid") Integer mid) throws UserException {

        File convertFile = new File("D:\\CodeId\\bootcamp App\\bootcamp-information-system\\src\\main\\resources\\files\\"+file.getOriginalFilename());
        try {
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(file.getBytes());
            fout.close();
            return new CommonResponse<Material>(materialDao.uploadFile(mid, file.getOriginalFilename()));
        } catch (IOException e) {
            throw new UserException(34, "Failed to upload file");
        }
    }


    // insert material
    @PostMapping(path = BACK_MATERIAL)
    public CommonResponse<MaterialDto> postMaterial(@RequestBody MaterialDto dto){
        return new CommonResponse<>(materialDao.postMaterial(dto));
    }

    // update material
    @PatchMapping(path = BACK_MATERIAL_ID)
    public CommonResponse<MaterialDto> updateMaterial(@PathVariable(name = "mid") Integer mid ,@RequestBody MaterialDto dto) throws UserException {
        return new CommonResponse<>(materialDao.udateMaterial(mid ,dto));
    }

    @DeleteMapping(path = BACK_MATERIAL_ID)
    public CommonResponse<Material> deleteMaterial(@PathVariable(name = "mid") Integer mid) throws UserException {
        return new CommonResponse<>(materialDao.deleteMaterial(mid));
    }

}
