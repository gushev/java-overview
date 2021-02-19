package main;

import entities.Product;
import helpers.JpaUtil;
import helpers.ProductGenerator;

import javax.persistence.EntityManager;

public class Example1ProductPersist {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        Product product = ProductGenerator.getProduct();

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(product);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}
