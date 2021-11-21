package ch.zli.m223.punchclock.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.Timezone;

@RequestScoped
public class TimezoneService {
    @Inject
    private EntityManager timezoneManager;

    @Transactional
    public Timezone createTimezone(Timezone timezone) {
        timezoneManager.persist(timezone);
        return timezone;
    }

    @SuppressWarnings("unchecked")
    public List<Timezone> findAll() {
        var query = timezoneManager.createQuery("FROM Timezone");
        return query.getResultList();
    }

    public Timezone getTimezoneById(Long Id){
        return timezoneManager.find(Timezone.class, Id);
    }

    @Transactional
    public void delete(Long id){
        Timezone entity = getTimezoneById(id);
        timezoneManager.remove(entity);
    }

    @Transactional
    public Timezone updateTimezone(Timezone timezone){
        timezoneManager.merge(timezone);
        return timezone;
    }
}
