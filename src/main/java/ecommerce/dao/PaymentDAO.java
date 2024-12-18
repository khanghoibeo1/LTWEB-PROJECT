package ecommerce.dao;

import ecommerce.config.DBUtil;
import ecommerce.entity.Payment;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings("ALL")
public class PaymentDAO {

    private static PaymentDAO instance;
    public static PaymentDAO getInstance() throws Exception {
        if (instance == null) {
            instance = new PaymentDAO();
        }
        return instance;
    }

    public static void addPayment(Payment payment){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(payment);
            trans.commit();
        } catch(Exception e){
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void updatePayment(Payment payment){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();

        try {
            em.merge(payment);
            trans.commit();
        } catch(Exception e){
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void deletePayment(int paymentId) throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            Payment payment = em.find(Payment.class, paymentId);
            if(payment != null){
                em.remove(payment);
            }else {
                throw new Exception("No find");
            }
            trans.commit();
        } catch(Exception e){
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public Payment findByID(int paymentId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Payment payment = em.find(Payment.class, paymentId);
        return payment;
    }

    public List<Payment> findAll(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Payment> query = em.createNamedQuery("Payment.findAll", Payment.class);
        return query.getResultList();
    }

    public List<Payment> getPaymentByUser (Long accountId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            String jpql = "SELECT p FROM Payment p WHERE p.account.accountId = :accountId";
            TypedQuery<Payment> query = em.createQuery(jpql, Payment.class);
            query.setParameter("accountId", accountId);

            List<Payment> listPayment = query.getResultList();
            return listPayment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
}
