package ch.zli.m223.punchclock.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String taskname;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @Column
    private Long user_identification;

    @OneToOne
    @JoinColumn(name = "timezone_id", nullable = true)
    private Timezone timezone;

    public Long getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname() {
        this.taskname = taskname;
    }

    public void setTimezonet(Timezone timezone) {
        this.timezone = timezone;
    }

    public Timezone getTimezone() {
        return this.timezone;
    }

    public void setUser(User user) {
        this.user_identification = user.getId();
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public Long getUser_identification() {
        return user_identification;
    }

    public void setUser_identification(Long user_id) {
        this.user_identification = user_id;
    }
}
