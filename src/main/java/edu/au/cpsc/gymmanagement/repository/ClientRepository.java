package edu.au.cpsc.gymmanagement.repository;

import edu.au.cpsc.gymmanagement.entity.Client;

/**
 * I can store and retrieve Client instances.
 */
public interface ClientRepository extends Repository<Client> {

  @Override
  Client findOne(Long id);

}
