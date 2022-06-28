package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.entities.Profile;

import java.util.List;

public interface IProfilService {
    Profile saveProfile(Profile profile);
    List<Profile>listProfile();
    Profile getOneProfile(Long id);
    Profile updateProfile(Profile profile);
    Profile deleteProfile(Long id);
    Profile searcheProfileByeLibelle(String libelle);
}
