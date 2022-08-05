package com.springDataJpaCodeWithBuffer.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(name = "emailid_unique",
        columnNames = "email_address" )
)
// uniquesConstraints is used for check the value is unique or different we use unique constraints for email id
//@Table is used for change the name of your class name in database for example your class name is Student, but you want to another name in database then you use this @Table and define the name
public class Student {
    @Id
    @SequenceGenerator(name="student_sequence",
    sequenceName = "student_sequence",
    allocationSize = 1)
// @SequenceGenerator and @GeneratedValue is used to generate id in Sequence order like 1,2,3...
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "student_sequence")
    private Long studentId;
    private String firstName;
    private String lastName;
// if you want to change the argument name of class in database then you use @Column and change the name
    // nullable false means this field is required
    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailId;

    @Embedded
    private Guardian guardian;

}
