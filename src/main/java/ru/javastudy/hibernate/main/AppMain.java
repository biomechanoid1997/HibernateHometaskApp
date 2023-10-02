package ru.javastudy.hibernate.main;
import org.hibernate.Session;
import ru.javastudy.hibernate.dao.PetsEntity;
import ru.javastudy.hibernate.utils.HibernateSessionFactory;
public class AppMain {
    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        PetsEntity petsEntity = new PetsEntity();
        petsEntity.setAnimalAge(15);
        petsEntity.setAnimalName("Moira");
        petsEntity.setAnimalType("Cat");
        petsEntity.setAnimalHost("Claire");
        petsEntity.setAnimalColor("Brown");
        session.save(petsEntity);
        session.getTransaction().commit();
        session.close();
    }
}
