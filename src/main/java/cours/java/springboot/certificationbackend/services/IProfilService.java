package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.entities.Profile;
import cours.java.springboot.certificationbackend.exceptions.ProfileNotFoundException;

import java.util.List;

public interface IProfilService {
    void getProfileByLibelle(String libelle) throws ProfileNotFoundException;
    Profile saveProfile(Profile profile) throws ProfileNotFoundException;
    List<Profile>listProfile();
    Profile getOneProfile(Long id) throws ProfileNotFoundException;
    Profile updateProfile(Long id,Profile profile) throws ProfileNotFoundException;
    Profile deleteProfile(Long id) throws ProfileNotFoundException;
    Profile searcheProfileByeLibelle(String libelle) throws ProfileNotFoundException;
}
