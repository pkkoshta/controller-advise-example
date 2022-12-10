package com.prashant.dto;

import com.prashant.emuns.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;
    private String name;
    private String lastname;
    private String password;
    private Integer age;
    private Sex sex;
    private String email;


}
