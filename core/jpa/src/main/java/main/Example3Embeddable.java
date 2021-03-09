package main;

import entities.company.Company;
import helpers.DataGenerator;
import helpers.JpaUtil;

import javax.persistence.EntityManager;

public class Example3Embeddable {
  public static void main(String[] args) {
    EntityManager entityManager = JpaUtil.getEntityManager();
    Company company = DataGenerator.fillCompanyWithFakeData(new Company());

    JpaUtil.executeInTransaction(() -> entityManager.persist(company));
  }
}
