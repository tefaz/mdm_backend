package com.tefaz.mdm_backend;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TableCreationService {

    @Autowired
    private EntityManager em;

    @Transactional
    public boolean tableExists(String tableName) {
        String query = "SELECT count(*) FROM information_schema.`tables` WHERE table_name = ?";
        Long count = (Long) em.createNativeQuery(query)
                .setParameter(1, tableName)
                .getSingleResult();
        return count > 0;
    }

    @Transactional
    public void createTable(String script) {
        em.createNativeQuery(script).executeUpdate();
    }
}