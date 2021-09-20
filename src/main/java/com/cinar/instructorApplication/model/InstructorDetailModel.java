package com.cinar.instructorApplication.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class InstructorDetailModel
{
    private int id;
    private String youtubeChannel;
    private String hobby;
    private int instructorId;
}
