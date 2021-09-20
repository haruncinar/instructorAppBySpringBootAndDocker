package com.cinar.instructorApplication.repository;

import com.cinar.instructorApplication.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("instructorDAO")
public interface InstructorDAO extends JpaRepository<Instructor, String>
{
    @Query("select instructor from Instructor instructor left join fetch instructor.instructorDetails instructorDetails where instructor.id=:id")
    Instructor findById(@Param("id") int id);
}
