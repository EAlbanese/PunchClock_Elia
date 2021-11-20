package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.domain.Timezone;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.Time;
import java.util.List;

@ApplicationScoped
@RolesAllowed("User")
public class CategoryService {

    @Inject
    private EntityManager categoryManager;

    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        var query = categoryManager.createQuery("FROM Category");
        return query.getResultList();
    }

    @Transactional
    public Category createTimezone(Category category) {
        categoryManager.persist(category);
        return category;
    }



}
