package service;

import hibernate.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import persistance.model.BookingModel;
import persistance.model.MenuModel;
import persistance.model.TableTypeModel;

import java.util.Collections;
import java.util.List;

public class UserService
{
    private Session session = HibernateConfig.getSessionFactory().openSession();
    //Transaction transaction = session.beginTransaction();
    private BookingModel bookingModel = new BookingModel();
    //private TableTypeModel tableTypeModel = new TableTypeModel();


    public void addBooking(String bookingDate, String bookingTime, String phoneNr, Integer nrOfPeople, String clientName)
    {
        bookingModel.setBookingDate(bookingDate);
        bookingModel.setBookingTime(bookingTime);
        bookingModel.setPhoneNr(phoneNr);
        bookingModel.setNrOfPeople(nrOfPeople);
        bookingModel.setClientName(clientName);
        bookingModel.setConfirmed(false);
        bookingModel.setVacant(false);
        Transaction transaction = session.beginTransaction();
        session.save(bookingModel);
        transaction.commit();
        //session.getTransaction().commit();
    }

    public List<BookingModel> showUserBooking(String phoneNr)
    {
        try (Session session = HibernateConfig.getSessionFactory().openSession())
        {
            Query query = session.createQuery("from BookingModel where phoneNr = :numar_telefon");
            query.setParameter("numar_telefon", phoneNr);

            List bookings = query.list();
            System.out.println("here");

            return bookings;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Class not found!");
            return Collections.emptyList();
        }
    }

    public void cancelBooking(Integer id)
    {
        try (Session session = HibernateConfig.getSessionFactory().openSession())
        {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from BookingModel where idReservation = :id");
            query.setParameter("id", id);

            BookingModel booking = (BookingModel) query.getSingleResult();

            booking.setCancelled(true);
            session.save(booking);

            transaction.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void displayOrderMenu()
    {
//        MenuModel menu = new MenuModel();

        try (Session session = HibernateConfig.getSessionFactory().openSession())
        {
            Query query = session.createQuery("from MenuModel");

            List result = query.getResultList();

            for (int i = 0; i < result.size(); i++)
            {
                MenuModel menu = (MenuModel) result.get(i);
                System.out.println(menu.getId() + ". " + menu.getDescription() + " - Price " + menu.getPrice() + " RON");
            }
            System.out.println();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Object selectedItems(Integer orderOption) //use generics
    {
        try (Session session = HibernateConfig.getSessionFactory().openSession())
        {
            Query query = session.createQuery("from MenuModel where id = :id");
            query.setParameter("id", orderOption);
            //session.save(query.getSingleResult());

            return query.getSingleResult();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  null;
        }
    }

    public void tableManagement(Integer nrOfPeople)
    {
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("from tip_masa where nrOfSeats = :nr_of_people");
        query.setParameter("nr_of_people", nrOfPeople);
        TableTypeModel tableTypeModels = (TableTypeModel) query.getSingleResult();

        for (TableTypeModel table : tableTypeModels)
        {
            int tableTotal = table.getNrOfSeats();
            if (table.getNrOfSeats().equals(nrOfPeople))
            {
                table.setTableTotalByType(--tableTotal);
            }
        }
        session.save(tableTypeModel);
        transaction.commit();
    }

}
