package com.cinar.instructorApplication.service;

import com.cinar.instructorApplication.entity.Instructor;
import com.cinar.instructorApplication.entity.InstructorDetail;
import com.cinar.instructorApplication.model.InstructorModel;

import java.util.List;

public interface InstructorInfoService
{
    Instructor saveInstructor(Instructor instructor);

    void deleteInstructor(int instructorId);

    InstructorModel getInstructorById(int instructorId);
}
