package main;

import entities.price.Price;
import helpers.DataGenerator;
import helpers.JpaUtil;

import javax.persistence.EntityManager;

public class Example2Enumeration {
  public static void main(String[] args) {
    EntityManager entityManager = JpaUtil.getEntityManager();
    Price price = DataGenerator.fillPriceWithFakeData(new Price());

    JpaUtil.executeInTransaction(() -> entityManager.persist(price));
  }
}
