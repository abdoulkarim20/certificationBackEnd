package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.entities.Profile;
import cours.java.springboot.certificationbackend.exceptions.ProfileNotFoundException;
import cours.java.springboot.certificationbackend.repositories.ProfileRepositorie;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
//On peu remplacer le code a la ligne 20 par l'annotation de lombok de log4j
@Slf4j //peremt de loger un message
public class ProfileService implements IProfilService {
    ProfileRepositorie profileRepositorie;
    public ProfileService(ProfileRepositorie profileRepositorie){
        this.profileRepositorie=profileRepositorie;
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
    public List<Profile> listProfile() {
        return profileRepositorie.findAll();
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
        if (profile==null) throw new ProfileNotFoundException("Profile inexistant");
        return profile;
    }
}
