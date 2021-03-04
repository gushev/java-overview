package main;

import entities.company.CompanySecondaryTable;
import entities.product.ProductDetails;
import helpers.DataGenerator;
import helpers.JpaUtil;

import javax.persistence.EntityManager;

public class Example5Relationships {
  public static void main(String[] args) {
    EntityManager entityManager = JpaUtil.getEntityManager();
    CompanySecondaryTable company =
        DataGenerator.fillCompanyWithFakeData(new CompanySecondaryTable());

    ProductDetails productDetails = DataGenerator.fillProductDetailsWithFakeData(new ProductDetails());

    try {
      entityManager.getTransaction().begin();

      //entityManager.persist(company);
      entityManager.persist(productDetails);

      entityManager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    } finally {
      entityManager.close();
    }
  }
}
