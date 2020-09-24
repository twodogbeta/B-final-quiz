package com.example.demo.api;

import com.example.demo.dto.TraineeDto;
import com.example.demo.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class TraineeController {
    private TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping("/trainees")
    public List<TraineeDto> getAllUnGroupedTrainees(@RequestParam(defaultValue = "false") Boolean grouped) {
        return traineeService.getAllUnGroupedTrainees(grouped);
    }

    @PostMapping("/trainees")
    @ResponseStatus(HttpStatus.CREATED)
    public void addOneTrainee(@RequestBody @Valid TraineeDto traineeDto) {
        traineeService.addOneTrainee(traineeDto);
    }

    @DeleteMapping("/trainees/{trainee_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOneTrainee(@PathVariable Long trainee_id) {
        traineeService.deleteOneTrainee(trainee_id);
    }
}