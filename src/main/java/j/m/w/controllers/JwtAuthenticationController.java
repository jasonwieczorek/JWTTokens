package j.m.w.controllers;

import j.m.w.components.JwtTokenUtil;
import j.m.w.requestresponsebodies.JwtRequestBody;
import j.m.w.requestresponsebodies.JwtResponse;
import j.m.w.services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    /**
     * Handles he
     *
     * @param requestBody
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestBody requestBody) throws Exception {

        // Uses the AuthenticatonManager that is wired up with a UserDetailsService
        authenticate(requestBody.getUsername(), requestBody.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(requestBody.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    /**
     * This will invoke Springs authentication flow, it will invoke the UserDetailsService (our custom one)
     * and attempt to build and return a user object. While building the user object. It will encrypt the
     * passed password to ensure it matches the currently encrypted pword from the repository. If it doesn't
     * match, it'll blow up.
     */
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
