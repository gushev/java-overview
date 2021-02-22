package entities.building;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BuildingPK implements Serializable {
  private String code;
  private int number;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }
}
