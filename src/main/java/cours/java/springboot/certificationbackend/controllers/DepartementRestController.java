package cours.java.springboot.certificationbackend.controllers;

import cours.java.springboot.certificationbackend.dtos.DepartementDTO;
import cours.java.springboot.certificationbackend.exceptions.DepartementNotFoundException;
import cours.java.springboot.certificationbackend.services.DepartementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartementRestController {
    private DepartementService departementService;
    public DepartementRestController(DepartementService departementService) {
        this.departementService = departementService;
    }
    @RequestMapping("/departements")
    public DepartementDTO save(@RequestBody DepartementDTO departementDTO) throws DepartementNotFoundException {
        return departementService.saveDepartement(departementDTO);
    }
    @GetMapping("/departements/{id}")
    public DepartementDTO getOneDepartement(@PathVariable Long id) throws DepartementNotFoundException {
        return departementService.getOneDepartement(id);
    }
    @GetMapping("/departements")
    public List<DepartementDTO>getAllDepartement(){
        return departementService.departementDtoList();
    }
    @PutMapping("/departements/{id}")
    public DepartementDTO update(@PathVariable Long id,@RequestBody DepartementDTO departementDTO){
        departementDTO.setId(id);
        return departementService.updateDepartement(departementDTO);
    }
}
