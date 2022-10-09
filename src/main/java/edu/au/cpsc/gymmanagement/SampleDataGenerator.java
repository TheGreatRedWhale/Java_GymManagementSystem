package edu.au.cpsc.gymmanagement;

import edu.au.cpsc.gymmanagement.entity.Address;
import edu.au.cpsc.gymmanagement.entity.Client;
import edu.au.cpsc.gymmanagement.entity.Contract;
import edu.au.cpsc.gymmanagement.entity.ContractType;
import edu.au.cpsc.gymmanagement.repository.ClientRepository;
import edu.au.cpsc.gymmanagement.repository.ContractRepository;
import edu.au.cpsc.gymmanagement.repository.ContractTypeRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Class intended for creating sample user and contract data.
 */
public class SampleDataGenerator {

  private final ContractTypeRepository contractTypeRepository;
  private final ContractRepository contractRepository;
  private final ClientRepository clientRepository;

  /**
   * Takes all repositories as a parameter in order to pull data from the server.
   *
   * @param contractTypeRepository Contract Type Repository
   * @param contractRepository     Contract Repository
   * @param clientRepository       Client Repository
   */
  public SampleDataGenerator(
      ContractTypeRepository contractTypeRepository,
      ContractRepository contractRepository,
      ClientRepository clientRepository) {

    this.contractTypeRepository = contractTypeRepository;
    this.contractRepository = contractRepository;
    this.clientRepository = clientRepository;
  }

  /**
   * Generates sample gym data.
   */
  public void generate() {
    generateDefaultContractTypes(contractTypeRepository);
    generateDefaultClients(clientRepository);
    generateDefaultContracts(contractRepository);
  }

  private void generateDefaultContractTypes(ContractTypeRepository contractTypeRepository) {
    contractTypeRepository.save(new ContractType(
        "Trial Membership", "1 week", 10.00));
    contractTypeRepository.save(new ContractType(
        "Monthly Membership", "1 month", 25.00));
    contractTypeRepository.save(new ContractType(
        "Student Membership", "3 months", 25.00));
    contractTypeRepository.save(new ContractType(
        "Six Month Membership", "6 months", 110.00));
    contractTypeRepository.save(new ContractType(
        "Annual Membership", "1 year", 200.00));
  }

  private void generateDefaultClients(ClientRepository clientRepository) {
    clientRepository.save(new Client(
        "Bruce Wayne", LocalDate.parse("1915-04-07"),
        new Address("1007 Mountain Dr.", "", "Gotham", "NY", 11212),
        new ArrayList<>(), "bruce@waynecorp.com"));
    clientRepository.save(new Client(
        "Walter White", LocalDate.parse("1958-09-07"),
        new Address("308 Negra Arroyo Lane", "", "Albuquerque", "NM", 87111),
        new ArrayList<>(), "walter@jpwynne.edu"));
    clientRepository.save(new Client(
        "Harleen Quinzel", LocalDate.parse("1990-07-20"),
        new Address("70 Pope Ave.", "Unit J", "Brooklyn", "NY", 11224),
        new ArrayList<>(), "hquinzel.md@arkhamrehab.org"));
    clientRepository.save(new Client(
        "Jake Koira", LocalDate.parse("1998-07-23"),
        new Address("562 Willow Ln.", "Apt. 1", "Meadow-ville", "CK", 14860),
        new ArrayList<>(), "bunbaker98@algebraic.us"));
    clientRepository.save(new Client(
        "Finn Mertens", LocalDate.parse("2010-03-14"),
        new Address("562 Willow Ln.", "Apt. 2", "Meadow-ville", "CK", 14860),
        new ArrayList<>(), "highfivebro@algebraic.us"));
  }
  
  private void generateDefaultContracts(ContractRepository contractRepository) {
    List<Client> clients = new ArrayList<>();
    Contract newContract;
    clientRepository.findAll().forEach(clients::add);
    List<ContractType> contractTypes = new ArrayList<>();
    contractTypeRepository.findAll().forEach(contractTypes::add);
    // BRUCE
    newContract = new Contract(contractTypes.get(0), LocalDate.parse("1935-07-13"));
    newContract.deactivate();
    newContract = contractRepository.findOne(contractRepository.save(newContract));
    clients.get(0).getContracts().add(newContract);
    newContract = new Contract(contractTypes.get(1), LocalDate.parse("1935-07-20"));
    newContract.deactivate();
    newContract = contractRepository.findOne(contractRepository.save(newContract));
    clients.get(0).getContracts().add(newContract);
    newContract = new Contract(contractTypes.get(1), LocalDate.parse("1935-08-20"));
    newContract.deactivate();
    newContract = contractRepository.findOne(contractRepository.save(newContract));
    clients.get(0).getContracts().add(newContract);
    newContract = new Contract(contractTypes.get(1), LocalDate.parse("1935-09-20"));
    newContract.deactivate();
    newContract = contractRepository.findOne(contractRepository.save(newContract));
    clients.get(0).getContracts().add(newContract);
    newContract = new Contract(contractTypes.get(1), LocalDate.parse("1935-10-20"));
    newContract.deactivate();
    newContract = contractRepository.findOne(contractRepository.save(newContract));
    clients.get(0).getContracts().add(newContract);
    for (int i = 1935; i < 1975; i++) {
      newContract = new Contract(contractTypes.get(4), LocalDate.parse(i + "-11-20"));
      newContract.deactivate();
      newContract = contractRepository.findOne(contractRepository.save(newContract));
      clients.get(0).getContracts().add(newContract);
    }
    clientRepository.save(clients.get(0));
    // WALTER
    newContract = new Contract(contractTypes.get(0), LocalDate.parse("1989-03-19"));
    newContract.deactivate();
    newContract = contractRepository.findOne(contractRepository.save(newContract));
    clients.get(1).getContracts().add(newContract);
    newContract = new Contract(contractTypes.get(1), LocalDate.parse("1989-04-15"));
    newContract.deactivate();
    newContract = contractRepository.findOne(contractRepository.save(newContract));
    clients.get(1).getContracts().add(newContract);
    newContract = new Contract(contractTypes.get(1), LocalDate.parse("1989-05-15"));
    newContract.deactivate();
    newContract = contractRepository.findOne(contractRepository.save(newContract));
    clients.get(1).getContracts().add(newContract);
    clientRepository.save(clients.get(1));
    // HARLEEN
    for (int i = 0; i < 8; i++) {
      newContract = new Contract(contractTypes.get(2),
          LocalDate.parse((2008 + (i + 3) % 4) + "-"
              +  String.format("%02d", ((7 + i * 3) % 12)) + "-20"));
      newContract.deactivate();
      newContract = contractRepository.findOne(contractRepository.save(newContract));
      clients.get(2).getContracts().add(newContract);
    }
    newContract = new Contract(contractTypes.get(1), LocalDate.now());
    newContract = contractRepository.findOne(contractRepository.save(newContract));
    clients.get(2).getContracts().add(newContract);
    clientRepository.save(clients.get(2));
    // JAKE
    newContract = new Contract(contractTypes.get(0), LocalDate.now().minusYears(1));
    newContract.deactivate();
    newContract = contractRepository.findOne(contractRepository.save(newContract));
    clients.get(3).getContracts().add(newContract);
    newContract = new Contract(contractTypes.get(1), LocalDate.now().minusYears(1).plusWeeks(1));
    newContract.deactivate();
    newContract = contractRepository.findOne(contractRepository.save(newContract));
    clients.get(3).getContracts().add(newContract);
    newContract = new Contract(contractTypes.get(1), LocalDate.now().minusYears(
        1).plusWeeks(1).plusMonths(1));
    newContract.deactivate();
    newContract = contractRepository.findOne(contractRepository.save(newContract));
    clients.get(3).getContracts().add(newContract);
    newContract = new Contract(contractTypes.get(1), LocalDate.now().minusYears(
        1).plusWeeks(1).plusMonths(2));
    newContract.deactivate();
    newContract = contractRepository.findOne(contractRepository.save(newContract));
    clients.get(3).getContracts().add(newContract);
    newContract = new Contract(contractTypes.get(1), LocalDate.now());
    newContract = contractRepository.findOne(contractRepository.save(newContract));
    clients.get(3).getContracts().add(newContract);
    clientRepository.save(clients.get(3));
  }

}
