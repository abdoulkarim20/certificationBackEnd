package cours.java.springboot.certificationbackend.controllers;

import cours.java.springboot.certificationbackend.dtos.DemandeDTO;
import cours.java.springboot.certificationbackend.exceptions.DemandeNotFoundExeception;
import cours.java.springboot.certificationbackend.services.DemandeService;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemandeRestController {
    private DemandeService demandeService;

    public DemandeRestController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }
    @PostMapping("/demandes")
    public DemandeDTO save(@RequestBody DemandeDTO demandeDTO){
        return demandeService.saveDemande(demandeDTO);
    }
    @GetMapping("/demandes/{id}")
    public DemandeDTO getOne(@PathVariable Long id) throws DemandeNotFoundExeception {
        return demandeService.getOneDemande(id);
    }
}
