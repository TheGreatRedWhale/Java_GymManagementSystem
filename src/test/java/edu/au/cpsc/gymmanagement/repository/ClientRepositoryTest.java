package edu.au.cpsc.gymmanagement.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.au.cpsc.gymmanagement.entity.Address;
import edu.au.cpsc.gymmanagement.entity.Client;
import edu.au.cpsc.gymmanagement.entity.Contract;
import edu.au.cpsc.gymmanagement.entity.ContractType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;

@Transactional
public abstract class ClientRepositoryTest extends RepositoryTest<Client, ClientRepository>{

  // INSTANCE VARIABLES ----------------------------------------------------------------------------

  protected ContractRepository contractRepository;
  protected ContractTypeRepository contractTypeRepository;

  // ABSTRACT METHODS ------------------------------------------------------------------------------

  protected abstract ContractTypeRepository createContractTypeRepository();

  protected abstract ContractRepository createContractRepository();

  // UTILITY METHODS -------------------------------------------------------------------------------

  @Override
  @BeforeEach
  public void setUp(){
    contractTypeRepository = createContractTypeRepository();
    contractRepository = createContractRepository();
    repository = createRepository();
  }

  protected Client createEntity() {
    var name = "John Doe";
    var birthdate = LocalDate.of(1997,6,23);
    var address = new Address();
    var contracts = new ArrayList<Contract>();
    var email = "johndoe@gmail.com";
    return new Client(name, birthdate, address, contracts, email);
  }

  protected void assertEntitiesFieldsAreEqual(Client c1, Client c2) {
    assertEquals(c1.getId(), c2.getId());
    assertEquals(c1.getName(), c2.getName());
    assertEquals(c1.getBirthdate(), c2.getBirthdate());
    assertEquals(c1.getAddress().toString(), c2.getAddress().toString());
    for (int i = 0; i < c1.getContracts().size(); i++) {
      assertEquals(c1.getContracts().get(i), c2.getContracts().get(i));
    }
    assertEquals(c1.getEmail(), c2.getEmail());
  }

  @Override
  protected Client updateEntityFields(Client client) {
    client.setName("Jane Doe");
    client.setBirthdate(LocalDate.of(1999,12,7));
    client.setAddress(new Address("516 Drayton St","","Savannah","GA",31401));
    List<Contract> contracts = new ArrayList<>();
    contractTypeRepository.save(new ContractType());
    contractRepository.save(new Contract(contractTypeRepository.findAll().get(0), LocalDate.now()));
    contracts.add(contractRepository.findAll().get(0));
    client.setContracts(contracts);
    client.setEmail("janedoe@imastudent.edu");
    return client;
  }

  // TEST METHODS ----------------------------------------------------------------------------------

}
