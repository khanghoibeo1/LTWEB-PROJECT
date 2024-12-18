package ecommerce.dao;

import ecommerce.config.DBUtil;
import ecommerce.entity.Feedback;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class FeedbackDAO {

    private static FeedbackDAO instance;
    public static FeedbackDAO getInstance() throws Exception {
        if (instance == null) {
            instance = new FeedbackDAO();
        }
        return instance;
    }
    public static void addFeedback(Feedback feedback){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(feedback);
            trans.commit();
        } catch(Exception e){
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void updateFeedback(Feedback feedback){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();

        try {
            em.merge(feedback);
            trans.commit();
        } catch(Exception e){
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void deleteFeedback(int feedbackId){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            Feedback feedback = em.find(Feedback.class, feedbackId);
            em.remove(feedback);
            trans.commit();
        } catch(Exception e){
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public Feedback findByID(int feedbackId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Feedback feedback = em.find(Feedback.class, feedbackId);
        return feedback;
    }

    public List<Feedback> commentInProduct(Long productId){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            String jpql = "SELECT f FROM Feedback f WHERE f.product.id = :id";
            TypedQuery<Feedback> query = em.createQuery(jpql, Feedback.class);
            query.setParameter("id", productId);
            List<Feedback> listcomment = query.getResultList();
            return listcomment;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
}
