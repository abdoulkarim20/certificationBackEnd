package cours.java.springboot.certificationbackend.dtos;

import cours.java.springboot.certificationbackend.enums.Etat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@Data
public class AdministrateurDTO {
    private Long Id;
    private String nom;
    private String prenoms;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private String email;
    private String telephone;
    private String posteOccupe;
    private Etat etatCompte;
    private ProfileDTO profileDTO;
    private DepartementDTO departementDTO;
    private String username;
    private String password;
}
