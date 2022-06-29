package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.ProfileDTO;
import cours.java.springboot.certificationbackend.entities.Profile;
import cours.java.springboot.certificationbackend.exceptions.ProfileNotFoundException;
import cours.java.springboot.certificationbackend.mappers.MapperDTO;
import cours.java.springboot.certificationbackend.repositories.ProfileRepositorie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
//On peu remplacer le code pour loger un message par l'annotation de lombok de log4j
@Slf4j //peremt de loger un message
public class ProfileService implements IProfilService {
    private ProfileRepositorie profileRepositorie;
    private MapperDTO mapperDTO;
    public ProfileService(ProfileRepositorie profileRepositorie, MapperDTO mapperDTO){
        this.profileRepositorie=profileRepositorie;
        this.mapperDTO = mapperDTO;
    }

    @Override
    public void getProfileByLibelle(String libelle) throws ProfileNotFoundException {
        Profile profile=profileRepositorie.getProfileByLibelleContains(libelle);
        if (profile!=null) throw new ProfileNotFoundException("Ce profile existe deja");
    }

    //Si on veux loger un message d'information voir le code ci-dessous
    //Logger log= LoggerFactory.getLogger(this.getClass().getName());
    @Override
    public ProfileDTO saveProfile(ProfileDTO profileDTO) throws ProfileNotFoundException {
        //Pour maintenant afficher le message de log voir ci-dessous
        log.info("Enregistreemnt d'un profile");
        //Je transforme dabord l'entite dto en entite
        Profile profile= mapperDTO.fromProfileDTO(profileDTO);
        getProfileByLibelle(profile.getLibelle());
        Profile profileSaved=profileRepositorie.save(profile);
        return mapperDTO.fromProfile(profileSaved);
    }

    @Override
    public List<ProfileDTO> profileDtoList() {
        List<Profile> profileList=profileRepositorie.findAll();
        //Maintenant on doit transformer cette liste de profile en liste profileDto
        List<ProfileDTO> profileDTOList=profileList.stream()
                .map(profile -> mapperDTO.fromProfile(profile))
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
    public ProfileDTO getOneProfile(Long id) throws ProfileNotFoundException {
        Profile profile=profileRepositorie.findById(id)
                .orElseThrow(()->new ProfileNotFoundException("Le profile avec cet id n'existe pas"));
        return mapperDTO.fromProfile(profile);
    }

    @Override
    public ProfileDTO updateProfile(ProfileDTO profileDTO) throws ProfileNotFoundException {
        Profile profile= mapperDTO.fromProfileDTO(profileDTO);
        Profile profileUpdated=profileRepositorie.save(profile);
        return mapperDTO.fromProfile(profileUpdated);
    }

    @Override
    public void deleteProfile(Long id) throws ProfileNotFoundException {
        getOneProfile(id);
        profileRepositorie.deleteById(id);
    }
}
