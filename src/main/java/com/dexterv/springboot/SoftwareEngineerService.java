package com.dexterv.springboot;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers(){
        return softwareEngineerRepository.findAll();
    }

    public SoftwareEngineer insertNewSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        return softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(()-> new IllegalStateException("Illegal: Engineer ID= " + id + " Not Found!"));
    }

    public SoftwareEngineer updateSoftwareEngineerById(Integer id, SoftwareEngineer updateEngineer) {
        return softwareEngineerRepository.findById(id).map(existing -> {
            existing.setName(updateEngineer.getName());
            existing.setTechStack(updateEngineer.getTechStack());
            return softwareEngineerRepository.save(existing);
        }).orElseThrow(()-> new IllegalStateException("Error: Updating Engineer with ID= " + id + " Failed!"));
    }

    public Boolean deleteSoftwareEngineerById(Integer id) {
        if(softwareEngineerRepository.existsById(id)){
            softwareEngineerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void deleteAllSoftwareEngineerById() {
        softwareEngineerRepository.deleteAll();
    }
}
