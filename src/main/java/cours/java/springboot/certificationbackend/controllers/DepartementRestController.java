package cours.java.springboot.certificationbackend.controllers;

import cours.java.springboot.certificationbackend.dtos.DepartementDTO;
import cours.java.springboot.certificationbackend.services.DepartementService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartementRestController {
    private DepartementService departementService;

    public DepartementRestController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @RequestMapping("/departements")
    public DepartementDTO save(@RequestBody DepartementDTO departementDTO){
        return departementService.saveDepartement(departementDTO);
    }
}
