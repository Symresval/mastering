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

        // Création des rôles avec les attributs nécessaires
        System.out.println("Lancement de la commande");

        // Création des rôles avec les valeurs nécessaires
        Role roleCoordonateur = new Role();
        roleCoordonateur.setName("Coordinateur");
        roleCoordonateur.setRoleUtilisateur("COORDINATEUR");

        Role roleCandidat = new Role();
        roleCandidat.setName("Candidat");
        roleCandidat.setRoleUtilisateur("CANDIDATE");

        Role roleJury = new Role();
        roleJury.setName("Jury");
        roleJury.setRoleUtilisateur("JURY");

        // Sauvegarde des rôles
        roleRepository.save(roleCoordonateur);
        roleRepository.save(roleCandidat);
        roleRepository.save(roleJury);

        System.out.println("Rôles créés avec succès !");

     // Création des utilisateurs avec les rôles associés
        User u1 = new User();
        u1.setNom("TIEU");
        u1.setPrenom("Toto");
        u1.setEmail("toto@mastering.fr");
        u1.setDateNaissance(sdf.parse("10/12/2000"));
        u1.setTel("0614785414");
        u1.setLieuxDeNaissance("Paris 15");
        u1.setPassword("toto");
        u1.setRole(roleCoordonateur);

        User u2 = new User();
        u2.setNom("TIEO");
        u2.setPrenom("Tota");
        u2.setEmail("tota@mastering.fr");
        u2.setDateNaissance(sdf.parse("10/12/2002"));
        u2.setTel("0714785415");
        u2.setLieuxDeNaissance("Paris 16");
        u2.setPassword("tota");
        u2.setRole(roleCandidat);

        User u3 = new User();
        u3.setNom("TIEU");
        u3.setPrenom("Tata");
        u3.setEmail("tata@mastering.fr");
        u3.setDateNaissance(sdf.parse("10/12/2001"));
        u3.setTel("0614785414");
        u3.setLieuxDeNaissance("Paris 15");
        u3.setPassword("tata");
        u3.setRole(roleJury);

        // Sauvegarde des utilisateurs
        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);

        System.out.println("Les utilisateurs ont été créés avec succès !");

        System.out.println("Les utilisateurs ont été créés avec succès !");
    }

}
