package com.enigma.bootcamp.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_material_mapping")
public class MaterialMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mapping_id")
    private int mappingId;
    @ManyToOne
    @JoinColumn(name = "id_materi")
    private Material material;
    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;


    public int getMappingId() {
        return mappingId;
    }

    public void setMappingId(int mappingId) {
        this.mappingId = mappingId;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }
}
