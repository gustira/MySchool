package com.enigma.bootcamp.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "tb_student")
public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
    @Id
    @Column(name = "id")
    private String id;

    private String name;
    private String gender;
    @Column(name = "place_ob")
    private String placeOb;
    @Column(name = "birth_date")
    private Date birthDate;
    private String address;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    public String getPlaceOb() {
////        return placeOb;
////    }
////
////    public void setPlaceOb(String placeOb) {
////        this.placeOb = placeOb;
////    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Batch getBatch() {
//        return batch;
//    }
//
//    public void setBatch(Batch batch) {
//        this.batch = batch;
//    }

//    public Timestamp getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Timestamp createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Timestamp getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(Timestamp updatedAt) {
//        this.updatedAt = updatedAt;
//    }
}
