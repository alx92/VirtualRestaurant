package persistance.model;

import javax.persistence.*;

//TODO Add DB relationships, primary and foreign keys to ProductModel
@Entity
@Table(name = "produse")
public class ProductModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produse")
    private Integer productId;

    @Column(name = "descriere")
    private String productDescription;

    @Column(name = "cantitate")
    private Integer productQuantity;

    @Column(name = "pret_achizitie")
    private Integer buyPrice;

    @Column(name = "pret_vanzare")
    private Integer sellPrice;

    @Column(name = "fk_um_id")
    private Integer measureUnitId;

    public Integer getProductId()
    {
        return productId;
    }

    public void setProductId(Integer productId)
    {
        this.productId = productId;
    }

    public String getProductDescription()
    {
        return productDescription;
    }

    public void setProductDescription(String productDescription)
    {
        this.productDescription = productDescription;
    }

    public Integer getProductQuantity()
    {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity)
    {
        this.productQuantity = productQuantity;
    }

    public Integer getBuyPrice()
    {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice)
    {
        this.buyPrice = buyPrice;
    }

    public Integer getSellPrice()
    {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice)
    {
        this.sellPrice = sellPrice;
    }

    public Integer getMeasureUnitId()
    {
        return measureUnitId;
    }

    public void setMeasureUnitId(Integer measureUnitId)
    {
        this.measureUnitId = measureUnitId;
    }
}
