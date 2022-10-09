package edu.au.cpsc.gymmanagement.repository.spring;

import edu.au.cpsc.gymmanagement.entity.Contract;
import edu.au.cpsc.gymmanagement.repository.ContractRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class SpringContractRepository implements ContractRepository {

  private final SpringContractCrudRepository springContractCrudRepository;

  public SpringContractRepository(
      SpringContractCrudRepository springContractCrudRepository) {
    this.springContractCrudRepository = springContractCrudRepository;
  }

  @Override
  public Long save(Contract entity) {
    return springContractCrudRepository.save(entity).getId();
  }

  @Override
  public List<Contract> findAll() {
    List<Contract> result = new ArrayList<>();
    for (Contract c : springContractCrudRepository.findAll()) {
      result.add(c);
    }
    return result;
  }

  @Override
  public Contract findOne(Long id) {
    return springContractCrudRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteAll() {
    springContractCrudRepository.deleteAll();
  }
}
