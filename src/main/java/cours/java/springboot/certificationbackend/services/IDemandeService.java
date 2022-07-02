package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.DemandeDTO;
import cours.java.springboot.certificationbackend.exceptions.DemandeNotFoundExeception;

public interface IDemandeService {
    DemandeDTO saveDemande(DemandeDTO demandeDTO);

    DemandeDTO getOneDemande(Long id) throws DemandeNotFoundExeception;
}
