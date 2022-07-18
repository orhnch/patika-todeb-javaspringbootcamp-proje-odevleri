package com.bootcamp.StudentManagementSystem.service;

import com.bootcamp.StudentManagementSystem.model.dto.CourseDTO;
import com.bootcamp.StudentManagementSystem.model.entity.Course;
import com.bootcamp.StudentManagementSystem.model.mapper.CourseMapper;
import com.bootcamp.StudentManagementSystem.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    @Autowired
    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        List<Course> allCourses = courseRepository.findAll();
        return allCourses;
    }
    public Course create(CourseDTO courseDTO){
        Course course = CourseMapper.toEntity(courseDTO);
        return courseRepository.save(course);
    }
}
