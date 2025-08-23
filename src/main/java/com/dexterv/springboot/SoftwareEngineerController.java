package com.dexterv.springboot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @PostMapping
    public SoftwareEngineer addNewSoftwareEngineer( @RequestBody SoftwareEngineer softwareEngineer) {
        return softwareEngineerService.insertNewSoftwareEngineer(softwareEngineer);
    }

    @GetMapping("/{id}")
    public SoftwareEngineer getEngineer(@PathVariable Integer id){
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @PutMapping("/{id}")
    public SoftwareEngineer updateEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer){
        return softwareEngineerService.updateSoftwareEngineerById(id, softwareEngineer);
    }

    @DeleteMapping("/{id}")
    public String deleteEngineer(@PathVariable Integer id){

        Boolean deleted = softwareEngineerService.deleteSoftwareEngineerById(id);
        return deleted
                ? "Engineer with ID " + id + " deleted successfully."
                : "Engineer with ID " + id + " not found!";
    }

    @DeleteMapping
    public String deleteAllEngineer(){

        softwareEngineerService.deleteAllSoftwareEngineerById();
        return "All Software Engineers successfully deleted!";
    }

}
