package helpers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }

    public static void executeInTransaction(Runnable query) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();

            query.run();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}
