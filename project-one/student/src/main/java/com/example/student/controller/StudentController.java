package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getAllRecords() {
        return (studentRepository.findAll());
    }

//    @RequestMapping(value = "/search/{studentId}", method = RequestMethod.GET)
    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getStudentById(@PathVariable(value="studentId") int studentId) {
        try {
            Object b = studentRepository.findById(studentId).get();
            return ResponseEntity.ok().body("b");
        } catch (Exception e) {
            return "e";
        }

    }

    @PostMapping
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Student createRecord(@RequestBody @Valid Student student) {
        return studentRepository.save(student);
    }

    @RequestMapping(value = "/{studentId}", method = RequestMethod.PUT)
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

//    @RequestMapping(value = "/delete/{studentId}", method = RequestMethod.DELETE)
    @RequestMapping(value = "/{studentId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deletePatientById(@PathVariable(value = "studentId") int studentId) throws Exception {
        if (studentRepository.findById(studentId).isEmpty()) {
            throw new Exception();
        }
        try {
            studentRepository.deleteById(studentId);
            return ResponseEntity.ok();
        } catch (Exception e) {
            return "e";
        }
    }

}
