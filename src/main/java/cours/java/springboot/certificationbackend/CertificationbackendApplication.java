package cours.java.springboot.certificationbackend;

import cours.java.springboot.certificationbackend.entities.Administrateur;
import cours.java.springboot.certificationbackend.enums.Etat;
import cours.java.springboot.certificationbackend.repositories.AdminRepositorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CertificationbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CertificationbackendApplication.class, args);
    }
    //@Bean
    CommandLineRunner commandLineRunner(AdminRepositorie patientRepository){
        return args -> {
            for (int i=0;i<=14;i++){
                Administrateur a=new Administrateur();
                a.setPosteOccupe("dkjkkj");
                a.setDateNaissance(new Date());
                a.setNom("kdjkj");
                a.setEmail("djhjhj");
                a.setPrenoms("dkjkjkjk");
                a.setTelephone("kjkjk");
                a.setUsername("dkjkjkj");
                a.setPassword("dkjkjkjk");
                a.setEtatCompte(Etat.DESACTIVE);
                patientRepository.save(a);
                //patientRepository.save(new Administrateur(null,"djkjkj","kjkjkj","dkjkjk",new Date(),"dkjkj","kjdkjkj","dkjkj","dlkk"));
            }
        };
    }

}
