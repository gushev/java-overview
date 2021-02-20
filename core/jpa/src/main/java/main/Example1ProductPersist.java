package main;

import entities.IProduct;
import entities.Product;
import entities.ProductGenTypeTable;
import entities.ProductUuidPk;
import helpers.JpaUtil;
import helpers.ProductGenerator;

import javax.persistence.EntityManager;

public class Example1ProductPersist {
  public static void main(String[] args) {
    EntityManager entityManager = JpaUtil.getEntityManager();
    IProduct product = ProductGenerator.fillWithFakeData(new Product());
    IProduct productGenTypeTable = ProductGenerator.fillWithFakeData(new ProductGenTypeTable());
    IProduct productUuidPk = ProductGenerator.fillWithFakeData(new ProductUuidPk());

    try {
      entityManager.getTransaction().begin();

      entityManager.persist(product);
      entityManager.persist(productGenTypeTable);
      entityManager.persist(productUuidPk);

      entityManager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }
  }
}
