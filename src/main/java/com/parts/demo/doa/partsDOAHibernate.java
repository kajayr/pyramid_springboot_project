package com.parts.demo.doa;

import com.parts.demo.entity.Parts;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
//Will add more details soon
@Repository
public class partsDOAHibernate implements partsDOA {
    private EntityManager entityManager;
@Autowired
public partsDOAHibernate(EntityManager theEntityManager){
    entityManager = theEntityManager;
}

    @Override
    public List<Parts> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Parts> theQuery = currentSession.createQuery("from Parts", Parts.class);
        List<Parts> parts = theQuery.getResultList();
        return parts;
    }

    @Override
    public Parts findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Parts thePart = currentSession.get(Parts.class, theId);
        return thePart;
    }

    @Override
    public void add(Parts part) {
    Session currentSession = entityManager.unwrap(Session.class);
    currentSession.save(part);
    }

    @Override
    public void updatePart(Parts part) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(part);
    }

    @Override
    public void delete(int theId) {
    Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Parts where id=:theId");
        theQuery.setParameter("theId", theId);
        theQuery.executeUpdate();
    }
}
