package com.example.student.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private String address;

}
