package edu.au.cpsc.gymmanagement.repository.spring;

import edu.au.cpsc.gymmanagement.repository.ContractRepository;
import edu.au.cpsc.gymmanagement.repository.ContractRepositoryTest;
import edu.au.cpsc.gymmanagement.repository.ContractTypeRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

@DataJpaTest
@ComponentScan("edu.au.cpsc.gymmanagement")
@Transactional
public class SpringContractRepositoryTest extends ContractRepositoryTest {

  @Autowired
  protected void setSpringRepositories(
      SpringContractTypeRepository springContractTypeRepository,
      SpringContractRepository springContractRepository) {
    this.contractTypeRepository = springContractTypeRepository;
    this.repository = springContractRepository;
  }

  @Override
  protected ContractRepository createRepository() {
    return repository;
  }

  @Override
  protected ContractTypeRepository createContractTypeRepository() {
    return contractTypeRepository;
  }
}
