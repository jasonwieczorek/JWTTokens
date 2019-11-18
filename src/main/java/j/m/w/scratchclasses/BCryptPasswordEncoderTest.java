package j.m.w.scratchclasses;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Used to test BCrypting password hashing. You won't be able to decrypt it!
 * <p>
 * This is important to understand because our application won't work while building userdetails if we don't
 * work with hashed passwords that are returned from our services
 */
public class BCryptPasswordEncoderTest {

    public static void main(String args[]) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("BCryptPassword"));
    }
}

