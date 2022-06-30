package cours.java.springboot.certificationbackend.dtos;

import cours.java.springboot.certificationbackend.enums.Etat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
public class AdministrateurDTO {
    private Long Id;
    private String nom;
    private String prenoms;
    private Date dateNaissance;
    private String email;
    private String telephone;
    private String posteOccupe;
    @Enumerated(EnumType.STRING)
    private Etat etatCompte;
    private ProfileDTO profileDTO;
    private DepartementDTO departementDTO;
    private String username;
    private String password;
}
