package main;

import entities.building.Building;
import entities.building.BuildingPK;
import entities.department.Department;
import helpers.JpaUtil;

import javax.persistence.EntityManager;

public class Example4ComposedPK {
  public static void main(String[] args) {
    EntityManager entityManager = JpaUtil.getEntityManager();
    Department department = new Department();

    department.setNumber(123);
    department.setCode("ABC");
    department.setName("Department name");

    Building building = new Building();
    BuildingPK buildingPK = new BuildingPK();

    buildingPK.setCode("ABC");
    buildingPK.setNumber(123);

    building.setId(buildingPK);
    building.setName("Building Name");

    Runnable query =
        () -> {
          entityManager.persist(department);
          entityManager.persist(building);
        };

    JpaUtil.executeInTransaction(query);
  }
}
