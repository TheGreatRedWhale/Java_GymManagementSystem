package edu.au.cpsc.gymmanagement.repository.spring;

import edu.au.cpsc.gymmanagement.repository.ClientRepository;
import edu.au.cpsc.gymmanagement.repository.ClientRepositoryTest;
import edu.au.cpsc.gymmanagement.repository.ContractRepository;
import edu.au.cpsc.gymmanagement.repository.ContractTypeRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

@DataJpaTest
@ComponentScan("edu.au.cpsc.gymmanagement")
@Transactional
public class SpringClientRepositoryTest extends ClientRepositoryTest {

  @Autowired
  protected void setSpringRepositories(
      SpringContractTypeRepository springContractTypeRepository,
      SpringContractRepository springContractRepository,
      SpringClientRepository springClientRepository) {
    this.contractTypeRepository = springContractTypeRepository;
    this.contractRepository = springContractRepository;
    this.repository = springClientRepository;
  }

  @Override
  protected ClientRepository createRepository() {
    return repository;
  }

  @Override
  protected ContractTypeRepository createContractTypeRepository() {
    return contractTypeRepository;
  }

  @Override
  protected ContractRepository createContractRepository() {
    return contractRepository;
  }
}
