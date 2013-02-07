package edu.mit.cci.amtprojects.kickball.cayenne.auto;

import org.apache.cayenne.CayenneDataObject;

/**
 * Class _Users was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Users extends CayenneDataObject {

    public static final String PASSWORD_PROPERTY = "password";
    public static final String USERNAME_PROPERTY = "username";

    public static final String ID_PK_COLUMN = "id";

    public void setPassword(String password) {
        writeProperty("password", password);
    }
    public String getPassword() {
        return (String)readProperty("password");
    }

    public void setUsername(String username) {
        writeProperty("username", username);
    }
    public String getUsername() {
        return (String)readProperty("username");
    }

}