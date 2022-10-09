package edu.au.cpsc.gymmanagement;

import edu.au.cpsc.gymmanagement.entity.ContractType;
import edu.au.cpsc.gymmanagement.repository.ClientRepository;
import edu.au.cpsc.gymmanagement.repository.ContractRepository;
import edu.au.cpsc.gymmanagement.repository.ContractTypeRepository;
import edu.au.cpsc.gymmanagement.repository.spring.SpringContractTypeCrudRepository;
import edu.au.cpsc.gymmanagement.repository.spring.SpringContractTypeRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

  private static final Logger log = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  /**
   * Generates sample data if none exists.
   *
   * @param contractTypeRepository Contract Type Repository
   * @param contractRepository     Contract Repository
   * @param clientRepository       Client Repository
   * @return returns a log message specifying whether the data previously existed
   */
  @Bean
  public CommandLineRunner generateSampleData(
      ContractTypeRepository contractTypeRepository,
      ContractRepository contractRepository,
      ClientRepository clientRepository) {
    if (clientRepository.findAll().size() == 0) {
      new SampleDataGenerator(contractTypeRepository, contractRepository,
          clientRepository).generate();
      return (args) -> log.info("Sample data generated");
    } else {
      return (args) -> log.info("Sample data found");
    }
  }

}
