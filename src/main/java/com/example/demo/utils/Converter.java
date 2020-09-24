package com.example.demo.utils;

import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.dto.TraineeDto;
import com.example.demo.dto.TrainerDto;
import com.example.demo.vo.TraineeVo;
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

    public static TraineeVo trainee2traineeVo(Trainee trainee) {
        return TraineeVo.builder()
                .id(trainee.getId())
                .name(trainee.getName())
                .email(trainee.getEmail())
                .office(trainee.getOffice())
                .zoomId(trainee.getZoomId())
                .build();
    }

    public static Trainer trainerDto2trainer(TrainerDto trainerDto) {
        return Trainer.builder()
                .name(trainerDto.getName())
                .grouped(false)
                .build();
    }

    public static TrainerDto trainer2trainerDto(Trainer trainer) {
        return TrainerDto.builder()
                .name(trainer.getName())
                .build();
    }
}
