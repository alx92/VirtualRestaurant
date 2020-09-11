package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import persistance.model.*;

import java.util.Properties;

public class HibernateConfig
{
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory()
    {
        if (sessionFactory == null)
        {
            try
            {
                Configuration configuration = new Configuration();
                //DB CONFIG
                Properties dbSettings = new Properties();
                dbSettings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/restaurant_virtual?serverTimezone=UTC");
                dbSettings.put(Environment.USER, "root");
                dbSettings.put(Environment.PASS, "tres_commas03");
                dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                dbSettings.put(Environment.SHOW_SQL, "true");
                dbSettings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                //MAPPING
                configuration.setProperties(dbSettings);

                //TODO Add DB relationships, primary and foreign keys to mapped model classes
                configuration.addAnnotatedClass(BookingModel.class);
                configuration.addAnnotatedClass(MeasureUnitModel.class);
                configuration.addAnnotatedClass(MenuModel.class);
                configuration.addAnnotatedClass(MenuTypeModel.class);
                configuration.addAnnotatedClass(OrderModel.class);
                configuration.addAnnotatedClass(ProductModel.class);
                configuration.addAnnotatedClass(SaleModel.class);
                configuration.addAnnotatedClass(SaleOrderModel.class);
                configuration.addAnnotatedClass(TableTypeModel.class);


                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return sessionFactory;
    }
}
