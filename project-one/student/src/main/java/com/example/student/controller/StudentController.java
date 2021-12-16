package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Student> getAllRecords() {
        return (studentRepository.findAll());
    }

    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable(value="studentId") int studentId) {
        return studentRepository.findById(studentId).get();
    }

    @PostMapping
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Student createRecord(@RequestBody @Valid Student student) {
        return studentRepository.save(student);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Student updatePatientRecord(@RequestBody Student student) throws Exception {
        if (student == null || student.getStudentId() == 0) {
            throw new Exception();
        }
        Optional<Student> optionalRecord = studentRepository.findById(student.getStudentId());
        if (optionalRecord.isEmpty()) {
            throw new Exception();
        }
        Student existingStudentRecord = optionalRecord.get();

        existingStudentRecord.setName(student.getName());
        existingStudentRecord.setAge(student.getAge());
        existingStudentRecord.setAddress(student.getAddress());

        return studentRepository.save(existingStudentRecord);
    }

    @RequestMapping(value = "/{studentId}", method = RequestMethod.DELETE)
    public void deletePatientById(@PathVariable(value = "studentId") int studentId) throws Exception {
        if (studentRepository.findById(studentId).isEmpty()) {
            throw new Exception();
        }
        studentRepository.deleteById(studentId);
    }

}
