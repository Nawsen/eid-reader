package be.wannesvandorpe.eid;

import be.fedict.commons.eid.consumer.Address;
import be.fedict.commons.eid.consumer.Identity;

public class CitizenJson {

  private String name;
  private String firstName;
  private String nationalNumber;
  private String placeOfBirth;

  private String streetAndNumber;
  private String zip;
  private String municipality;

  public void addIdentity(Identity id) {
    this.name = id.getName();
    this.firstName = id.getFirstName();
    this.nationalNumber = id.getNationalNumber();
    this.placeOfBirth = id.getPlaceOfBirth();
  }

  public void addAddress(Address address) {
    this.streetAndNumber = address.getStreetAndNumber();
    this.zip = address.getZip();
    this.municipality = address.getMunicipality();
  }

  public String getName() {
    return name;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getNationalNumber() {
    return nationalNumber;
  }

  public String getPlaceOfBirth() {
    return placeOfBirth;
  }

  public String getStreetAndNumber() {
    return streetAndNumber;
  }

  public String getZip() {
    return zip;
  }

  public String getMunicipality() {
    return municipality;
  }
}
