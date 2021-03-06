package main;

import entities.company.Company;
import entities.employee.Employee;
import helpers.DataGenerator;
import helpers.JpaUtil;

import javax.persistence.EntityManager;

public class Example6OneToMany {
  public static void main(String[] args) {
    EntityManager entityManager = JpaUtil.getEntityManager();

    Company company = DataGenerator.fillCompanyWithFakeData(new Company());

    Employee employee = new Employee();
    employee.setName("Georgi Ushev");
    employee.setDepartment(company);

    JpaUtil.executeInTransaction(() -> entityManager.persist(company));
  }
}
