
import jakarta.persistence.Id;
import org.hibernate.Session;
import ru.javastudy.hibernate.dao.PetsEntity;
import ru.javastudy.hibernate.utils.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /////////////////
 //       System.out.println("Hibernate tutorial");
 //       Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        session.beginTransaction();
  //      PetsEntity petsEntity = new PetsEntity();
//        petsEntity.setAnimalAge(15);
 //       petsEntity.setAnimalName("Chappie");
 //       petsEntity.setAnimalType("Dog");
 //       petsEntity.setAnimalHost("Edgar");
 //       petsEntity.setAnimalColor("Brown");
//        session.save(petsEntity);
 //       session.getTransaction().commit();
//        session.close();
        ///////////////////////////
  Session session = HibernateSessionFactory.getSessionFactory().openSession();
  session.beginTransaction();
  PetsEntity petsEntity = new PetsEntity();
      ArrayList<PetsEntity> resultSet = new ArrayList<PetsEntity>();
      PetsEntity tempEntity = new PetsEntity();
      boolean checkedList = false;
        for (int i = 0; i <100 ; i++) {
            tempEntity = session.get(PetsEntity.class, i);
            if (tempEntity !=null) {
                System.out.println("pet id: " + tempEntity.getId() + " pet name: " + tempEntity.getAnimalName() + " pet type: " + tempEntity.getAnimalType() + " pet color: " + tempEntity.getAnimalColor() + " pet age: " + tempEntity.getAnimalAge() + " pet host: " + tempEntity.getAnimalHost());
            }
            }
        session.close();


        System.out.println("Please enter the desired operation: create|| update || delete");
        Scanner commandInput = new Scanner(System.in);
        String action = commandInput.nextLine();

        switch (action){
            case "create":
                Session createSession = HibernateSessionFactory.getSessionFactory().openSession();
           System.out.println("Please enter the animal name");
           String animalName = commandInput.nextLine();
           System.out.println("Please enter animal type");
           String animalType = commandInput.nextLine();
           System.out.println("Please enter the animal color");
           String animalColor = commandInput.nextLine();
           System.out.println("And who is the host?");
           String animalHost = commandInput.nextLine();
           System.out.println("How old is the animal?");
           int animalAge = commandInput.nextInt();
           petsEntity.setAnimalName(animalName);
                petsEntity.setAnimalType(animalType);
                petsEntity.setAnimalColor(animalColor);
                petsEntity.setAnimalAge(animalAge);
                petsEntity.setAnimalHost(animalHost);
                createSession.save(petsEntity);
                createSession.close();
                break;

            case "update":
                Session updateSession = HibernateSessionFactory.getSessionFactory().openSession();
                System.out.println("Enter the animal ID");
                int animalId = commandInput.nextInt();

                System.out.println("Please enter the animal name");
                String animalNameUpdate = commandInput.nextLine();
                 animalNameUpdate = commandInput.nextLine();
                System.out.println("Please enter animal type");
                String animalTypeUpdate = commandInput.nextLine();
                System.out.println("Please enter the animal color");
                String animalColorUpdate = commandInput.nextLine();
                System.out.println("And who is the host?");
                String animalHostUpdate = commandInput.nextLine();
                System.out.println("How old is the animal?");
                int animalAgeUpdate = commandInput.nextInt();
                updateSession.beginTransaction();
                petsEntity.setId(animalId);
                petsEntity.setAnimalName(animalNameUpdate);
                petsEntity.setAnimalType(animalTypeUpdate);
                petsEntity.setAnimalColor(animalColorUpdate);
                petsEntity.setAnimalAge(animalAgeUpdate);
                petsEntity.setAnimalHost(animalHostUpdate);
                updateSession.saveOrUpdate(petsEntity);
                updateSession.getTransaction().commit();
                break;
            case "delete":
                Session deleteSession = HibernateSessionFactory.getSessionFactory().openSession();
                System.out.println("Enter the animal ID for deletion");
                 animalId = commandInput.nextInt();
                deleteSession.beginTransaction();
               petsEntity = deleteSession.get(PetsEntity.class, animalId);
                petsEntity.setId(animalId);
                petsEntity.setAnimalName(petsEntity.getAnimalName());
                petsEntity.setAnimalType(petsEntity.getAnimalType());
                petsEntity.setAnimalAge(petsEntity.getAnimalAge());
                petsEntity.setAnimalColor(petsEntity.getAnimalColor());
                petsEntity.setAnimalColor(petsEntity.getAnimalHost());
                deleteSession.delete(petsEntity);
                deleteSession.getTransaction().commit();
                break;
            default:
                System.err.println("Error: invalid operation");
                break;
        }

        commandInput.close();

    }
}
