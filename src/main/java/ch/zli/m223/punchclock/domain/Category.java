package ch.zli.m223.punchclock.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Timezone> timezones;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getname() {
        return this.name;
    }
    public void setname(String name) {
        this.name = name;
    }

    public List<Timezone> getTimezones() {
        return this.timezones;
    }
    public void setTimezones(List<Timezone> timezones) {
        this.timezones = timezones;
    }

}
