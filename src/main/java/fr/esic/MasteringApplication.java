package fr.esic;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.esic.mastering.entities.Role;
import fr.esic.mastering.entities.RoleType;
import fr.esic.mastering.entities.User;
import fr.esic.mastering.repository.RoleRepository;
import fr.esic.mastering.repository.UserRepository;

@SpringBootApplication
public class MasteringApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(MasteringApplication.class, args);
        System.out.println("Lancement terminé");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Lancement de la commande");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Création des rôles
        Role roleCoordonateur = new Role(null, RoleType.COORDINATEUR); 
        Role roleCandidat = new Role(null, RoleType.CANDIDATE);
        Role roleJury = new Role(null, RoleType.JURY);

        roleRepository.save(roleCoordonateur);
        roleRepository.save(roleCandidat);
        roleRepository.save(roleJury);

        // Création des utilisateurs avec les rôles associés
        User u1 = new User(null, "TIEU", "Toto", sdf.parse("10/12/2000"), "0614785414", "toto@mastering.fr", "Paris 15", "toto", roleCoordonateur);
        User u2 = new User(null, "TIEO", "Tota", sdf.parse("10/12/2002"), "0714785415", "tota@mastering.fr", "Paris 16", "tota", roleCandidat);
        User u3 = new User(null, "TIEU", "Tata", sdf.parse("10/12/2001"), "0614785414", "tata@mastering.fr", "Paris 15", "tata", roleJury);

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);

        System.out.println("Les utilisateurs ont été créés avec succès !");
    }
}
