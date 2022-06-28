package cours.java.springboot.certificationbackend;

import cours.java.springboot.certificationbackend.entities.Profile;
import cours.java.springboot.certificationbackend.services.ProfileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CertificationbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CertificationbackendApplication.class, args);
    }
    //@Bean
    CommandLineRunner commandLineRunner(ProfileService profileService){
        return args -> {
            Profile p=new Profile();
            //p.setLibelle("Etudiant");
            //profileService.saveProfile(p);
            profileService.listProfile().forEach(profile -> {
                System.out.println(profile.getId());
                System.out.println(profile.getLibelle());
            });
            profileService.searcheProfileByeLibelle("Administrateur");
//            for (int i=0;i<=14;i++){
//                Administrateur a=new Administrateur();
//                a.setPosteOccupe("dkjkkj");
//                a.setDateNaissance(new Date());
//                a.setNom("kdjkj");
//                a.setEmail("djhjhj");
//                a.setPrenoms("dkjkjkjk");
//                a.setTelephone("kjkjk");
//                a.setUsername("dkjkjkj");
//                a.setPassword("dkjkjkjk");
//                a.setEtatCompte(Etat.DESACTIVE);
//                patientRepository.save(a);
//                //patientRepository.save(new Administrateur(null,"djkjkj","kjkjkj","dkjkjk",new Date(),"dkjkj","kjdkjkj","dkjkj","dlkk"));
//            }
        };
    }

}
