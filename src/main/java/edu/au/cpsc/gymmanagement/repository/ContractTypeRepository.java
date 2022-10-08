package edu.au.cpsc.gymmanagement.repository;

import edu.au.cpsc.gymmanagement.entity.ContractType;

/**
 * I can store and retrieve ContractType instances.
 */
public interface ContractTypeRepository extends Repository<ContractType> {

  @Override
  ContractType findOne(Long id);

}
