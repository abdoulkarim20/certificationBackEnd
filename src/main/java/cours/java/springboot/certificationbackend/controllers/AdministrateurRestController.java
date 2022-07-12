package cours.java.springboot.certificationbackend.controllers;

import cours.java.springboot.certificationbackend.dtos.AdministrateurDTO;
import cours.java.springboot.certificationbackend.exceptions.AdministrateurNotFoundException;
import cours.java.springboot.certificationbackend.services.AdministrateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin("*")
public class AdministrateurRestController {
    private AdministrateurService administrateurService;

    public AdministrateurRestController(AdministrateurService administrateurService) {
        this.administrateurService = administrateurService;
    }
    @GetMapping("/administrateurs")
    public List<AdministrateurDTO>getAll(){
        return administrateurService.getAllAdministrations();
    }
    @GetMapping("/administrateurs/{id}")
    public AdministrateurDTO getOne(@PathVariable Long id) throws AdministrateurNotFoundException {
        return administrateurService.getOnAdmninstrateur(id);
    }
    @PostMapping("/administrateurs")
    public AdministrateurDTO save(@RequestBody AdministrateurDTO administrateurDTO) throws AdministrateurNotFoundException {
        return administrateurService.saveAdministrateur(administrateurDTO);
    }
    @PutMapping("/administrateurs/{id}")
    public AdministrateurDTO update(@PathVariable Long id,@RequestBody AdministrateurDTO administrateurDTO){
        administrateurDTO.setId(id);
        return administrateurService.updateAdministrateur(administrateurDTO);
    }
    @DeleteMapping("/administrateurs/{id}")
    public void delete(@PathVariable Long id) throws AdministrateurNotFoundException {
        administrateurService.deleteAdministrateur(id);
    }
    @PutMapping("/administrateurs/{id}/desactive")
    public AdministrateurDTO desactive(@PathVariable Long id){
        return administrateurService.desactiveCompte(id);
    }
    @PutMapping("/administrateurs/{id}/active")
    public AdministrateurDTO active(@PathVariable Long id){
        return administrateurService.activeCompte(id);
    }
    @GetMapping("/administrateurs/recherche")
    public List<AdministrateurDTO> search(@RequestParam(name = "recherche",defaultValue = "") String nom){
        return administrateurService.searchAdministrateur(nom);
    }
}
