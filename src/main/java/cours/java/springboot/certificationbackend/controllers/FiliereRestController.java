package cours.java.springboot.certificationbackend.controllers;

import cours.java.springboot.certificationbackend.dtos.FiliereDTO;
import cours.java.springboot.certificationbackend.exceptions.FiliereNotFoundExecption;
import cours.java.springboot.certificationbackend.services.FiliereService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FiliereRestController {
    private FiliereService filiereService;

    public FiliereRestController(FiliereService filiereService) {
        this.filiereService = filiereService;
    }
    @GetMapping("/filieres")
    public List<FiliereDTO>getAll(){
        return filiereService.getAllFiliere();
    }
    @GetMapping("/filieres/{id}")
    public FiliereDTO getOne(@PathVariable Long id) throws FiliereNotFoundExecption {
        return filiereService.getOnFiliere(id);
    }
    @PostMapping("/filieres")
    public FiliereDTO save(@RequestBody FiliereDTO filiereDTO) throws FiliereNotFoundExecption {
        return filiereService.saveFiliere(filiereDTO);
    }
    @PutMapping("/filieres/{id}")
    public FiliereDTO update(@PathVariable Long id,@RequestBody FiliereDTO filiereDTO){
        filiereDTO.setId(id);
        return filiereService.updateFiliere(filiereDTO);
    }
    @DeleteMapping("/filieres/{id}")
    public void delete(Long id) throws FiliereNotFoundExecption {
        filiereService.deleteFiliere(id);
    }
}
