package com.springDataJpaCodeWithBuffer.springdatajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "course_material_sequence",
    sequenceName = "course_material_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "course_material_sequence")
    private Long courseMaterialId;
    private String url;

// jpa one-to-one relationship
    @OneToOne(
            cascade = CascadeType.ALL,
            // this is fetch type
            fetch = FetchType.LAZY,
            // we are adding this for course is mandatory if you are not use course property in test or anywhere then it will show error
            optional = false
    )
    @JoinColumn(name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
