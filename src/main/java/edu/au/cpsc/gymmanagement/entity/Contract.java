package edu.au.cpsc.gymmanagement.entity;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Table;

/**
 * Class representation of individual contracts.
 */
@javax.persistence.Entity
@Table(name = "Contracts")
public class Contract extends Entity {

  // CLASS VARIABLES -------------------------------------------------------------------------------

  protected static final DecimalFormat twoDecimalPlaces = new DecimalFormat("0.00");
  protected static final DateTimeFormatter usDateTimeFormatter =
      DateTimeFormatter.ofPattern("dd/MM/yyyy");

  // INSTANCE VARIABLES ----------------------------------------------------------------------------

  private final String name;
  private final String duration;
  private final double price;
  private final LocalDate startDate;
  private final LocalDate endDate;

  private boolean isActive;

  // CONSTRUCTORS ----------------------------------------------------------------------------------

  /**
   * Constructs a new contract instance when supplied with a ContractType and a start date.
   *
   * @param contractType the template from which the contract will be created
   * @param startDate    the intended start date of the new contract
   */
  @SuppressWarnings("ResultOfMethodCallIgnored")
  public Contract(ContractType contractType, LocalDate startDate) {
    this.name = contractType.getName();
    this.price = contractType.getPrice();
    this.startDate = startDate;
    Matcher matcher = Pattern.compile("\\d+").matcher(contractType.getDuration());
    matcher.find();
    int durationInt = Integer.parseInt(matcher.group());
    if (contractType.getDuration().toLowerCase().contains("day")
        || contractType.getDuration().toLowerCase().contains("dy")) {
      this.endDate = startDate.plusDays(durationInt);
    } else if (contractType.getDuration().toLowerCase().contains("week")
        || contractType.getDuration().toLowerCase().contains("wk")) {
      this.endDate = startDate.plusWeeks(durationInt);
    } else if (contractType.getDuration().toLowerCase().contains("mo")) {
      this.endDate = startDate.plusMonths(durationInt);
    } else if (contractType.getDuration().toLowerCase().contains("year")
        || contractType.getDuration().toLowerCase().contains("yr")) {
      this.endDate = startDate.plusYears(durationInt);
    } else {
      this.endDate = startDate;
    }
    this.duration = contractType.getDuration();
    this.activate();
  }

  /**
   * Parameterless constructor; required by JPA, and not intended for functional use.
   */
  public Contract() {
    this.name = "Test Membership";
    this.duration = "1 week";
    this.price = 0.00;
    this.startDate = LocalDate.now();
    this.endDate = startDate.plusWeeks(1);
    this.activate();
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

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  // METHODS ---------------------------------------------------------------------------------------

  public boolean isActive() {
    return isActive;
  }

  public void activate() {
    this.isActive = true;
  }

  public void deactivate() {
    this.isActive = false;
  }

  @Override
  public String toString() {
    return (this.name + " ($" + twoDecimalPlaces.format(this.price)
        + "): " + this.duration + " (" + this.startDate.format(usDateTimeFormatter) + " - "
        + this.endDate.format(usDateTimeFormatter) + ")");
  }
}
