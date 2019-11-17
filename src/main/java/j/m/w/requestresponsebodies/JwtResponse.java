package j.m.w.requestresponsebodies;

import java.io.Serializable;

/**
 * A simple POJO that spring will use to send an http response body as a json object.
 *
 * refer to @{@link j.m.w.controllers.JwtAuthenticationController}
 */
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}
