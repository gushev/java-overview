package main;

import entities.company.CompanySecondaryTable;
import entities.product.ProductDetails;
import helpers.DataGenerator;
import helpers.JpaUtil;

import javax.persistence.EntityManager;

public class Example5OneToOne {
  public static void main(String[] args) {
    EntityManager entityManager = JpaUtil.getEntityManager();
    CompanySecondaryTable company =
        DataGenerator.fillCompanyWithFakeData(new CompanySecondaryTable());

    ProductDetails productDetails =
        DataGenerator.fillProductDetailsWithFakeData(new ProductDetails());

    Runnable query =
        () -> {
          entityManager.persist(company);
          entityManager.persist(productDetails);
        };

    JpaUtil.executeInTransaction(query);
  }
}
