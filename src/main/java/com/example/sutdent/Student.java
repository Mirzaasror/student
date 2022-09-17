package com.example.sutdent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Student {
    private int id;
private String full_name;
private String course_name;
private String mentor_name;
private int mentor_id;
}
