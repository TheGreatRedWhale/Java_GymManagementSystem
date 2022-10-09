package edu.au.cpsc.gymmanagement.entity;


import javax.persistence.Embeddable;

/**
 * Class representation of street addresses.
 */
@Embeddable
public class Address implements Comparable<Address> {

  // INSTANCE VARIABLES ----------------------------------------------------------------------------

  private String streetLineOne;
  private String streetLineTwo;
  private String city;
  private String state;
  private int    zipCode;

  // CONSTRUCTORS ----------------------------------------------------------------------------------

  /**
   * Parameterless constructor outputs the street address of an apartment complex located in
   * Auburn, AL.
   */
  public Address() {
    this.streetLineOne = "250 W Glenn Ave";
    this.streetLineTwo = "";
    this.city =          "Auburn";
    this.state =         "AL";
    this.zipCode =       36801;
  }

  /**
   * Takes all instance variables as parameters and sets them in the newly created instance.
   *
   * @param streetLineOne the first line of this street address
   * @param streetLineTwo the second line of this street address (for apartment and unit numbers)
   * @param city          the city in which this address is located
   * @param state         the state in which this address is located
   * @param zipCode       the address' postal code
   */
  public Address(String streetLineOne, String streetLineTwo, String city, String state,
      int zipCode) {
    this.streetLineOne = streetLineOne;
    this.streetLineTwo = streetLineTwo;
    this.city =          city;
    this.state =         state;
    this.zipCode =       zipCode;
  }

  // METHODS ---------------------------------------------------------------------------------------

  @Override
  public String toString() {
    var output = streetLineOne;
    if (streetLineTwo != null && streetLineTwo.length() > 0) {
      output += (", " + streetLineTwo);
    }
    output += (", " + city);
    output += (", " + state);
    output += (" " + zipCode);
    return output;
  }

  /**
   * Compares this object with the specified object for order.  Returns a negative integer, zero, or
   * a positive integer as this object is less than, equal to, or greater than the specified
   * object.
   *
   * @param that the object to be compared.
   * @return a negative integer, zero, or a positive integer as this object is less than, equal to,
   * or greater than the specified object.
   * @throws NullPointerException if the specified object is null
   * @throws ClassCastException   if the specified object's type prevents it from being compared to
   *                              this object.
   */
  @Override
  public int compareTo(Address that) {
    return this.toString().compareTo(that.toString());
  }
}
