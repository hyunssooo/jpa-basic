package hellojpa;

import hellojpa.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        try {

            Member member1 = new Member();
            Member member2 = new Member();
            Member member3 = new Member();

            System.out.println("=================");
            entityManager.persist(member1);
            entityManager.persist(member2);
//            entityManager.persist(member3);
            System.out.println("=================");

            System.out.println(member1.getId());
            System.out.println(member2.getId());
            System.out.println(member3.getId());

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }


        entityManagerFactory.close();
    }
}
