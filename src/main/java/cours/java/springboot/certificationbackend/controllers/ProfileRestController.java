package cours.java.springboot.certificationbackend.controllers;

import cours.java.springboot.certificationbackend.dtos.ProfileDTO;
import cours.java.springboot.certificationbackend.exceptions.ProfileNotFoundException;
import cours.java.springboot.certificationbackend.services.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@CrossOrigin("*")
public class ProfileRestController {
    ProfileService profileService;
    public ProfileRestController(ProfileService profileService){
        this.profileService=profileService;
    }
    @GetMapping("/profiles")
    public List<ProfileDTO> getAll(){
        return profileService.profileDtoList();
    }
    @GetMapping("/profiles/{id}")
    public  ProfileDTO getOn(@PathVariable(name = "id") Long id) throws ProfileNotFoundException {
        return profileService.getOneProfile(id);
    }
    @PostMapping("/profiles")
    public ProfileDTO save(@RequestBody ProfileDTO profileDTO) throws ProfileNotFoundException {
        return profileService.saveProfile(profileDTO);
    }
    @PutMapping("/profiles/{id}")
    public ProfileDTO update(@PathVariable Long id, @RequestBody ProfileDTO profileDTO) throws ProfileNotFoundException {
        profileDTO.setId(id);
        return profileService.updateProfile(profileDTO);
    }
    @DeleteMapping("/profiles/{id}")
    public void delete(@PathVariable Long id) throws ProfileNotFoundException {
        profileService.deleteProfile(id);
    }
}
