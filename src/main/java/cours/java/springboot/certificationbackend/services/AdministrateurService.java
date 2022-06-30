package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.AdministrateurDTO;
import cours.java.springboot.certificationbackend.entities.Administrateur;
import cours.java.springboot.certificationbackend.mappers.MapperDTO;
import cours.java.springboot.certificationbackend.repositories.AdministrateurRepositorie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdministrateurService implements IAdministrateur {
    private AdministrateurRepositorie administrateurRepositorie;
    private MapperDTO mapperDTO;

    public AdministrateurService(AdministrateurRepositorie administrateurRepositorie, MapperDTO mapperDTO) {
        this.administrateurRepositorie = administrateurRepositorie;
        this.mapperDTO = mapperDTO;
    }
    @Override
    public List<AdministrateurDTO> getAllAdministrations() {
        List<Administrateur>administrateurs=administrateurRepositorie.findAll();
        List<AdministrateurDTO>administrateurDTOS=administrateurs.stream()
                .map(administrateur ->mapperDTO.fromAdminstrateur(administrateur))
                .collect(Collectors.toList());

        return administrateurDTOS;
    }
}
