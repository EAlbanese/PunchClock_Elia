package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.User;
import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.Claims;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;

@RequestScoped
public class AuthenticationService {
    @Inject
    private EntityManager entityManager;

    public Boolean CheckIfUserExists(User u) {
        var query =
                entityManager.createQuery("SELECT COUNT(*) FROM User WHERE email = :email and password = :pw")
                        .setParameter("email", u.getEmail())
                        .setParameter("pw", u.getPassword());
        var res = query.getSingleResult();
        return (Long) res == 1;
    }

    public String GenerateValidJwtToken(String email) {
        String token =
                Jwt.issuer("https://zli.ch/issuer")
                        .upn(email)
                        .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                        .claim(Claims.birthdate.name(), "2001-07-13")
                        .expiresIn(Duration.ofHours(1))
                        .sign();
        return token;
    }

    public static String hashPassword(String password)  {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[250];
        random.nextBytes(salt);

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(salt);

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
        return hashedPassword.toString();
    }

    public User getUserByEmail(String email) {
        var query =
                entityManager.createQuery("SELECT * FROM User WHERE email = :email")
                        .setParameter("email", email);
        var res = query.getSingleResult();
        return (User) res;
    }

    public boolean checkHashedPassword(String email, String password) {
        User user = getUserByEmail(email);
        return user.getPassword().equals(hashPassword(password));
    }

}
