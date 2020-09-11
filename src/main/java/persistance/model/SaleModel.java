package persistance.model;

import javax.persistence.*;
import java.util.Date;

//TODO Add DB relationships, primary and foreign keys to SaleModel
@Entity
@Table(name = "vanzari")
public class SaleModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vanzare")
    private Integer saleId;

    @Column(name = "fk_id_comanda")
    private Integer orderId;

    @Column(name = "numar_persoane")
    private Integer numberOfPeople;

    @Column(name = "total_plata")
    private Integer totalPrice;

    @Column(name = "data_ora_rezervare")
    private Date bookingTimeAndDate;

    public Integer getSaleId()
    {
        return saleId;
    }

    public void setSaleId(Integer saleId)
    {
        this.saleId = saleId;
    }

    public Integer getOrderId()
    {
        return orderId;
    }

    public void setOrderId(Integer orderId)
    {
        this.orderId = orderId;
    }

    public Integer getNumberOfPeople()
    {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople)
    {
        this.numberOfPeople = numberOfPeople;
    }

    public Integer getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public Date getBookingTimeAndDate()
    {
        return bookingTimeAndDate;
    }

    public void setBookingTimeAndDate(Date bookingTimeAndDate)
    {
        this.bookingTimeAndDate = bookingTimeAndDate;
    }
}
