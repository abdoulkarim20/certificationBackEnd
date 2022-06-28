package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.entities.Profile;
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
    //Si on veux loger un message d'information voir le code ci-dessous
    //Logger log= LoggerFactory.getLogger(this.getClass().getName());
    @Override
    public Profile saveProfile(Profile profile) {
        //Pour maintenant afficher le message de log voir ci-dessous
        log.info("Enregistreemnt d'un profile");
        Profile profileSaved=profileRepositorie.save(profile);
        return profileSaved;
    }

    @Override
    public List<Profile> listProfile() {
        return null;
    }

    @Override
    public Profile getOneProfile(Long id) {
        return null;
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return null;
    }

    @Override
    public Profile deleteProfile(Long id) {
        return null;
    }

    @Override
    public Profile searcheProfileByeLibelle(String libelle) {
        return null;
    }
}
