package fr.esic.mastering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.esic.mastering.entities.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

	Formation save(Formation formation);
}
