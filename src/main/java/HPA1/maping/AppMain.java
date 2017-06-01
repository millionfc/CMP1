package HPA1.maping;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class AppMain {

    private static SessionFactory sessionFactory;

    /* Reads hibernate.cfg.xml and prepares Hibernate for use     */
    protected static void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    protected static void tearDown() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public static void main(String[] args) throws Exception {
        setUp();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            
            Employee emp1 = new Employee("Million", "Solomon");
            Employee emp2 = new Employee("John", "Galway");
            Employee emp5 = new Employee("XX", "Galway");
            
            Set<Laptop> dell = new HashSet<>();
            
            
            Laptop hp1 = new Laptop("Hp","I5", emp1);
            Laptop dell1 = new Laptop("Hp","I6");
            Laptop dell2 = new Laptop("Hp","I7");
            Laptop dell3 = new Laptop("Apple","I8", emp5);
            
            
            
            dell.add(dell1);
            dell.add(dell2);
            
            Employee emp3 = new Employee("Alemu", "Chane",dell);
            
            
            session.save(emp1);
            session.save(emp2);
            session.save(hp1);
            session.save(emp3);
            session.save(dell3);
            
            
            
            /*  Passenger Flight  */
            //new Date(1985,2,14)
            Flight f1 = new Flight(1, "Addis Abab", "DC", new Date(2010,2,10));
            session.save(f1);

            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        }
        tearDown();		
    }
}

