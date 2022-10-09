package edu.au.cpsc.gymmanagement.repository.spring;

import edu.au.cpsc.gymmanagement.entity.Client;
import edu.au.cpsc.gymmanagement.repository.ClientRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class SpringClientRepository implements ClientRepository {

  private final SpringClientCrudRepository springClientCrudRepository;

  public SpringClientRepository(
      SpringClientCrudRepository springClientCrudRepository) {
    this.springClientCrudRepository = springClientCrudRepository;
  }

  @Override
  public Long save(Client entity) {
    return springClientCrudRepository.save(entity).getId();
  }

  @Override
  public List<Client> findAll() {
    List<Client> result = new ArrayList<>();
    for (Client cl : springClientCrudRepository.findAll()) {
      result.add(cl);
    }
    return result;
  }

  @Override
  public Client findOne(Long id) {
    return springClientCrudRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteAll() {
    springClientCrudRepository.deleteAll();
  }
}
