package com.example.demo.api;

import com.example.demo.dto.TrainerDto;
import com.example.demo.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trainers")
public class TrainerController {
    private TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("")
    public List<TrainerDto> getAllUnGroupedTrainers(@RequestParam(defaultValue = "true") Boolean grouped) {
        return trainerService.getAllUnGroupedTrainers(grouped);
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addOneTrainer(@RequestBody @Valid TrainerDto trainerDto) {
        trainerService.addOneTrainer(trainerDto);
    }

    @DeleteMapping("/{trainerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOneTrainer(@PathVariable Long trainerId) {
        trainerService.deleteOneTrainer(trainerId);
    }
}
