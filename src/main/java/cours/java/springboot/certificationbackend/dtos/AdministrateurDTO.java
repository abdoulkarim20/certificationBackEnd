package cours.java.springboot.certificationbackend.dtos;

import cours.java.springboot.certificationbackend.entities.Departement;
import cours.java.springboot.certificationbackend.entities.Profile;
import cours.java.springboot.certificationbackend.enums.Etat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Data
public abstract class AdministrateurDTO {
    private Long Id;
    private String nom;
    private String prenoms;
    private Date dateNaissance;
    private String email;
    private String telephone;
    @Enumerated(EnumType.STRING)
    private Etat etatCompte;
    private ProfileDTO profileDTO;
    private String posteOccupe;
    @ManyToOne
    private DepartementDTO departementDTO;
    private String username;
    private String password;
}
