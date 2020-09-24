package com.example.demo.utils;

import com.example.demo.domain.Trainee;
import com.example.demo.dto.TraineeDto;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    public static Trainee traineeDto2trainee(TraineeDto traineeDto) {
        return Trainee.builder()
                .name(traineeDto.getName())
                .email(traineeDto.getEmail())
                .office(traineeDto.getOffice())
                .zoomId(traineeDto.getZoomId())
                .grouped(false)
                .build();
    }

    public static TraineeDto trainee2traineeDto(Trainee trainee) {
        return TraineeDto.builder()
                .name(trainee.getName())
                .email(trainee.getEmail())
                .office(trainee.getOffice())
                .zoomId(trainee.getZoomId())
                .build();
    }


}
