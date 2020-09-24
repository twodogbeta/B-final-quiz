package com.example.demo.api;

import com.example.demo.dto.TraineeDto;
import com.example.demo.service.TraineeService;
import com.example.demo.vo.TraineeVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trainees")
public class TraineeController {
    private TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping("")
    public List<TraineeVo> getAllUnGroupedTrainees(@RequestParam(defaultValue = "true") Boolean grouped) {
        return traineeService.getAllUnGroupedTrainees(grouped);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addOneTrainee(@RequestBody @Valid TraineeDto traineeDto) {
        traineeService.addOneTrainee(traineeDto);
    }

    @DeleteMapping("/{traineeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOneTrainee(@PathVariable Long traineeId) {
        traineeService.deleteOneTrainee(traineeId);
    }
}