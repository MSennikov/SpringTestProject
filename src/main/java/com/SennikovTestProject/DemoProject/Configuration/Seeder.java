package com.SennikovTestProject.DemoProject.Configuration;

import com.SennikovTestProject.DemoProject.DemoProjectApplication;
import com.SennikovTestProject.DemoProject.Entity.Roles;
import com.SennikovTestProject.DemoProject.Entity.User;
import com.SennikovTestProject.DemoProject.Repository.UserRep;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;


@org.springframework.context.annotation.Configuration
public class Seeder{

    private static final Logger log = LoggerFactory.getLogger(DemoProjectApplication.class);

    @Autowired
    EntityManagerFactory factory;

    @Bean
    public CommandLineRunner demo(UserRep repository) {
        return (args) -> {
            // save a couple of customers
            SessionFactory sessionFactory;
            try {
                if(factory != null) {
                    sessionFactory = factory.unwrap(SessionFactory.class);
                }else throw new NullPointerException("bug");
            } catch (Throwable exep){
                 log.info("Failed"+ exep);
                throw new ExceptionInInitializerError(exep);
            }
            Session session = sessionFactory.openSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                for(int i=0; i<10; i++){
                    repository.save(new User("Sania"+i,"lOSOS'"+i, "123", Roles.USER));
                }


                // fetch all customers
                log.info("Customers found with findAll():");
                log.info("-------------------------------");
                for (User customer : repository.findAll()) {
                    log.info(customer.toString());
                }
                log.info("");

                // fetch an individual customer by ID
                repository.findById(1L)
                        .ifPresent(customer -> {
                            log.info("Customer found with findById(1L):");
                            log.info("--------------------------------");
                            log.info(customer.toString());
                            log.info("");
                        });
                transaction.commit();

            } catch (HibernateException e){
                if (transaction!=null) transaction.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }

        };
    }
}
