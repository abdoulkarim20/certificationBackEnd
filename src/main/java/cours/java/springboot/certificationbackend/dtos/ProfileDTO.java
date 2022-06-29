package cours.java.springboot.certificationbackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import cours.java.springboot.certificationbackend.entities.Administrateur;
import cours.java.springboot.certificationbackend.entities.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
public class ProfileDTO {
    private Long id;
    private String libelle;
}
