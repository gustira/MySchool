package com.enigma.bootcamp.dto;

public class MaterialMappingDto {

    private Integer mappingId;
    private Integer idMateri;
    private Integer batchId;

    public Integer getMappingId() {
        return mappingId;
    }

    public void setMappingId(Integer mappingId) {
        this.mappingId = mappingId;
    }

    public Integer getIdMateri() {
        return idMateri;
    }

    public void setIdMateri(Integer idMateri) {
        this.idMateri = idMateri;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }
}
