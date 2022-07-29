package cours.java.springboot.certificationbackend.controllers;

import cours.java.springboot.certificationbackend.dtos.DemandeDTO;
import cours.java.springboot.certificationbackend.exceptions.DemandeNotFoundExeception;
import cours.java.springboot.certificationbackend.services.DemandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
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
    @GetMapping("/demandes")
    public List<DemandeDTO>getAll(){
        return demandeService.getAllDemandes();
    }
    @PutMapping("/demandes/{id}")
    public DemandeDTO update(@PathVariable Long id,@RequestBody DemandeDTO demandeDTO){
        demandeDTO.setId(id);
        return demandeService.updateDemande(demandeDTO);
    }
    @DeleteMapping("/demandes/{id}")
    public void delete(@PathVariable Long id) throws DemandeNotFoundExeception {
        demandeService.deleteDemande(id);
    }
    @PutMapping("/demandes/valider/{id}")
    public DemandeDTO valider(@PathVariable Long id) throws DemandeNotFoundExeception {
        return demandeService.validerDemande(id);
    }
    @PutMapping("/demandes/rejeter/{id}")
    public DemandeDTO rejeter(@PathVariable Long id) throws DemandeNotFoundExeception {
        return demandeService.rejeterDemande(id);
    }
}
