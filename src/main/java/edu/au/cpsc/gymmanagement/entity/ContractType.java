package edu.au.cpsc.gymmanagement.entity;

import java.text.DecimalFormat;
import javax.persistence.Table;

/**
 * Class representation of contract templates and/or membership types.
 */
@javax.persistence.Entity
@Table(name = "ContractTypes")
public class ContractType extends Entity {

  // CLASS VARIABLES -------------------------------------------------------------------------------

  protected static final DecimalFormat twoDecimalPlaces = new DecimalFormat("0.00");

  // INSTANCE VARIABLES ----------------------------------------------------------------------------

  private final String name;
  private final String duration;
  private final double price;

  // CONSTRUCTORS ----------------------------------------------------------------------------------

  /**
   * Creates a new contract type/template when supplied with all instance variables.
   *
   * @param id       the unique id of this contract template
   * @param name     the descriptive name of the contract type
   * @param duration the duration of the contract type (represented as a string)
   * @param price    the price per contract length as represented by a double
   */
  public ContractType(Long id, String name, String duration, double price) {
    this(name, duration, price);
    this.setId(id);
  }

  /**
   * Creates a new contract type/template when supplied with all instance variables,
   * excluding the id.
   *
   * @param name     the descriptive name of the contract type
   * @param duration the duration of the contract type (represented as a string)
   * @param price    the price per contract length as represented by a double
   */
  public ContractType(String name, String duration, double price) {
    this.name = name;
    this.duration = duration;
    this.price = price;
  }

  /**
   * Creates a new contract type/template.
   */
  public ContractType() {
    this("Test Membership", "1 week", 0.00);
  }

  // GETTERS & SETTERS -----------------------------------------------------------------------------

  public String getName() {
    return name;
  }

  public String getDuration() {
    return duration;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return (this.name + " ($" + twoDecimalPlaces.format(this.price) + "): " + this.duration);
  }
}
