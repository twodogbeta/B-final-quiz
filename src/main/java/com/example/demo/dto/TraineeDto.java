package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TraineeDto {
    @NotNull(message = "name can not be null!")
    private String name;
    @NotNull(message = "office can not be null!")
    private String office;
    @NotNull(message = "email can not be null!")
    @Email(message = "email is not in a correct format!")
    private String email;
    @NotNull(message = "github account number can not be null!")
    private String github;
    @NotNull(message = "zoomId can not be null!")
    private String zoomId;
}
