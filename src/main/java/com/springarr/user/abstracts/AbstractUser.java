package com.springarr.user.abstracts;

import com.springarr.user.interfaces.User;

import java.io.Serializable;

/**
 * This class defines the highest level of abstract class for a typical User object. In other words,
 * all other concrete implementations of User must extend this abstract class and override methods
 * for their specific implementations.
 */
public abstract class AbstractUser implements User, Serializable
{

}
