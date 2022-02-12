package com.springarr.user.data;

import com.springarr.user.abstracts.SimpleDataContainer;
import com.springarr.user.annotation.NoData;
import com.springarr.user.enums.CaseType;
import com.springarr.user.utils.DataReflectProcessor;
import com.springarr.user.utils.DataUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class defines the objects or instances that will represent and hold the data for the name properties
 * of the users of this application.
 */
public class Name extends SimpleDataContainer implements Serializable
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
     * A static property that indicates that an attribute is empty. This is to avoid the
     * presence of a 'null' value.
     */
    @NoData
    private final static String NO_VALUE = "NULL";

    /**
     * Creates an instance of Name with all simple String values initialized to "NULL" string.
     */
    public Name(){
        super();
    }

    /**
     * Creates an instance of Name for those users with two names only.
     * @param lastName : String
     * @param firstName : String
     */
    public Name(String lastName, String firstName){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = Name.NO_VALUE;
        this.otherName = Name.NO_VALUE;
    }

    /**
     * Creates an instance of Name for those users with the conventional number (3) of names.
     * @param lastName : String
     * @param firstName : String
     * @param middleName : String
     */
    public Name(String lastName, String firstName, String middleName){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.otherName = Name.NO_VALUE;
    }

    /**
     * Creates an instance of Name for those users with the conventional number of names(3)
     * and any other name.
     * @param lastName : String
     * @param firstName : String
     * @param middleName : String
     * @param otherName : String
     */
    public Name(String lastName, String firstName, String middleName, String otherName){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.otherName = otherName;
    }

    /** GETTERS AND SETTERS OF PROPERTIES */

    /**
     * Returns the first name for this name object.
     * @return firstName : String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name data for this name object to the string value passed as parameter.
     * @param firstName : String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the middle name for the name object.
     * @return middleName : String
     */
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

    /**
     * This is a private method that returns the array consisting of the names of the user.
     * @return String[] nameArray.
     */
    private String[] getNameArray(){
        return this.getNameList().toArray(new String[0]);
    }

    private List<String> getNameList(){
        List<Field> fieldList = DataReflectProcessor.getFieldList(this);
        List<String> nameList = new ArrayList<>();
        fieldList.forEach(field -> {
            try {
                nameList.add((String) field.get(this));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return nameList;
    }

    /**
     * Returns the name array of the user with the specified type case.
     * @param caseType
     * @return
     */
    private String[] getNameArray(CaseType caseType){
        return DataUtils.valuesCaseArray(this.getFullNamesAsMap(), caseType);
    }

    public List<String> getNameList(CaseType caseType){
        return (ArrayList)Arrays.stream(this.getNameArray(caseType)).collect(Collectors.toList());
    }

    /**
     * Returns the keys of the map that is associated with the map of the names of the user.
     * @return String[] keys.
     */
    private String[] getNameKeys(){
        return DataReflectProcessor.getNamesOfFields(this);
    }

    private List<String> getNameKeyList(){
        return (ArrayList) Arrays.stream(this.getNameKeys()).collect(Collectors.toList());
    }

    /** PUBLIC METHODS */

    /**
     * Returns a map that consists of keys and the individual names of the user as a map data structure.
     * @return Map<String, String> map</String,>
     */
    public Map<String, String> getFullNamesAsMap(){
        return DataUtils.createMap(this.getNameKeys(), this.getNameArray());
    }

    /**
     * Returns a map that consists of keys and the individual names of the user as a map data structure,
     * with the specified case type.
     * @param caseType
     * @return
     */
    public Map<String, String> getFullNamesAsMap(CaseType caseType){
        return DataUtils.createMap(this.getNameKeys(), this.getNameArray(caseType));
    }

    /**
     * Returns the full name of the user with whitespace as the default delimiter.
     * @return String fullNames
     */
    public String getFullName(){
        String conventionalName = this.firstName + " " + this.middleName + " " +
                                  this.lastName;
        String twoName = this.firstName + " " + this.lastName;

        if (this.otherName.equalsIgnoreCase(Name.NO_VALUE)
            && this.middleName.equalsIgnoreCase(Name.NO_VALUE)){
            return twoName;
        }
        if (this.otherName.equalsIgnoreCase(Name.NO_VALUE)
                && !this.middleName.equalsIgnoreCase(Name.NO_VALUE))
            return conventionalName;

        return conventionalName + " " + this.otherName;
    }

    /**
     * Returns the fullNames of the user with the specified delimiter as a string.
     * @param delimiter
     * @return String fullName
     */
    public String getFullName(String delimiter){
        return DataUtils.concatWithSeparator(this.getFullNamesAsMap(), delimiter);
    }

    /**
     * Returns the fullNames of the user with the specified delimiter as a character.
     * @param ch : Character
     * @return String fullName
     */
    public String getFullName(char ch){
        return DataUtils.concatWithSeparator(this.getFullNamesAsMap(), ch);
    }

    /** OVERRIDDEN METHODS */

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
        if (object == null || getClass() != object.getClass()) return false;
        Name name = (Name) object;
        return Objects.equals(firstName, name.firstName) &&
                Objects.equals(middleName, name.middleName) &&
                Objects.equals(lastName, name.lastName) &&
                Objects.equals(otherName, name.otherName);
    }

    /**
     * Returns the hashcode representation for this current object.
     * @return hashcode : int.
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, otherName);
    }

    /**
     * Returns a spring representation for the current Name aspect
     * @return String object.
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
