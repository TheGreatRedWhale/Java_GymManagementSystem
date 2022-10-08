package edu.au.cpsc.gymmanagement.repository.spring;

import edu.au.cpsc.gymmanagement.entity.Contract;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * I can store and retrieve Contract instances.
 */
@Repository
public interface SpringContractCrudRepository extends CrudRepository<Contract, Long> {
  Optional<Contract> findById(Long id);

}
