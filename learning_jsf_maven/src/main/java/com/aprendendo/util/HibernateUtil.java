package com.aprendendo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION = "hibernate_session";
    
    static {
        try {
            System.out.println("Tentando abrir uma Session Factory");
            Configuration configurar = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(configurar.getProperties()).buildServiceRegistry();
            
            sessionFactory = configurar.buildSessionFactory(serviceRegistry);
            
            System.out.println("Session Factory criada com sucesso...");
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao iniciar a Session Factory. "+ ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionfactory() {
        return sessionFactory;
    }
}
