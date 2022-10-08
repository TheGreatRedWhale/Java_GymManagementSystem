package edu.au.cpsc.gymmanagement.repository.spring;

import edu.au.cpsc.gymmanagement.entity.ContractType;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * I can store and retrieve ContractType instances.
 */
@Repository
public interface SpringContractTypeCrudRepository extends CrudRepository<ContractType, Long> {
  Optional<ContractType> findById(Long id);

}
