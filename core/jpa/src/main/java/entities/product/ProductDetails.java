package entities.product;

import javax.persistence.*;

@Entity
@Table(name = "product_details")
public class ProductDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String kcal;

  // This is the default column name, left it here only as an example
  @JoinColumn(name = "product_id")
  @OneToOne(cascade = CascadeType.ALL)
  private Product product;

  public String getKcal() {
    return kcal;
  }

  public void setKcal(String kcal) {
    this.kcal = kcal;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    product.setProductDetails(this);
    this.product = product;
  }
}
