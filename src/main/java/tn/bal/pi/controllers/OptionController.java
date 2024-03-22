package tn.bal.pi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.bal.pi.entities.Option;
import tn.bal.pi.services.IOptionService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("option")
public class OptionController {
    @Autowired
    IOptionService iOptionService;
    @GetMapping
    public List<Option> getAllOptions(){
        return iOptionService.getAllOptions();
    }
    @GetMapping("/{id}")
    public Option getOptionById(@PathVariable Long id){
        return iOptionService.getOptionById(id);
    }
    @PostMapping
    public Option addOption(@RequestBody  Option o){
        return iOptionService.addOption(o);
    }
    @PostMapping("/update")
    public Option updateOption(@RequestBody Option o){
        return iOptionService.updateOption(o);
    }
    @DeleteMapping("/{id}")
    public  void deleteOptionById(@PathVariable Long id){
        iOptionService.deleteOptionById(id);
    }

}
