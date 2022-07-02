package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.DemandeDTO;
import cours.java.springboot.certificationbackend.entities.Demande;
import cours.java.springboot.certificationbackend.exceptions.DemandeNotFoundExeception;
import cours.java.springboot.certificationbackend.mappers.MapperDTO;
import cours.java.springboot.certificationbackend.repositories.DemandeRepositorie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DemandeService implements IDemandeService {
    private DemandeRepositorie demandeRepositorie;
    private MapperDTO mapperDTO;

    public DemandeService(DemandeRepositorie demandeRepositorie, MapperDTO mapperDTO) {
        this.demandeRepositorie = demandeRepositorie;
        this.mapperDTO = mapperDTO;
    }

    @Override
    public DemandeDTO saveDemande(DemandeDTO demandeDTO) {
        Demande demande=mapperDTO.fromDemandeDTO(demandeDTO);
        Demande demandeSaved=demandeRepositorie.save(demande);
        return demandeDTO;
    }
    @Override
    public DemandeDTO getOneDemande(Long id) throws DemandeNotFoundExeception {
        Demande demande=demandeRepositorie.findById(id)
                .orElseThrow(()->new DemandeNotFoundExeception("Cette demande n'existe pas"));
        return mapperDTO.fromDemande(demande);
    }
}
