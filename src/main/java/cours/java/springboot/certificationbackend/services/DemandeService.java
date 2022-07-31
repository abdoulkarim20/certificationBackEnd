package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.DemandeDTO;
import cours.java.springboot.certificationbackend.entities.Demande;
import cours.java.springboot.certificationbackend.enums.Statut;
import cours.java.springboot.certificationbackend.exceptions.DemandeNotFoundExeception;
import cours.java.springboot.certificationbackend.mappers.MapperDTO;
import cours.java.springboot.certificationbackend.repositories.DemandeRepositorie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    public List<DemandeDTO>getAllDemandes(){
        List<Demande>demandeList=demandeRepositorie.findAll();
        List<DemandeDTO>demandeDTOS=demandeList.stream()
                .map(demande -> mapperDTO.fromDemande(demande))
                .collect(Collectors.toList());
        return demandeDTOS;
    }
    @Override
    public DemandeDTO updateDemande(DemandeDTO demandeDTO){
        Demande demande=mapperDTO.fromDemandeDTO(demandeDTO);
        Demande demandeUpdated=demandeRepositorie.save(demande);
        return demandeDTO;
    }
    @Override
    public void deleteDemande(Long id) throws DemandeNotFoundExeception {
        DemandeDTO demandeDTO=getOneDemande(id);
        Demande demande=mapperDTO.fromDemandeDTO(demandeDTO);
        demandeRepositorie.delete(demande);
    }
    @Override
    public DemandeDTO validerDemande(Long id) throws DemandeNotFoundExeception {
        Demande demande=demandeRepositorie.findById(id).get();
        DemandeDTO demandeDTO=mapperDTO.fromDemande(demande);
        demande.setStatutDemande(Statut.Approuver);
        Demande demandeValider=demandeRepositorie.save(demande);
        return demandeDTO;
    }
    @Override
    public DemandeDTO rejeterDemande(Long id) throws DemandeNotFoundExeception {
        Demande demande=demandeRepositorie.findById(id).get();
        DemandeDTO demandeDTO=mapperDTO.fromDemande(demande);
        demande.setStatutDemande(Statut.Desaprouver);
        Demande demandeRejeter=demandeRepositorie.save(demande);
        return demandeDTO;
    }
}
