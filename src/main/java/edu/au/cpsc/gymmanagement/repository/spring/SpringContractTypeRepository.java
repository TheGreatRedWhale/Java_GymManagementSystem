package edu.au.cpsc.gymmanagement.repository.spring;

import edu.au.cpsc.gymmanagement.entity.ContractType;
import edu.au.cpsc.gymmanagement.repository.ContractTypeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class SpringContractTypeRepository implements ContractTypeRepository {

  private SpringContractTypeCrudRepository springContractTypeCrudRepository;

  public SpringContractTypeRepository(
      SpringContractTypeCrudRepository springContractTypeCrudRepository) {
    this.springContractTypeCrudRepository = springContractTypeCrudRepository;
  }

  @Override
  public Long save(ContractType entity) {
    return springContractTypeCrudRepository.save(entity).getId();
  }

  @Override
  public List<ContractType> findAll() {
    List<ContractType> result = new ArrayList<>();
    for (ContractType ct : springContractTypeCrudRepository.findAll()) {
      result.add(ct);
    }
    return result;
  }

  @Override
  public ContractType findOne(Long id) {
    return springContractTypeCrudRepository.findById(id).orElse(null);
  }
}
