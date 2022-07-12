package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.DemandeDTO;
import cours.java.springboot.certificationbackend.dtos.EtudiantDTO;
import cours.java.springboot.certificationbackend.entities.Demande;
import cours.java.springboot.certificationbackend.entities.Etudiant;
import cours.java.springboot.certificationbackend.enums.Etat;
import cours.java.springboot.certificationbackend.exceptions.EtudiantNotFoundException;
import cours.java.springboot.certificationbackend.mappers.MapperDTO;
import cours.java.springboot.certificationbackend.repositories.DemandeRepositorie;
import cours.java.springboot.certificationbackend.repositories.EtudiantRepositorie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EtudiantService implements IEtudiantService {
    private EtudiantRepositorie etudiantRepositorie;
    private MapperDTO mapperDTO;
    private DemandeRepositorie demandeRepositorie;

    public EtudiantService(EtudiantRepositorie etudiantRepositorie, MapperDTO mapperDTO, DemandeRepositorie demandeRepositorie) {
        this.etudiantRepositorie = etudiantRepositorie;
        this.mapperDTO = mapperDTO;
        this.demandeRepositorie = demandeRepositorie;
    }
    @Override
    public void existeEtudiant(String email, String telephone, String username) throws EtudiantNotFoundException {
        Etudiant etudiant=etudiantRepositorie
                .getAdministrateurByEmailOrTelephoneOrUsername(
                        email,telephone,username
                );
        if (etudiant!=null)throw new EtudiantNotFoundException("Email, telephone ou username existe deja");
    }

    @Override
    public EtudiantDTO saveEtudiant(EtudiantDTO etudiantDTO) throws EtudiantNotFoundException {
        Etudiant etudiant=mapperDTO.fromEtudiantDTO(etudiantDTO);
        existeEtudiant(etudiant.getEmail(),etudiant.getTelephone(),etudiant.getUsername());
        Etudiant etudiantSaved=etudiantRepositorie.save(etudiant);
        return mapperDTO.fromEtudiant(etudiantSaved);
    }
    @Override
    public List<EtudiantDTO>getAllEtudiant(){
        List<Etudiant>etudiantList=etudiantRepositorie.findAll();
        List<EtudiantDTO>etudiantDTOS=etudiantList.stream()
                .map(etudiant -> mapperDTO.fromEtudiant(etudiant))
                .collect(Collectors.toList());
        return etudiantDTOS;
    }
    @Override
    public EtudiantDTO getOneEtudiant(Long id) throws EtudiantNotFoundException {
        Etudiant etudiant=etudiantRepositorie.findById(id)
                .orElseThrow(()->new EtudiantNotFoundException("etudiant existe pas"));
        return mapperDTO.fromEtudiant(etudiant);
    }
    @Override
    public EtudiantDTO updateEtudiant(EtudiantDTO etudiantDTO){
        Etudiant etudiant=mapperDTO.fromEtudiantDTO(etudiantDTO);
        Etudiant etudiantUpdated=etudiantRepositorie.save(etudiant);
        return etudiantDTO;
    }
    @Override
    public void deleteEtudiant(Long id) throws EtudiantNotFoundException {
        Etudiant etudiant=etudiantRepositorie.findById(id).orElseThrow(
                ()->new EtudiantNotFoundException("Id innexistant")
        );
        etudiantRepositorie.deleteById(id);
    }
    @Override
    public List<DemandeDTO> demandesEtudiants(Long id){
        List<Demande> listeDemande = demandeRepositorie.findByEtudiantId(id);
        return listeDemande.stream()
                .map(demande -> mapperDTO.fromDemande(demande))
                .collect(Collectors.toList());
    }

    @Override
    public EtudiantDTO desactiveCompte(Long id) {
        Etudiant etudiant=etudiantRepositorie.findById(id).get();
        EtudiantDTO etudiantDTO=mapperDTO.fromEtudiant(etudiant);
        etudiant.setEtatCompte(Etat.DESACTIVE);
        Etudiant etudiantDesactive=etudiantRepositorie.save(etudiant);
        return etudiantDTO;
    }

    @Override
    public EtudiantDTO activeCompte(Long id) {
        Etudiant etudiant=etudiantRepositorie.findById(id).get();
        EtudiantDTO etudiantDTO=mapperDTO.fromEtudiant(etudiant);
        etudiant.setEtatCompte(Etat.ACTIVE);
        Etudiant etudiantActived=etudiantRepositorie.save(etudiant);
        return etudiantDTO;
    }
}
