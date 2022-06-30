package cours.java.springboot.certificationbackend.dtos;
import cours.java.springboot.certificationbackend.enums.Etat;
import cours.java.springboot.certificationbackend.enums.Niveau;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
@Data
public class EtudiantDTO {
    private Long Id;
    private String nom;
    private String prenoms;
    private Date dateNaissance;
    private String email;
    private String telephone;
    private Etat etatCompte;
    private ProfileDTO profileDTO;
    private String matricule;
    private Niveau niveauEtude;
    private String photo;
    //private FiliereDTO filiereDTO;
    private String username;
    private String password;
}
