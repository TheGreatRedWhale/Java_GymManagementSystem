package edu.au.cpsc.gymmanagement.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Basic class representing entities stored within repositories.
 */
@javax.persistence.Entity
@Table(name = "Clients")
public class Client extends Entity {

  // INSTANCE VARIABLES ----------------------------------------------------------------------------

  private String         name;      // required
  private LocalDate      birthdate; // required

  private Address        address;   // required
  @OneToMany
  private List<Contract> contracts; // required
  private String         email;     // optional

  // CONSTRUCTORS ----------------------------------------------------------------------------------

  /**
   * Parameterless Client constructor; outputs a "NEW USER" with the expectation that users
   * will leverage the "setter" methods in order to fill out its respective information.
   */
  public Client() {
    this.name = "NEW USER";
    this.birthdate = LocalDate.now().minusYears(19);
    this.address = new Address();
    this.contracts = new ArrayList<>();
  }

  /**
   * Takes all instance variables as parameters and sets them in the newly created instance.
   *
   * @param name      the client's name
   * @param birthdate the clients date of birth
   * @param address   the client's permanent address
   * @param contracts the clients past and future contracts
   * @param email     the client's email (optional)
   */
  public Client(String name, LocalDate birthdate, Address address, List<Contract> contracts,
      String email) {
    this.name = name;
    this.birthdate = birthdate;
    this.address = address;
    this.contracts = contracts;
    this.email = email;
  }

  // GETTERS & SETTERS -----------------------------------------------------------------------------

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<Contract> getContracts() {
    return contracts;
  }

  public void setContracts(List<Contract> contracts) {
    this.contracts = contracts;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // METHODS ---------------------------------------------------------------------------------------

  @Override
  public String toString() {
    String output = ("[" + this.getId() + "] " + this.name + ":"
        + "\n\tDOB: " + this.birthdate
        + "\n\tAddress: " + this.address);
    if (this.email.length() != 0) {
      output += ("\n\tEmail: " + this.email);
    }
    return output;
  }
}