package cours.java.springboot.certificationbackend.repositories;

import cours.java.springboot.certificationbackend.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepositorie extends JpaRepository<Etudiant,Long> {
    public Etudiant getAdministrateurByEmailOrTelephoneOrUsername(String email, String telephone, String username);

}
