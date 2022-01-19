package io.lugonzo.unittesting108.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student {

    private String id;
    private String name;
    private Integer age;
    private Long admissionNo;
}
