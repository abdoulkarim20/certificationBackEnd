package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.ProfileDTO;
import cours.java.springboot.certificationbackend.entities.Profile;
import cours.java.springboot.certificationbackend.exceptions.ProfileNotFoundException;
import cours.java.springboot.certificationbackend.mappers.ProfileMapper;
import cours.java.springboot.certificationbackend.repositories.ProfileRepositorie;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
//On peu remplacer le code a la ligne 20 par l'annotation de lombok de log4j
@Slf4j //peremt de loger un message
public class ProfileService implements IProfilService {
    private ProfileRepositorie profileRepositorie;
    private ProfileMapper profileMapper;
    public ProfileService(ProfileRepositorie profileRepositorie,ProfileMapper profileMapper){
        this.profileRepositorie=profileRepositorie;
        this.profileMapper=profileMapper;
    }

    @Override
    public void getProfileByLibelle(String libelle) throws ProfileNotFoundException {
        Profile profile=profileRepositorie.getProfileByLibelleContains(libelle);
        if (profile!=null) throw new ProfileNotFoundException("Ce profile existe deja");
    }

    //Si on veux loger un message d'information voir le code ci-dessous
    //Logger log= LoggerFactory.getLogger(this.getClass().getName());
    @Override
    public Profile saveProfile(Profile profile) throws ProfileNotFoundException {
        //Pour maintenant afficher le message de log voir ci-dessous
        log.info("Enregistreemnt d'un profile");
        getProfileByLibelle(profile.getLibelle());
        Profile profileSaved=profileRepositorie.save(profile);
        return profileSaved;
    }

    @Override
    public List<ProfileDTO> profileDtoList() {
        List<Profile> profileList=profileRepositorie.findAll();
        //Maintenant on doit transformer cette liste de profile en liste profileDto
        List<ProfileDTO> profileDTOList=profileList.stream()
                .map(profile -> profileMapper.fromProfile(profile))
                .collect(Collectors.toList());
        //On peu remplacer les ligne de code ci-dessous par les codes ci-dessus
        /*List<ProfileDTO> profileDTOList=new ArrayList<>();
        for (Profile profile:profileList){
            ProfileDTO profileDTO=profileMapper.fromProfile(profile);
            profileDTOList.add(profileDTO);
        }
         */
        //Je returne la liste des profileDTO
        return profileDTOList;
    }

    @Override
    public Profile getOneProfile(Long id) throws ProfileNotFoundException {
        Profile profile=profileRepositorie.findById(id)
                .orElseThrow(()->new ProfileNotFoundException("Le profile avec cet id n'existe pas"));
        return profile;
    }

    @Override
    public Profile updateProfile(Long id,Profile profile) throws ProfileNotFoundException {
        Profile profileEdit=getOneProfile(id);
        profileEdit.setLibelle(profile.getLibelle());
        try {
            return profileRepositorie.save(profileEdit);
        }catch (Exception e){
            throw new  ProfileNotFoundException(e.getMessage());
        }
    }

    @Override
    public Profile deleteProfile(Long id) throws ProfileNotFoundException {
        Profile profile=getOneProfile(id);
        try {
            profileRepositorie.delete(profile);
            return profile;
        }catch (Exception e){
            throw new ProfileNotFoundException("Impossible de supprimer un profile detenu par un Utilisateur");
        }
    }

    @Override
    public Profile searcheProfileByeLibelle(String libelle) throws ProfileNotFoundException {
        Profile profile=profileRepositorie.getProfileByLibelleContains(libelle);
        if (profile==null){ throw new ProfileNotFoundException("Profile inexistant");
        }else {
            return profile;
        }
    }
}
