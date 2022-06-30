package cours.java.springboot.certificationbackend.controllers;

import cours.java.springboot.certificationbackend.dtos.DepartementDTO;
import cours.java.springboot.certificationbackend.exceptions.DepartementNotFoundException;
import cours.java.springboot.certificationbackend.services.DepartementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class DepartementRestController {
    private DepartementService departementService;
    public DepartementRestController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping("/departements")
    public List<DepartementDTO>getAll(){
        return departementService.departementDtoList();
    }

    @GetMapping("/departements/{id}")
    public DepartementDTO getOne(@PathVariable Long id) throws DepartementNotFoundException {
        return departementService.getOneDepartement(id);
    }

    @PostMapping("/departements")
    public DepartementDTO save(@RequestBody DepartementDTO departementDTO) throws DepartementNotFoundException {
        return departementService.saveDepartement(departementDTO);
    }

    @PutMapping("/departements/{id}")
    public DepartementDTO update(@PathVariable Long id,@RequestBody DepartementDTO departementDTO){
        departementDTO.setId(id);
        return departementService.updateDepartement(departementDTO);
    }

    @DeleteMapping("/departements/{id}")
    public void delele(@PathVariable Long id) throws DepartementNotFoundException {
        departementService.deleteDepartement(id);
    }
}
