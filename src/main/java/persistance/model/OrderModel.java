package persistance.model;

import javax.persistence.*;

//TODO Add DB relationships, primary and foreign keys to OrderModel
@Entity
@Table(name = "comenzi")
public class OrderModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comanda_id")
    private Integer orderId;

    @Column(name = "id_comanda")
    private Integer orderIndex;


    @Column(name = "fk_id_produse")
    private Integer productId;


    @Column(name = "pret_vanzare")
    private Integer orderPrice;

    @Column(name = "cantitate_comanda")
    private Integer orderQuantity;

    public Integer getOrderId()
    {
        return orderId;
    }

    public void setOrderId(Integer orderId)
    {
        this.orderId = orderId;
    }

    public Integer getOrderIndex()
    {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex)
    {
        this.orderIndex = orderIndex;
    }

    public Integer getProductId()
    {
        return productId;
    }

    public void setProductId(Integer productId)
    {
        this.productId = productId;
    }

    public Integer getOrderPrice()
    {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice)
    {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderQuantity()
    {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity)
    {
        this.orderQuantity = orderQuantity;
    }
}
