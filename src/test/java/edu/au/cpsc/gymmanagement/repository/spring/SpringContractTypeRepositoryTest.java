package edu.au.cpsc.gymmanagement.repository.spring;

import edu.au.cpsc.gymmanagement.repository.ContractTypeRepository;
import edu.au.cpsc.gymmanagement.repository.ContractTypeRepositoryTest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

@DataJpaTest
@ComponentScan("edu.au.cpsc.gymmanagement")
@Transactional
public class SpringContractTypeRepositoryTest extends ContractTypeRepositoryTest {

  @Autowired
  protected void setSpringRepositories(
      SpringContractTypeRepository springContractTypeRepository) {
    this.repository = springContractTypeRepository;
  }

  @Override
  protected ContractTypeRepository createRepository() {
    return repository;
  }
}
