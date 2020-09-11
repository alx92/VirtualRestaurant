package persistance.model;

import javax.persistence.*;

//TODO Add DB relationships, primary and foreign keys to SaleOrderModel
@Entity
@Table(name = "vanzari_comenzi")
public class SaleOrderModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comenzi_vanzari")
    private Integer saleOrderId;

    @Column(name = "fk_id_comanda")
    private Integer orderId;

    @Column(name = "fk_id_vanzare")
    private Integer saleId;

    public Integer getSaleOrderId()
    {
        return saleOrderId;
    }

    public void setSaleOrderId(Integer saleOrderId)
    {
        this.saleOrderId = saleOrderId;
    }

    public Integer getOrderId()
    {
        return orderId;
    }

    public void setOrderId(Integer orderId)
    {
        this.orderId = orderId;
    }

    public Integer getSaleId()
    {
        return saleId;
    }

    public void setSaleId(Integer saleId)
    {
        this.saleId = saleId;
    }
}
