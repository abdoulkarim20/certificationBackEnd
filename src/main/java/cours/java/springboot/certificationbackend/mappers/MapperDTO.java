package cours.java.springboot.certificationbackend.mappers;

import cours.java.springboot.certificationbackend.dtos.*;
import cours.java.springboot.certificationbackend.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MapperDTO {
    //La methode qui transforme entite en entites dto
    public ProfileDTO fromProfile(Profile profile){
        ProfileDTO profileDTO=new ProfileDTO();
        //Mais pour eviter les getters et setters on peux utiliser BeanUtils.propertis(objetatransformer,objetquitransforme)
        BeanUtils.copyProperties(profile,profileDTO);
//        profileDTO.setId(profile.getId());
//        profileDTO.setLibelle(profile.getLibelle());
        return profileDTO;
    }
    //La methode qui transforme entite dto en entite
    public Profile fromProfileDTO(ProfileDTO profileDTO){
        Profile profile=new Profile();
        BeanUtils.copyProperties(profileDTO,profile);
        return profile;
    }

    /*convertir entite departement en dto*/
    public DepartementDTO fromDepartement(Departement departement){
        DepartementDTO departementDTO=new DepartementDTO();
        BeanUtils.copyProperties(departement,departementDTO);
        return departementDTO;
    }
    /*Convertir entite departementDTO en entite departement*/
    public Departement fromDepartementDTO(DepartementDTO departementDTO){
        Departement departement=new Departement();
        BeanUtils.copyProperties(departementDTO,departement);
        return departement;
    }

    /*Convertir entite Administrateur en entite AdministrateurDTO*/
    public AdministrateurDTO fromAdminstrateur(Administrateur administrateur){
        AdministrateurDTO administrateurDTO=new AdministrateurDTO();
        BeanUtils.copyProperties(administrateur,administrateurDTO);
        administrateurDTO.setProfileDTO(fromProfile(administrateur.getProfile()));
        administrateurDTO.setDepartementDTO(fromDepartement(administrateur.getDepartement()));
        return administrateurDTO;
    }
    /*Convertir AdministrateurDTO en Administrateur*/
    public Administrateur formAdministrateurDTO(AdministrateurDTO administrateurDTO){
        Administrateur administrateur=new Administrateur();
        BeanUtils.copyProperties(administrateurDTO,administrateur);
        administrateur.setProfile(fromProfileDTO(administrateurDTO.getProfileDTO()));
        administrateur.setDepartement(fromDepartementDTO(administrateurDTO.getDepartementDTO()));
        return administrateur;
    }
    /*Convertir entite Etudiant en entite EtudiantDTO*/
    public EtudiantDTO fromEtudiant(Etudiant etudiant){
        EtudiantDTO etudiantDTO=new EtudiantDTO();
        BeanUtils.copyProperties(etudiant,etudiantDTO);
        etudiantDTO.setProfileDTO(fromProfile(etudiant.getProfile()));
        return etudiantDTO;
    }
    /*Convertir EtudiantDTO en Etudiant*/
    public Etudiant fromEtudiantDTO(EtudiantDTO etudiantDTO){
        Etudiant etudiant=new Etudiant();
        BeanUtils.copyProperties(etudiantDTO,etudiant);
        etudiant.setProfile(fromProfileDTO(etudiantDTO.getProfileDTO()));
        return etudiant;
    }
    /*Convertir entite Filiere en entite FiliereDTO*/
    public FiliereDTO fromFiliere(Filiere filiere){
        FiliereDTO filiereDTO=new FiliereDTO();
        BeanUtils.copyProperties(filiere,filiereDTO);
        return filiereDTO;
    }
    /*Convertir entite FiliereDTO en entite Filere*/
    public Filiere fromFiliereDTO(FiliereDTO filiereDTO){
        Filiere filiere=new Filiere();
        BeanUtils.copyProperties(filiereDTO,filiere);
        return filiere;
    }
}
