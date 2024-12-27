package fr.esic.mastering.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.esic.mastering.entities.User;
import fr.esic.mastering.repository.UserRepository;

@RestController // Indique que cette classe gère les endpoints REST
@RequestMapping("/api/users") // Chemin de base pour tous les endpoints liés aux utilisateurs
public class UserRest {

    @Autowired
    private UserRepository userRepository;

    /**
     * Endpoint pour effectuer la connexion
     * 
     * @param user Un objet contenant l'email et le mot de passe
     * @return L'utilisateur correspondant si les informations sont valides, sinon un code 404
     */
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        Optional<User> optionalUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        } else {
            return ResponseEntity.status(404).body(null); // Code 404 si l'utilisateur n'est pas trouvé
        }
    }
}
