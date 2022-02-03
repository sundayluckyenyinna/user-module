package com.springarr.user.data.personal;

import com.springarr.user.enums.CaseType;
import com.springarr.user.utils.DataUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * This class defines the objects or instances that will represent and hold the data for the name properties
 * of the users of this application.
 */
public class Name implements Serializable
{
    /**
     * The first name attribute for the typical user of the application.
     */
    private String firstName;

    /**
     * The middle name attribute for those users that do have a middle name.
     */
    private String middleName;

    /**
     * The last name of the user. Typically, this is usually, the surname of the user.
     */
    private String lastName;

    /**
     * An optional name for those users that possess more than the conventional number
     * of names.
     */
    private String otherName;

    /**
     * A static property that indicates that an attribute is empty. This is avoid the
     * presence of a 'null' value.
     */
    private final static String NO_VALUE = "NULL";

    /**
     * An instance of the DataUtils object that is responsible for all manipulations
     * of the properties of the Name object.
     * */
    private final DataUtils dataUtils = new DataUtils();

    public Name(){
        this.lastName = Name.NO_VALUE;
        this.firstName = Name.NO_VALUE;
        this.middleName = Name.NO_VALUE;
        this.otherName = Name.NO_VALUE;
    }

    public Name(String lastName, String firstName, String middleName){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.otherName = Name.NO_VALUE;
    }

    public Name(String lastName, String firstName, String middleName, String otherName){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.otherName = otherName;
    }

    /** GETTERS AND SETTERS OF PROPERTIES */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    /** PRIVATE METHODS */

    /**
     * This is a private method that returns the array consisting of the names of the user.
     * @return String[] nameArray.
     */
    private String[] getNameArray(){
        if (this.otherName.equalsIgnoreCase(Name.NO_VALUE))
            return new String[]{this.firstName, this.middleName, this.lastName};
        return new String[]{this.firstName, this.middleName, this.lastName, this.otherName};
    }

    /**
     * Returns the name array of the user with the specified use cas.
     * @param caseType
     * @return
     */
    private String[] getNameArray(CaseType caseType){
        return dataUtils.valuesCaseArray(this.getFullNamesAsMap(), caseType);
    }

    /**
     * Returns the keys of the map that is associated with the map of the names of the user.
     * @return String[] keys.
     */
    private String[] getNameArrayKeys(){
        if (this.otherName.equalsIgnoreCase(Name.NO_VALUE))
            return new String[]{"firstName", "middleName", "lastName"};
        return new String[]{"firstName", "middleName", "lastName", "otherName"};
    }

    /** PUBLIC METHODS */

    /**
     * Returns a map that consists of keys and the individual names of the user as a map data structure.
     * @return Map<String, String> map</String,>
     */
    public Map<String, String> getFullNamesAsMap(){
        return this.dataUtils.createMap(this.getNameArrayKeys(), this.getNameArray());
    }

    /**
     * Returns a map that consists of keys and the individual names of the user as a map data structure,
     * with the specified case type.
     * @param caseType
     * @return
     */
    public Map<String, String> getFullNamesAsMap(CaseType caseType){
        return this.dataUtils.createMap(this.getNameArrayKeys(), this.getNameArray(caseType));
    }

    /**
     * Returns the full name of the user with whitespace as the default delimiter.
     * @return String fullNames
     */
    public String getFullName(){
        String conventionalName = this.firstName + " " + this.middleName + " " +
                                  this.lastName;
        if (this.otherName.equalsIgnoreCase(Name.NO_VALUE)){
            return conventionalName;
        }
        return conventionalName + " " + this.otherName;
    }

    /**
     * Returns the fullNames of the user with the specified delimiter.
     * @param delimiter
     * @return String fullName
     */
    public String getFullName(String delimiter){
        return this.dataUtils.concatWithSeparator(this.getFullNamesAsMap(), delimiter);
    }

    /** OVERRIDDEN METHODS */

    /**
     * Returns true if  the and only if
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) &&
                Objects.equals(middleName, name.middleName) &&
                Objects.equals(lastName, name.lastName) &&
                Objects.equals(otherName, name.otherName) &&
                Objects.equals(dataUtils, name.dataUtils);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, otherName, dataUtils);
    }

    /**
     * Returns a spring representation for the current Name aspect
     * @return String oject.
     */
    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", otherName='" + otherName + '\'' +
                '}';
    }

}
