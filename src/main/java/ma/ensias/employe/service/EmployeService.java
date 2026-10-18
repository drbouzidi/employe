package ma.ensias.employe.service;

import ma.ensias.employe.entite.Employe;
import ma.ensias.employe.reponse.EmployeReponse;
import ma.ensias.employe.repository.EmployeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

public class EmployeService {
    //annotation demande à Spring d'injecter automatiquement une instance de notre repository (EmployeRepo).
    // C'est l'interface qui hérite de JpaRepository qui permet de communiquer avec la base de données.
    @Autowired
    private EmployeRepo employeRepo;
    //Injecte un outil tiers appelé ModelMapper.
    // Son but est d'éviter d'écrire manuellement du code répétitif pour copier les données DAO ---> DTO
    @Autowired
    private ModelMapper mapper;

    public EmployeReponse getEmployeById(int id) {
        //Optional peut soit contenir l'employé trouvé, soit être "vide" si aucun employé ne possède cet ID en base de données.
        // Cela permet d'éviter les erreurs de type NullPointerException
        Optional<Employe> employe = employeRepo.findById(id);
        EmployeReponse employeResponse = mapper.map(employe, EmployeReponse.class);
        return employeResponse;
    }
}
