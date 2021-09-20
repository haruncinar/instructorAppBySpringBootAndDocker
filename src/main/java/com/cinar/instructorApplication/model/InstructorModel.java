package com.cinar.instructorApplication.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
@Builder
public class InstructorModel
{
    private int id;
    private String name;
    private String surname;
    private String email;
    private Set<InstructorDetailModel> instructorDetailModelSet;
}
