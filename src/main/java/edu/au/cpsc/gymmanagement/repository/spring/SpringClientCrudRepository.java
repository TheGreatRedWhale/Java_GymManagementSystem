package edu.au.cpsc.gymmanagement.repository.spring;

import edu.au.cpsc.gymmanagement.entity.Client;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * I can store and retrieve Client instances.
 */
@Repository
public interface SpringClientCrudRepository extends CrudRepository<Client, Long> {
  Optional<Client> findById(Long id);
}
