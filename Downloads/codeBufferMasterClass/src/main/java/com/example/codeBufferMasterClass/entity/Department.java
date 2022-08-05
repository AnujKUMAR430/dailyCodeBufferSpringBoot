package com.example.codeBufferMasterClass.entity;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity //is used for create Table
//@Data ->is used for create @getter @setter, @toString @RequiredArgsConstructor @EqualAndHashCode for a class field
//@NoArgsConstructor->is used for create a default constructor without any class arguments
//@AllArgsConstructor -> is used for create constructor with all class arguments
//@Builder-> is used for create a pattern
@Builder
public class Department {
    @Id
    // for automatic id generator
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    // topic -> hibernate validation use dependency Validation I/O
    //different types of validations
//    @NotBlank
//    @Length
//    @Size
//    @Email
//    @Positive
//    @Negative
//    @PositiveOrZero
//    @NegativeOrZero
//    @Future
//    @FutureOrPresent
//    @Past
//    @PastOrPresent


    // for validation

    @NotBlank(message = "pls add department name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


    //constructor
    public Department() {
    }

    public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }



    //getter na setter
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    //To string
    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }
//    Logbook's dependency

    //<dependency>
//      <groupId>org.projectlombok</groupId>
//      <artifactId>lombok</artifactId>
//      <optional>true</optional>
//    </dependency>

//    if you are used lombok dependency then no need-
//    to create constructor, getter setters and toString-
//    for your class fields
//


    //use this website to convert application.properties into application.yml http://mageddo.com/tools/yaml-converter
//application.yml file is more human-readable file that's why we use it
}