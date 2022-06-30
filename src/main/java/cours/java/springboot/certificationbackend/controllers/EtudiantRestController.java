package cours.java.springboot.certificationbackend.controllers;

import cours.java.springboot.certificationbackend.dtos.EtudiantDTO;
import cours.java.springboot.certificationbackend.entities.Etudiant;
import cours.java.springboot.certificationbackend.exceptions.EtudiantNotFoundException;
import cours.java.springboot.certificationbackend.services.EtudiantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EtudiantRestController {
    private EtudiantService etudiantService;

    public EtudiantRestController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }
    @PostMapping("/etudiants")
    public EtudiantDTO save(@RequestBody EtudiantDTO etudiantDTO) throws EtudiantNotFoundException {
        return etudiantService.saveEtudiant(etudiantDTO);
    }
    @GetMapping("/etudiants")
    public List<EtudiantDTO>getAll(){
        return etudiantService.getAllEtudiant();
    }
    @GetMapping("/etudiants/{id}")
    public EtudiantDTO getOne(@PathVariable Long id) throws EtudiantNotFoundException {
        return etudiantService.getOneEtudiant(id);
    }
    @PutMapping("/etudiants{id}")
    public EtudiantDTO update(@PathVariable Long id,@RequestBody EtudiantDTO etudiantDTO){
        etudiantDTO.setId(id);
        return etudiantService.updateEtudiant(etudiantDTO);
    }
    @DeleteMapping("/etudiants/{id}")
    public void delete(@PathVariable Long id) throws EtudiantNotFoundException {
        etudiantService.deleteEtudiant(id);
    }
}
