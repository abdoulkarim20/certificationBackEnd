package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.AdministrateurDTO;

import java.util.List;

public interface IAdministrateur {
    List<AdministrateurDTO> getAllAdministrations();
}
