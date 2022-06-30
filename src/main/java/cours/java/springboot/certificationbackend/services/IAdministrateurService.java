package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.AdministrateurDTO;
import cours.java.springboot.certificationbackend.exceptions.AdministrateurNotFoundException;

import java.util.List;

public interface IAdministrateurService {
    List<AdministrateurDTO> getAllAdministrations();

    AdministrateurDTO getOnAdmninstrateur(Long id) throws AdministrateurNotFoundException;

    void administrateurExiste(String email, String telephone, String username) throws AdministrateurNotFoundException;

    AdministrateurDTO saveAdministrateur(AdministrateurDTO administrateurDTO) throws AdministrateurNotFoundException;

    AdministrateurDTO updateAdministrateur(AdministrateurDTO administrateurDTO);

    void deleteAdministrateur(Long id) throws AdministrateurNotFoundException;
}
