package entities.building;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class Building {

  @EmbeddedId
  private BuildingPK id;

  private String name;

  public BuildingPK getId() {
    return id;
  }

  public void setId(BuildingPK id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
