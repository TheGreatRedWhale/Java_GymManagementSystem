package edu.au.cpsc.gymmanagement.repository;

import edu.au.cpsc.gymmanagement.entity.Contract;

/**
 * I can store and retrieve Contract instances.
 */
public interface ContractRepository extends Repository<Contract> {

  @Override
  Contract findOne(Long id);

}
