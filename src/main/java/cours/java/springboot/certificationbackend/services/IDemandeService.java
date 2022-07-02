package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.DemandeDTO;
import cours.java.springboot.certificationbackend.exceptions.DemandeNotFoundExeception;

import java.util.List;

public interface IDemandeService {
    DemandeDTO saveDemande(DemandeDTO demandeDTO);

    DemandeDTO getOneDemande(Long id) throws DemandeNotFoundExeception;

    List<DemandeDTO> getAllDemandes();

    DemandeDTO updateDemande(DemandeDTO demandeDTO);

    void deleteDemande(Long id) throws DemandeNotFoundExeception;

    DemandeDTO validerDemande(Long id) throws DemandeNotFoundExeception;
}
