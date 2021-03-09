package main;

import entities.product.IProduct;
import entities.product.Product;
import entities.product.ProductGenTypeTable;
import entities.product.ProductUuidPk;
import helpers.JpaUtil;
import helpers.DataGenerator;

import javax.persistence.EntityManager;

public class Example1Persist {
  public static void main(String[] args) {
    EntityManager entityManager = JpaUtil.getEntityManager();
    IProduct product = DataGenerator.fillProductWithFakeData(new Product());
    IProduct productGenTypeTable = DataGenerator.fillProductWithFakeData(new ProductGenTypeTable());
    IProduct productUuidPk = DataGenerator.fillProductWithFakeData(new ProductUuidPk());

    Runnable query = () -> {
      entityManager.persist(product);
      entityManager.persist(productGenTypeTable);
      entityManager.persist(productUuidPk);
    };

    JpaUtil.executeInTransaction(query);
  }
}
