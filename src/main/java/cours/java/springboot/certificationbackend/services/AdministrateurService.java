package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.AdministrateurDTO;
import cours.java.springboot.certificationbackend.entities.Administrateur;
import cours.java.springboot.certificationbackend.enums.Etat;
import cours.java.springboot.certificationbackend.exceptions.AdministrateurNotFoundException;
import cours.java.springboot.certificationbackend.mappers.MapperDTO;
import cours.java.springboot.certificationbackend.repositories.AdministrateurRepositorie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdministrateurService implements IAdministrateurService {
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
    @Override
    public AdministrateurDTO getOnAdmninstrateur(Long id) throws AdministrateurNotFoundException {
        Administrateur administrateur=administrateurRepositorie.findById(id)
                .orElseThrow(()->new AdministrateurNotFoundException("Cet administrateur n'existe pas"));
        return mapperDTO.fromAdminstrateur(administrateur);
    }
    @Override
    public void administrateurExiste(String email, String telephone, String username) throws AdministrateurNotFoundException {
        Administrateur administrateur=administrateurRepositorie
                .getAdministrateurByEmailOrTelephoneOrUsername(
                        email,telephone,username
                );
        if (administrateur!=null) throw new AdministrateurNotFoundException("Cet utilisateur existe deja");
    }
    @Override
    public AdministrateurDTO saveAdministrateur(AdministrateurDTO administrateurDTO) throws AdministrateurNotFoundException {
        Administrateur administrateur=mapperDTO.formAdministrateurDTO(administrateurDTO);
        administrateurExiste(administrateur.getEmail(),administrateur.getTelephone(),administrateur.getUsername());
        Administrateur administrateurSaved=administrateurRepositorie.save(administrateur);
        return mapperDTO.fromAdminstrateur(administrateurSaved);
    }
    @Override
    public AdministrateurDTO updateAdministrateur(AdministrateurDTO administrateurDTO){
        Administrateur administrateur=mapperDTO.formAdministrateurDTO(administrateurDTO);
        Administrateur administrateurUpdated=administrateurRepositorie.save(administrateur);
        return mapperDTO.fromAdminstrateur(administrateurUpdated);
    }
    @Override
    public void deleteAdministrateur(Long id) throws AdministrateurNotFoundException {
        Administrateur administrateur=administrateurRepositorie.findById(id)
                .orElseThrow(()->new AdministrateurNotFoundException("Cet id n'existe pas"));
        administrateurRepositorie.delete(administrateur);
    }

    @Override
    public AdministrateurDTO desactiveCompte(Long id) {
        Administrateur administrateur=administrateurRepositorie.findById(id).get();
        AdministrateurDTO administrateurDTO=mapperDTO.fromAdminstrateur(administrateur);
        administrateur.setEtatCompte(Etat.DESACTIVE);
        Administrateur administrateurDesactive=administrateurRepositorie.save(administrateur);
        return administrateurDTO;
    }

    @Override
    public AdministrateurDTO activeCompte(Long id) {
        Administrateur administrateur=administrateurRepositorie.findById(id).get();
        AdministrateurDTO administrateurDTO=mapperDTO.fromAdminstrateur(administrateur);
        administrateur.setEtatCompte(Etat.ACTIVE);
        Administrateur administrateurDesactive=administrateurRepositorie.save(administrateur);
        return administrateurDTO;
    }
    @Override
    public List<AdministrateurDTO> searchAdministrateur(String motCle){
        List<Administrateur> administrateurList=administrateurRepositorie.findByPrenomsContains(motCle);
        List<AdministrateurDTO> administrateurDTOS=administrateurList
                .stream().map(administrateur -> mapperDTO.fromAdminstrateur(administrateur))
                .collect(Collectors.toList());
        return  administrateurDTOS;
    }
}
