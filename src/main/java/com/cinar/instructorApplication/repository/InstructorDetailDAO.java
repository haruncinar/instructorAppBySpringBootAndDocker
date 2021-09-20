package com.cinar.instructorApplication.repository;

import com.cinar.instructorApplication.entity.Instructor;
import com.cinar.instructorApplication.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("instructorDetailDAO")
public interface InstructorDetailDAO extends JpaRepository<InstructorDetail, String>
{
    @Query("select instructorDetail from InstructorDetail instructorDetail left join fetch instructorDetail.instructor instructor where instructor.id=:instructorId")
    public List<InstructorDetail> findByInstructorId(@Param("instructorId") int instructorId);
}
