package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.DemandeDTO;
import cours.java.springboot.certificationbackend.dtos.EtudiantDTO;
import cours.java.springboot.certificationbackend.exceptions.EtudiantNotFoundException;

import java.util.List;

public interface IEtudiantService {
    void existeEtudiant(String email, String telephone, String username) throws EtudiantNotFoundException;

    public EtudiantDTO saveEtudiant(EtudiantDTO etudiantDTO) throws EtudiantNotFoundException;

    List<EtudiantDTO> getAllEtudiant();

    EtudiantDTO getOneEtudiant(Long id) throws EtudiantNotFoundException;

    EtudiantDTO updateEtudiant(EtudiantDTO etudiantDTO);

    void deleteEtudiant(Long id) throws EtudiantNotFoundException;

    List<DemandeDTO> demandesEtudiants(Long id);
}
