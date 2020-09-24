package com.example.demo.service;

import com.example.demo.domain.Trainer;
import com.example.demo.dto.TrainerDto;
import com.example.demo.exception.CommonError;
import com.example.demo.exception.ParameterNotFoundException;
import com.example.demo.repository.TrainerRepository;
import com.example.demo.utils.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainerService {
    private TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<TrainerDto> getAllUnGroupedTrainers(Boolean grouped) {
        List<Trainer> trainerList = trainerRepository.findTrainersByGrouped(grouped);

        List<TrainerDto> trainerDtoList = trainerList.stream().map(Converter::trainer2trainerDto)
                .collect(Collectors.toList());
        return trainerDtoList;
    }

    public void addOneTrainer(TrainerDto trainerDto) {
        trainerRepository.save(Converter.trainerDto2trainer(trainerDto));
    }

    public void deleteOneTrainer(Long trainer_id) {
        Optional<Trainer> trainer = trainerRepository.findById(trainer_id);
        if (trainer.isPresent()) {
            trainerRepository.deleteById(trainer_id);
        } else {
            CommonError commonError = CommonError.builder()
                    .message("The deleted parameter does not exist!")
                    .status(404)
                    .build();
            throw new ParameterNotFoundException(commonError);
        }

    }
}
