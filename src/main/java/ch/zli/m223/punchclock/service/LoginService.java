package ch.zli.m223.punchclock.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@RequestScoped
public class LoginService {
    @Inject
    private EntityManager loginManager;
}
