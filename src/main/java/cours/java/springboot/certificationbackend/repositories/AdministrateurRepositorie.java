package cours.java.springboot.certificationbackend.repositories;

import cours.java.springboot.certificationbackend.entities.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepositorie extends JpaRepository<Administrateur,Long> {
    public Administrateur getAdministrateurByEmailOrTelephoneOrUsername(String email,String telephone,String username);
}
