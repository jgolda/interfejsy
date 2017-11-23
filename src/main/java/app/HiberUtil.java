/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.File;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author zti
 */

public final class HiberUtil {
    /**
     * choose type of mapping definition XML or annotations
     */
    public enum Mapping {
        /**
         * use xml defined mappings for configuration
         */
        XML,
        /**
         * use annotation defined mappings for confuguration
         */
        ANN;
    }
    /**
     *
     * @param mapping
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory(Mapping mapping) {

        switch(mapping){
            case XML:
                return(getXMLSessionFactory());
            case ANN:
                return(getANNSessionFactory());
            default:
                return(getXMLSessionFactory());
        }
    }

    public static SessionFactory getXMLSessionFactory() {
        try {
            File mappingDir = new File("src/main/resources/META-INF/mapping");
            Configuration config = new Configuration().configure("META-INF/hibernate.cfg.xml");

            config.addDirectory(mappingDir);
            SessionFactory sf = config.buildSessionFactory();
//            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
//            registryBuilder.applySettings(config.getProperties());
//            ServiceRegistry serviceRegistry = registryBuilder.build();
//
//            SessionFactory sf = config.buildSessionFactory(serviceRegistry);

            return (sf);
        }
        catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getANNSessionFactory() {
        try {
            Configuration config = new Configuration().configure("META-INF/hibernate.cfg.xml");

            config.addAnnotatedClass(Adres.class)
                    .addAnnotatedClass(Cennik.class)
                    .addAnnotatedClass(Lekarz.class)
                    .addAnnotatedClass(Osoba.class)
                    .addAnnotatedClass(Pacjent.class)
                    .addAnnotatedClass(Usluga.class)
                    .addAnnotatedClass(Wizyta.class)
                    .addAnnotatedClass(Zabieg.class)
            ;
            SessionFactory sf = config.buildSessionFactory();
            System.out.println("Utworzylem konfig");

//            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
//            registryBuilder.applySettings(config.getProperties());
//            ServiceRegistry serviceRegistry = registryBuilder.build();
//
//            SessionFactory sf = config.buildSessionFactory(serviceRegistry);

            return (sf);
        }
        catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }



}

