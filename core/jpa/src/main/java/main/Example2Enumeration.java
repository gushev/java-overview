package main;

import entities.price.Price;
import helpers.DataGenerator;
import helpers.JpaUtil;

import javax.persistence.EntityManager;

public class Example2Enumeration {
  public static void main(String[] args) {
    EntityManager entityManager = JpaUtil.getEntityManager();
    Price price = DataGenerator.fillPriceWithFakeData(new Price());

    try {
      entityManager.getTransaction().begin();

      entityManager.persist(price);

      entityManager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    } finally{
      entityManager.close();
    }
  }
}
