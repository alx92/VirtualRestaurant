package persistance.model;

import javax.persistence.*;

//TODO Add DB relationships, primary and foreign keys to BookingModel
@Entity
@Table (name = "rezervari")
public class BookingModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rezervare")
    private Integer idReservation;

    @Column(name = "fk_numar_locuri")
    private Integer nrOfSeats;

    @Column(name = "data_rezervare")
    private String bookingDate;

    @Column(name = "ora_rezervare")
    private String bookingTime;

    @Column(name = "numar_persoane")
    private Integer nrOfPeople;

    @Column(name = "nume_client")
    private String clientName;

    @Column(name = "telefon")
    private String phoneNr;

    @Column(name = "confirmare_prezenta")
    private boolean isConfirmed;

    @Column(name = "eliberare_masa")
    private boolean  isVacant;

    @Column(name = "fk_id_vanzare")
    private Integer saleId;

    @Column(name = "rezervare_anulata")
    private boolean isCancelled;

    public Integer getIdReservation()
    {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation)
    {
        this.idReservation = idReservation;
    }

    public Integer getNrOfSeats()
    {
        return nrOfSeats;
    }

    public void setNrOfSeats(Integer nrOfSeats)
    {
        this.nrOfSeats = nrOfSeats;
    }

    public String getBookingDate()
    {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate)
    {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime()
    {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime)
    {
        this.bookingTime = bookingTime;
    }

    public Integer getNrOfPeople()
    {
        return nrOfPeople;
    }

    public void setNrOfPeople(Integer nrOfPeople)
    {
        this.nrOfPeople = nrOfPeople;
    }

    public String getClientName()
    {
        return clientName;
    }

    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }

    public String getPhoneNr()
    {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr)
    {
        this.phoneNr = phoneNr;
    }

    public boolean isConfirmed()
    {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed)
    {
        isConfirmed = confirmed;
    }

    public boolean isVacant()
    {
        return isVacant;
    }

    public void setVacant(boolean vacant)
    {
        isVacant = vacant;
    }

    public Integer getSaleId()
    {
        return saleId;
    }

    public void setSaleId(Integer saleId)
    {
        this.saleId = saleId;
    }

    public boolean isCancelled()
    {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled)
    {
        isCancelled = cancelled;
    }

    @Override
    public String toString()
    {
        return "BookingModel{" +
                "idReservation=" + idReservation +
                ", nrOfSeats=" + nrOfSeats +
                ", bookingDate='" + bookingDate + '\'' +
                ", bookingTime='" + bookingTime + '\'' +
                ", nrOfPeople=" + nrOfPeople +
                ", clientName='" + clientName + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                ", isConfirmed=" + isConfirmed +
                ", isVacant=" + isVacant +
                ", saleId=" + saleId +
                '}';
    }
}
