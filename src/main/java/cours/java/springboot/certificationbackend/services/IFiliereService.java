package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.FiliereDTO;
import cours.java.springboot.certificationbackend.exceptions.FiliereNotFoundExecption;

import java.util.List;

public interface IFiliereService {
    public List<FiliereDTO>getAllFiliere();

    FiliereDTO getOnFiliere(Long id) throws FiliereNotFoundExecption;

    void existeFiliere(String libelle) throws FiliereNotFoundExecption;

    FiliereDTO saveFiliere(FiliereDTO filiereDTO) throws FiliereNotFoundExecption;

    FiliereDTO updateFiliere(FiliereDTO filiereDTO);

    void deleteFiliere(long id) throws FiliereNotFoundExecption;
}
