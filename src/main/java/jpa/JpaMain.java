package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa.domain.Member;
import jpa.domain.Order;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Order order = new Order();
            Member member = new Member();

            member.setName("최준근");
            member.setCity("시흥시");
            member.setStreet("대은로 100번길");
            member.setZipcode("11111");

            member.addOrderList(order);




            System.out.println("=======================");

            em.persist(order);



            System.out.println("=======================");



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        em.close();

    }
}
