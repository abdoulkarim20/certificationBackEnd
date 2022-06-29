package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.DepartementDTO;
import cours.java.springboot.certificationbackend.entities.Departement;
import cours.java.springboot.certificationbackend.exceptions.DepartementNotFoundException;
import cours.java.springboot.certificationbackend.mappers.MapperDTO;
import cours.java.springboot.certificationbackend.repositories.DepartementRepositorie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartementService implements IDepartement {
    private MapperDTO mapperDTO;
    private DepartementRepositorie departementRepositorie;

    public DepartementService(MapperDTO mapperDTO, DepartementRepositorie departementRepositorie) {
        this.mapperDTO = mapperDTO;
        this.departementRepositorie = departementRepositorie;
    }

    @Override
    public void getDepartementByNomDepartement(String nomDepartement) throws DepartementNotFoundException {
        Departement departement=departementRepositorie.getDepartementByNomDepartement(nomDepartement);
        if (departement!=null) throw new DepartementNotFoundException("Ce departement existe deja");
    }

    @Override
    public DepartementDTO saveDepartement(DepartementDTO departementDTO) throws DepartementNotFoundException {
        Departement departement=mapperDTO.fromDepartementDTO(departementDTO);
        getDepartementByNomDepartement(departement.getNomDepartement());
        Departement departementSaved=departementRepositorie.save(departement);
        return mapperDTO.fromDepartement(departementSaved);
    }
}
