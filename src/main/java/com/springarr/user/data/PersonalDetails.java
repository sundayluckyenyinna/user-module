package com.springarr.user.data;
import com.springarr.user.abstracts.ObjectDataContainer;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class defines the object that will hold the personal details for the users of this application.
 */
public class PersonalDetails extends ObjectDataContainer implements Serializable
{
    /** A data container for the name details of the user. */
    private Name name;

    /** A data container for the origin object of the user. */
    private Origin origin;

    /**
     * Creates an instance of this object with all sub objects initialized to defaults.
     */
    public PersonalDetails(){
       this.name = new Name();
       this.origin = new Origin();
    }

    /**
     * Creates an instance of this object with the Name and Origin objects set to the values
     * passed as parameters.
     * @param name : Name.
     * @param origin : Origin.
     */
    public PersonalDetails(Name name, Origin origin){
        this.name = name;
        this.origin = origin;
    }

    /**
     * Returns the Name object for this PersonalDetails object.
     * @return : Name
     */
    public Name getName() {
        return name;
    }

    /**
     * Sets the Name object for this PersonalDetails object to the Name value passed
     * as parameter.
     * @param name : Name
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * Returns the Origin object for this PersonalDetails object.
     * @return origin : Origin
     */
    public Origin getOrigin() {
        return origin;
    }

    /**
     * Sets the Origin object to the Origin value passed as parameter.
     * @param origin : Origin
     */
    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    /**
     * Returns the string representation for this object.
     * @return object : String.
     */
    @Override
    public String toString() {
        return "{" +
                "name=" + name +
                ", origin=" + origin +
                '}';
    }

    /**
     * Returns a boolean to indicate if this current object is equal to another object
     * passed as parameter.
     * @param o : Object (PersonalDetails)
     * @return bool : boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalDetails)) return false;
        PersonalDetails that = (PersonalDetails) o;
        return Objects.equals(getName(), that.getName())
                && Objects.equals(getOrigin(), that.getOrigin());
    }

    /**
     * Returns the hashcode representation for this object.
     * @return hashcode : int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getOrigin());
    }

}
