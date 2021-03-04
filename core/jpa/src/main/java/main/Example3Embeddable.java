package main;

import entities.company.Company;
import helpers.DataGenerator;
import helpers.JpaUtil;

import javax.persistence.EntityManager;

public class Example3Embeddable {
  public static void main(String[] args) {
    EntityManager entityManager = JpaUtil.getEntityManager();
    Company company = DataGenerator.fillCompanyWithFakeData(new Company());

    try {
      entityManager.getTransaction().begin();

      entityManager.persist(company);

      entityManager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    } finally{
      entityManager.close();
    }
  }
}
