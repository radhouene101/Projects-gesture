package tn.bal.pi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.bal.pi.dto.ContestDto;
import tn.bal.pi.services.IContestService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("contest-bal-de-projet")
@Tag(name = "contest-bal-de-projet")
public class ContestController {
    @Autowired
    IContestService service;

    @GetMapping
    public ResponseEntity<List<ContestDto>> getAllContests(){
        return ResponseEntity.ok(
                service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContestDto> getContestById(@PathVariable Long id){
        return ResponseEntity.ok(
                service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ContestDto> addContest(@RequestBody  ContestDto o){
        return ResponseEntity.ok(
                service.save(o));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteContestById(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/assign-project-to-contest/{contestId}/{projectId}")
    public  ResponseEntity<Void> assignProjectToContest(@PathVariable Long projectId,@PathVariable  Long contestDtoID){
        service.assignProjectToContest(contestDtoID,projectId);
        return ResponseEntity.ok().build();
    }
    @PostMapping("save-contest/{optionId}")
    public ResponseEntity<Void> customSaveContest(@PathVariable Long optionId,@RequestBody ContestDto contestDto) {
        service.customSaveContest(optionId,contestDto);
        return ResponseEntity.ok().build();
    }
}
