package cours.java.springboot.certificationbackend.controllers;

import cours.java.springboot.certificationbackend.dtos.ProfileDTO;
import cours.java.springboot.certificationbackend.entities.Profile;
import cours.java.springboot.certificationbackend.services.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProfileRestController {
    ProfileService profileService;
    public ProfileRestController(ProfileService profileService){
        this.profileService=profileService;
    }
    @GetMapping("/profiles")
    public List<ProfileDTO> profileDTOList(){
        return profileService.profileDtoList();
    }
}
