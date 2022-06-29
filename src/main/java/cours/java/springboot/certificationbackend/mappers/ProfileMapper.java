package cours.java.springboot.certificationbackend.mappers;

import cours.java.springboot.certificationbackend.dtos.ProfileDTO;
import cours.java.springboot.certificationbackend.entities.Profile;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProfileMapper {
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
}
