package cours.java.springboot.certificationbackend.entities;

import cours.java.springboot.certificationbackend.enums.Etat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//par defaut hibernate AUTO cest IDENTITY
    private Long Id;
    private String nom;
    private String prenoms;
    private Date dateNaissance;
    private String email;
    private String telephone;
    @Enumerated(EnumType.STRING)
    private Etat etatCompte;
    @ManyToOne
    private Profile profile;
    private String username;
    private String password;
}
