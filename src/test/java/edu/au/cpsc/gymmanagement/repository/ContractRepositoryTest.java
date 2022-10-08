package edu.au.cpsc.gymmanagement.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.au.cpsc.gymmanagement.entity.Contract;
import edu.au.cpsc.gymmanagement.entity.ContractType;
import java.time.LocalDate;
import javax.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;

@Transactional
public abstract class ContractRepositoryTest extends RepositoryTest<Contract, ContractRepository> {

  // INSTANCE VARIABLES ----------------------------------------------------------------------------

  ContractTypeRepository contractTypeRepository;

  // ABSTRACT METHODS ------------------------------------------------------------------------------

  protected abstract ContractTypeRepository createContractTypeRepository();

  // UTILITY METHODS -------------------------------------------------------------------------------

  @Override
  @BeforeEach
  public void setUp() {
    contractTypeRepository = createContractTypeRepository();
    repository = createRepository();
    contractTypeRepository.save(
        new ContractType("Trial Membership", "1 week", 0.00));
    contractTypeRepository.save(
        new ContractType("Basic Membership", "1 month", 10.00));
  }

  @Override
  protected Contract createEntity() {
    LocalDate startDate = LocalDate.now();
    return new Contract(contractTypeRepository.findAll().get(0), startDate);
  }

  @Override
  protected void assertEntitiesFieldsAreEqual(Contract e1, Contract e2) {
    assertEquals(e1.getId(), e2.getId());
    assertEquals(e1.getName(), e2.getName());
    assertEquals(e1.getDuration(), e2.getDuration());
    assertEquals(e1.getPrice(), e2.getPrice());
    assertEquals(e1.getStartDate(), e2.getStartDate());
    assertEquals(e1.getEndDate(), e2.getEndDate());
    assertEquals(e1.isActive(), e2.isActive());
  }

  @Override
  protected Contract updateEntityFields(Contract contract) {
    Contract updatedContract = new Contract(contractTypeRepository.findAll().get(1),
        contract.getStartDate());
    updatedContract.setId(contract.getId());
    return updatedContract;
  }
}
