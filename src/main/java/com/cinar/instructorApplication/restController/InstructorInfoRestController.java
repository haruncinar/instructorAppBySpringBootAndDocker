package com.cinar.instructorApplication.restController;

import com.cinar.instructorApplication.entity.Instructor;
import com.cinar.instructorApplication.entity.InstructorDetail;
import com.cinar.instructorApplication.model.InstructorModel;
import com.cinar.instructorApplication.service.InstructorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class InstructorInfoRestController
{

    @Autowired
    @Qualifier("instructorInfoService")
    private InstructorInfoService instructorInfoService;

    @PostMapping(value = "/instructors")
    public String createInstructorWithInstructorDetails(@RequestBody Instructor instructor)
    {
        Instructor ins = instructorInfoService.saveInstructor(instructor);
        return String.format("%s isimli, %s id'li eğitmenin eklenme işlemi başarıyla tamamlanmıştır.", instructor.getName(), instructor.getId());
    }

    @DeleteMapping(value = "/instructors/{instructorId}")
    public String deleteInstructorWithInstructorDetails(@PathVariable int instructorId)
    {
        instructorInfoService.deleteInstructor(instructorId);
        return String.format("%s id'li eğitmenin silinme işlemi başarıyla tamamlanmıştır.", instructorId);
    }

    @GetMapping(value = "/instructors/{instructorId}")
    public InstructorModel getInstructorWithDetailsById(@PathVariable int instructorId)
    {
        return instructorInfoService.getInstructorById(instructorId);
    }
}
