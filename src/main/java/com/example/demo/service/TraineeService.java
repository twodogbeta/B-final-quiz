package com.example.demo.service;

import com.example.demo.domain.Trainee;
import com.example.demo.dto.TraineeDto;
import com.example.demo.exception.ParameterNotFoundException;
import com.example.demo.exception.CommonError;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.utils.Converter;
import com.example.demo.vo.TraineeVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TraineeService {
    private TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public List<TraineeVo> getAllUnGroupedTrainees(boolean grouped) {
        List<Trainee> traineeList = traineeRepository.findTraineesByGrouped(grouped);


        return traineeList.stream().map(Converter::trainee2traineeVo).collect(Collectors.toList());
    }

    public void addOneTrainee(TraineeDto traineeDto) {
        traineeRepository.save(Converter.traineeDto2trainee(traineeDto));
    }

    public void deleteOneTrainee(Long traineeId) {
        Optional<Trainee> trainee = traineeRepository.findById(traineeId);
        if (trainee.isPresent()) {
            traineeRepository.deleteById(traineeId);
        } else {
            CommonError commonError = CommonError.builder()
                    .message("The deleted parameter does not exist!")
                    .status(404)
                    .build();
            throw new ParameterNotFoundException(commonError);
        }
    }
}
