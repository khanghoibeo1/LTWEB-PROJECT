package ecommerce.dao;

import ecommerce.config.DBUtil;
import ecommerce.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


public class AccountDAO {

    private static AccountDAO instance;
    public static AccountDAO getInstance() throws Exception {
        if (instance == null) {
            instance = new AccountDAO();
        }
        return instance;
    }
    public static void insert(Account account){
        EntityManager em =  DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.persist(account);
            trans.commit();
        } catch(Exception e){
            e.printStackTrace();
            trans.rollback();
        } finally{
            em.close();
        }
    }

    public static void update(Account account){
        EntityManager em =  DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.merge(account);
            trans.commit();
        } catch(Exception e){
            e.printStackTrace();
            trans.rollback();
        } finally{
            em.close();
        }
    }

    public static void delete(Long accountId){
        EntityManager em =  DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            Account a = em.find(Account.class, accountId);
            em.remove(a);
            trans.commit();
        } catch(Exception e){
            e.printStackTrace();
            trans.rollback();
        } finally{
            em.close();
        }
    }
    //Tìm kiếm Account
    public Account findByID(Long accountId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Account account = em.find(Account.class, accountId);
        return account;
    }
    // Lấy toàn bộ account
    public List<Account> findAll(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String jpql = "SELECT a FROM Account a ";
        TypedQuery<Account> query = em.createQuery(jpql, Account.class);
        return query.getResultList();
    }
    // đăng nhập
    public Account accountLogin(String username, String password) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try{
            String jpql = "SELECT a FROM Account a WHERE a.username = :username " +
                            "AND a.password = :password ";
            TypedQuery<Account> query = em.createQuery(jpql, Account.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            Account account = query.getSingleResult();
            return account;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    //Kiểm tra account đã tồn tại chưa đăng ký
    public boolean checkAccountByUsername(String username) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            String jpql = "SELECT a FROM Account a WHERE a.username = :user";
            TypedQuery<Account> query = em.createQuery(jpql, Account.class);
            query.setParameter("user", username);

            Account account = query.getSingleResult();
            if(account != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    public Account getAccountByEmail(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            String jpql = "SELECT a FROM Account a WHERE a.email = :email";
            TypedQuery<Account> query = em.createQuery(jpql, Account.class);
            query.setParameter("email", email);

            Account account = query.getSingleResult();
            return account;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
    public static boolean checkAccountByEmail(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            String jpql = "SELECT a FROM Account a WHERE a.email = :email";
            TypedQuery<Account> query = em.createQuery(jpql, Account.class);
            query.setParameter("email", email);

            Account account = query.getSingleResult();
            if(account != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
}
