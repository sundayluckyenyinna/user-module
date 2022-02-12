package com.springarr.user.data;

import com.springarr.user.abstracts.SimpleDataContainer;
import com.springarr.user.annotation.NoData;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class is a data class that stores and encapsulates the origin for the users of this application.
 */
public class Origin extends SimpleDataContainer implements Serializable
{
    /** A data field that holds the state of birth for this object. */
    private String stateOfBirth;

    /** A data field that holds the place of birth for this object. */
    private String placeOfBirth;

    /** A data field that holds the country of birth for this object. */
    private String countryOfBirth;

    /** A data field that holds the gender for this object. */
    private String gender;

    @NoData
    private final static String NO_VALUE = "NULL";

    /**
     * Creates an instance of the Origin object with all fields values of strings initialized to "NULL"
     * string value.
     */
    public Origin(){
        super();
    }

    /**
     * Creates an instance of the Origin object with the stateOfBirth, placeOfBirth, countryOfBirth
     * and gender set to the values initialized with the parameters passed as arguments.
     * @param stateOfBirth : String
     * @param placeOfBirth : String
     * @param countryOfBirth : String
     * @param gender : String
     */
    public Origin(String stateOfBirth, String placeOfBirth, String countryOfBirth, String gender){
        this.stateOfBirth = stateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.countryOfBirth = countryOfBirth;
        this.gender = gender;
    }

    /**
     * Returns the state of birth for this object.
     * @return stateOfBirth : String
     */
    public String getStateOfBirth() {
        return stateOfBirth;
    }

    /**
     * Sets the state of birth of this object to the given value passed as argument.
     * @param stateOfBirth : String
     */
    public void setStateOfBirth(String stateOfBirth) {
        this.stateOfBirth = stateOfBirth;
    }

    /**
     * Returns the place of birth foe this object.
     * @return placeOfBirth : String
     */
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    /**
     * Sets the place of place to the string value passed as parameter.
     * @param placeOfBirth : String
     */
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    /**
     * Returns the country of birth for this object.
     * @return countryOfBirth : String
     */
    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    /**
     * Sets the country of birth to the string value passed as parameter.
     * @param countryOfBirth : String
     */
    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    /**
     * Returns the gender value for this object.
     * @return gender : String
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender to the string value passed as parameter.
     * @param gender : String
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Returns the string representation for this object.
     * @return object : String
     */
    @Override
    public String toString() {
        return "{" +
                "stateOfBirth='" + stateOfBirth + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", countryOfBirth='" + countryOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    /**
     * Returns a boolean if this object is equal to another object passed as parameter.
     * Note that two origin objects are equal if and only if their corresponding values of attributes
     * are each and all equal.
     * @param object : Origin
     * @return boolean : boolean.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Origin)) return false;
        Origin origin = (Origin) object;
        return Objects.equals(getStateOfBirth(), origin.getStateOfBirth())
                && Objects.equals(getPlaceOfBirth(), origin.getPlaceOfBirth())
                && Objects.equals(getCountryOfBirth(), origin.getCountryOfBirth())
                && Objects.equals(getGender(), origin.getGender());
    }

    /**
     * Returns the hashcode representation for this current object.
     * @return hashcode : int.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getStateOfBirth(), getPlaceOfBirth(), getCountryOfBirth(), getGender());
    }
}
