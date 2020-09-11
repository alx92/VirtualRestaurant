package service;

import hibernate.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistance.model.OrderModel;

public class RestaurantService
{
    public void addOrder(Integer idComanda, Integer idProduseFk, Integer pret, Integer cantitate)
    {
        OrderModel orderModel = new OrderModel();

        orderModel.setOrderIndex(idComanda);
        orderModel.setProductId(idProduseFk);
        orderModel.setOrderPrice(pret);
        orderModel.setOrderQuantity(cantitate);

        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(orderModel);
        transaction.commit();
        //session.close();
    }
}
