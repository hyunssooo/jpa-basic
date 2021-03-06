package hellojpa;

import hellojpa.domain.Member;
import hellojpa.domain.Team;

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
            Team teamA = new Team();
            teamA.setName("teamA");
            entityManager.persist(teamA);

            Member member = new Member();
            member.setUserName("test");
            member.setTeam(teamA);
            entityManager.persist(member);

            Member findMember = entityManager.find(Member.class, member.getId());

            Team findTeam = findMember.getTeam();
            System.out.println(findTeam.getName());

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }


        entityManagerFactory.close();
    }
}
