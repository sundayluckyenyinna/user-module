package com.springarr.user.data;

import com.springarr.user.abstracts.DataContainer;
import com.springarr.user.annotation.NoData;
import com.springarr.user.utils.DataUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * A data class that holds all information about the Address object for the user.
 */
public class Address extends DataContainer implements Serializable
{
    /** A data field to hold the home address for the user */
    private String homeAddress;

    /** A data field to hold the office address for the user */
    private String officeAddress;

    /** A data field to hold the state of residence for the user*/
    private String stateOfResidence;

    /** A data field to hold the region of residence for the user. This region of residence
     * can be likened to the city or town in that state specified above. This field can be null
     * or empty
     */
    private String regionOfResidence;

    /** A data field to hold the country of residence for the user. */
    private String countryOfResidence;

    /** A data field to hold th zip code for the user. */
    private String zipCode;

    /** Creates an instance of the Address object with all declared data field set to the
     * "NULL" string value. This is to avoid the complication of the null object.
     */
    public Address(){
        super();
    }

    /**
     * Creates an instance of the Address object with all fields. No field is permitted to be null.
     * @param homeAddress
     * @param officeAddress
     * @param stateOfResidence
     * @param regionOfResidence
     * @param countryOfResidence
     * @param zipCode
     */
    public Address(String homeAddress, String officeAddress,
                   String stateOfResidence, String regionOfResidence,
                   String countryOfResidence, String zipCode){
        this.homeAddress = homeAddress;
        this.officeAddress = officeAddress;
        this.stateOfResidence = stateOfResidence;
        this.regionOfResidence = regionOfResidence;
        this.countryOfResidence = countryOfResidence;
        this.zipCode = zipCode;
    }

    /**
     * Returns the home address for this instance.
     * @return homeAddress : String
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * Sets the home address data to the String passed as a parameter.
     * @param homeAddress
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * Get the office address data of this instance.
     * @return officeAddress : String
     */
    public String getOfficeAddress() {
        return officeAddress;
    }

    /**
     * Sets the office address data to the string value passed as a parameter.
     * @param officeAddress
     */
    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    /**
     * Returns the state of residence for this instance
     * @return stateOfResidence : String
     */
    public String getStateOfResidence() {
        return stateOfResidence;
    }

    /**
     * Sets the state of residence data to the string passed as parameter.
     * @param stateOfResidence
     */
    public void setStateOfResidence(String stateOfResidence) {
        this.stateOfResidence = stateOfResidence;
    }

    /**
     * Returns the region of residence data for this instance.
     * @return regionOfResidence : String.
     */
    public String getRegionOfResidence() {
        return regionOfResidence;
    }

    /**
     * Sets the region of residence data to the string value passed as a parameter.
     * @param regionOfResidence
     */
    public void setRegionOfResidence(String regionOfResidence) {
        this.regionOfResidence = regionOfResidence;
    }

    /**
     * Returns the country of residence data for this instance.
     * @return countryOfResidence : String.
     */
    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    /**
     * Sets the country of residence data to the string value passed as parameter.
     * @param countryOfResidence
     */
    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    /**
     * Returns the zipcode data for this instance.
     * @return zipCode: String.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the country of residence to the string value passed as parameter.
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Returns the string representation for this object.
     * @return object : String
     */
    @Override
    public String toString() {
        return "{" +
                "homeAddress='" + homeAddress + '\'' +
                ", officeAddress='" + officeAddress + '\'' +
                ", stateOfResidence='" + stateOfResidence + '\'' +
                ", regionOfResidence='" + regionOfResidence + '\'' +
                ", countryOfResidence='" + countryOfResidence + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    /**
     * Returns the boolean to indicate whether this object is equal to another address object
     * passed as a parameter.
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getHomeAddress(), address.getHomeAddress())
                && Objects.equals(getOfficeAddress(), address.getOfficeAddress())
                && Objects.equals(getStateOfResidence(), address.getStateOfResidence())
                && Objects.equals(getRegionOfResidence(), address.getRegionOfResidence())
                && Objects.equals(getCountryOfResidence(), address.getCountryOfResidence())
                && Objects.equals(getZipCode(), address.getZipCode());
    }

    /**
     * Returns a hashcode to represent this address object uniquely.
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getHomeAddress(), getOfficeAddress(),
                getStateOfResidence(), getRegionOfResidence(),
                getCountryOfResidence(), getZipCode());
    }
}
