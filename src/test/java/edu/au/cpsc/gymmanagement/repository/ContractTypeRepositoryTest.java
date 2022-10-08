package edu.au.cpsc.gymmanagement.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.au.cpsc.gymmanagement.entity.ContractType;
import javax.transaction.Transactional;

@Transactional
public abstract class ContractTypeRepositoryTest extends
    RepositoryTest<ContractType, ContractTypeRepository> {

  @Override
  protected ContractType createEntity() {
    var name = "Test Membership";
    var duration = "4 months";
    var price = 10.00;
    return new ContractType(name, duration, price);
  }

  @Override
  protected void assertEntitiesFieldsAreEqual(ContractType e1, ContractType e2) {
    assertEquals(e1.getId(), e2.getId());
    assertEquals(e1.getName(), e2.getName());
    assertEquals(e1.getDuration(), e2.getDuration());
    assertEquals(e1.getPrice(), e2.getPrice());
  }

  @Override
  protected ContractType updateEntityFields(ContractType contractType) {
    var id = contractType.getId();
    var name = "New Test Membership";
    var duration = "3 months";
    var price = 7.50;
    return new ContractType(id, name, duration, price);
  }
}
