package com.mayura.examples.persistant;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (HibernateUtil.class) {
                try {
                    Configuration configuration = new Configuration();
                    configuration.configure();
                    ServiceRegistry serviceRegistry =
                            new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                    sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                    System.err.println("Initial SessionFactory creation failed." + ex);
                    throw new ExceptionInInitializerError(ex);
                }
            }
        }
        return sessionFactory;
    }

}