package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.ProfileDTO;
import cours.java.springboot.certificationbackend.entities.Profile;
import cours.java.springboot.certificationbackend.exceptions.ProfileNotFoundException;

import java.util.List;

public interface IProfilService {
    void getProfileByLibelle(String libelle) throws ProfileNotFoundException;
    ProfileDTO saveProfile(ProfileDTO profileDTO) throws ProfileNotFoundException;
    List<ProfileDTO>profileDtoList();
    ProfileDTO getOneProfile(Long id) throws ProfileNotFoundException;
    ProfileDTO updateProfile(ProfileDTO profileDTO) throws ProfileNotFoundException;
    void deleteProfile(Long id) throws ProfileNotFoundException;
    Profile searcheProfileByeLibelle(String libelle) throws ProfileNotFoundException;
}
