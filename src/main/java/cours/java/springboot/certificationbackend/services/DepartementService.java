package cours.java.springboot.certificationbackend.services;

import cours.java.springboot.certificationbackend.dtos.DepartementDTO;
import cours.java.springboot.certificationbackend.entities.Departement;
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
    public DepartementDTO saveDepartement(DepartementDTO departementDTO) {
        Departement departement=mapperDTO.fromDepartementDTO(departementDTO);
        Departement departementSaved=departementRepositorie.save(departement);
        return mapperDTO.fromDepartement(departementSaved);
    }
}
