package com.cinar.instructorApplication.service;

import com.cinar.instructorApplication.entity.Instructor;
import com.cinar.instructorApplication.entity.InstructorDetail;
import com.cinar.instructorApplication.model.InstructorDetailModel;
import com.cinar.instructorApplication.model.InstructorModel;
import com.cinar.instructorApplication.repository.InstructorDAO;
import com.cinar.instructorApplication.repository.InstructorDetailDAO;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("instructorInfoService")
public class InstructorInfoServiceImpl implements InstructorInfoService
{
    @Autowired
    @Qualifier(value = "instructorDAO")
    private InstructorDAO instructorDAO;

    @Autowired
    @Qualifier(value = "instructorDetailDAO")
    private InstructorDetailDAO instructorDetailDAO;

    @Override
    @Transactional
    public Instructor saveInstructor(Instructor instructor)
    {
        try
        {
//            instructor.getInstructorDetails().forEach(instructorDetail -> instructorDetail.setInstructor(instructor));
            return instructorDAO.saveAndFlush(instructor);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Instructor kaydedilirken hata oluştu. Detay: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteInstructor(int instructorId)
    {
        try
        {
            Instructor instructor = instructorDAO.findById(instructorId);
            Preconditions.checkNotNull(instructor, "İlgili Id ile herhangi bir eğitmen bulunamamıştır.");
            instructorDAO.delete(instructor);
        }
        catch (Exception e)
        {
            throw new RuntimeException("İlgili Id ile eğitmen silme işlemi aşağıdaki hatadan dolayı yapılamamıştır: " + e.getMessage());
        }
    }

    @Override
    public InstructorModel getInstructorById(int instructorId)
    {
        Instructor instructor = instructorDAO.findById(instructorId);
        Preconditions.checkNotNull(instructor, "Eğitmen bilgisi bulunamadı.");
        InstructorModel instructorModel = InstructorModel.builder().id(instructorId).name(instructor.getName()).surname(instructor.getSurname())
                .email(instructor.getEmail()).build();
        Set<InstructorDetailModel> instructorDetailModelSet = addInstructorDetailOperation(instructorModel, instructor);
        instructorModel.setInstructorDetailModelSet(instructorDetailModelSet);
        return instructorModel;
    }

    private Set<InstructorDetailModel> addInstructorDetailOperation(InstructorModel instructorModel, Instructor instructor)
    {
        Set<InstructorDetailModel> instructorDetailModelSet = new HashSet<>();
        for(InstructorDetail instructorDetail : instructor.getInstructorDetails())
        {
            InstructorDetailModel instructorDetailModel = InstructorDetailModel.builder().id(instructorDetail.getId()).youtubeChannel(instructorDetail.getYoutubeChannel())
                    .hobby(instructorDetail.getHobby()).instructorId(instructor.getId()).build();
            instructorDetailModelSet.add(instructorDetailModel);
        }
        return instructorDetailModelSet;
    }
}
