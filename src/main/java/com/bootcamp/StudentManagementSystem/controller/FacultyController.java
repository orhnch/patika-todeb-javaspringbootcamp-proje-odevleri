package com.bootcamp.StudentManagementSystem.controller;


import com.bootcamp.StudentManagementSystem.model.dto.FacultyDTO;
import com.bootcamp.StudentManagementSystem.model.entity.Faculty;
import com.bootcamp.StudentManagementSystem.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/all")
    public ResponseEntity getAllFaculties() {
        List<Faculty> allFaculties = facultyService.getAllFaculties();
        return ResponseEntity.ok(allFaculties);
    }

    @PostMapping("/create")
    public ResponseEntity createNewFaculty(@RequestBody FacultyDTO faculty) {
        Faculty respFaculty = facultyService.create(faculty);
        if (respFaculty == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Faculty could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respFaculty);
    }
}