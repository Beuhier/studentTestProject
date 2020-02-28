/**
 * 
 */
package com.example.student.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;




/**
 * @author Harry
 *
 */

import org.hibernate.cfg.Configuration;

import com.example.student.entity.Student;


public class HibernateUtil {
   private static StandardServiceRegistry registry;
   private static SessionFactory sessionFactory;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory == null) {
         try {
        	 
        	 // Create the SessionFactory from hibernate.cfg.xml
         	Configuration configuration = new Configuration();
         	configuration.configure("hibernate.cfg.xml");
         	System.out.println("Hibernate Configuration loaded");
        	 
        	 // Create StandardServiceRegistry
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
            
//            registryBuilder.applySettings(settings);
            registryBuilder.applySettings(configuration.getProperties());
            registry = registryBuilder.build();

            
            // Create MetadataSources
            MetadataSources sources = new MetadataSources(registry);
            sources.addAnnotatedClass(Student.class);
                     
//            // Create Metadata
            Metadata metadata = sources.getMetadataBuilder().build();
            
            // Create SessionFactory
            sessionFactory = metadata.getSessionFactoryBuilder().build();
         } catch (Exception e) {
            if (registry != null) {
               StandardServiceRegistryBuilder.destroy(registry);
            }
            e.printStackTrace();
         }
      }
      return sessionFactory;
   }
   
 //Utility method to return SessionFactory
   public static void shutdown() {
      if (registry != null) {
         StandardServiceRegistryBuilder.destroy(registry);
      }
   }
}
