package cours.java.springboot.certificationbackend.controllers;

import cours.java.springboot.certificationbackend.dtos.AdministrateurDTO;
import cours.java.springboot.certificationbackend.services.AdministrateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class AdministrateurRestController {
    private AdministrateurService administrateurService;

    public AdministrateurRestController(AdministrateurService administrateurService) {
        this.administrateurService = administrateurService;
    }
    @GetMapping("/administrateurs")
    public List<AdministrateurDTO>getAll(){
        return administrateurService.getAllAdministrations();
    }
}
