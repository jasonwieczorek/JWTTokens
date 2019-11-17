package j.m.w.requestresponsebodies;

import java.io.Serializable;

/**
 * A simple POJO that spring will use to convert an http requests body into a json object.
 *
 * refer to @{@link j.m.w.controllers.JwtAuthenticationController}
 */
public class JwtRequestBody implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String username;
    private String password;

    // need default constructor for JSON Parsing
    public JwtRequestBody() {
    }

    public JwtRequestBody(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}