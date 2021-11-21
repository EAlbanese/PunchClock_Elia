package ch.zli.m223.punchclock.domain;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

import static ch.zli.m223.punchclock.service.AuthenticationService.hashPassword;
import static java.util.Objects.hash;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Task> task;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }

    public List<Task> getTask() {
        return this.task;
    }

    public User(Long id, String firstname, String lastname, String email, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public User() {
        super();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("helloadfsfasdf"));

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[250];
        random.nextBytes(salt);

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);

        byte[] hashedPassword = md.digest("helloadfsfasfasfddasfasdfsdasdf".getBytes(StandardCharsets.UTF_8));
        System.out.println(hashedPassword.toString());



    }
}
