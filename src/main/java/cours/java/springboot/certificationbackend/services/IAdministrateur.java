package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.AdministrateurDTO;
import cours.java.springboot.certificationbackend.exceptions.AdministrateurNotFoundException;

import java.util.List;

public interface IAdministrateur {
    List<AdministrateurDTO> getAllAdministrations();

    AdministrateurDTO getOnAdmninstrateur(Long id) throws AdministrateurNotFoundException;

    AdministrateurDTO saveAdministrateur(AdministrateurDTO administrateurDTO) throws AdministrateurNotFoundException;
}
