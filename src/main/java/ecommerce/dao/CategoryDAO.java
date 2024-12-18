package ecommerce.dao;

import ecommerce.config.DBUtil;
import ecommerce.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoryDAO {

    private static CategoryDAO instance;
    public static CategoryDAO getInstance() throws Exception {
        if (instance == null) {
            instance = new CategoryDAO();
        }
        return instance;
    }

    public static void addCategory(Category category){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(category);
            trans.commit();
        } catch(Exception e){
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void updateCategory(Category category){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();

        try {
            em.merge(category);
            trans.commit();
        } catch(Exception e){
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void deleteCategory (int categoryId) throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            Category category = em.find(Category.class, categoryId);
            if(category != null){
                em.remove(category);
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
    public Category getCategoryByName (String catName) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            String jpql = "SELECT c FROM Category c WHERE c.name = :catName";
            TypedQuery<Category> query = em.createQuery(jpql, Category.class);
            query.setParameter("catName", catName);
            Category category = query.getSingleResult();
            return category;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
    public Category findByID(int categoryId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Category category = em.find(Category.class, categoryId);
        return category;
    }

    public List<Category> findAll(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Category> query = em.createNamedQuery("Category.findAll", Category.class);
        return query.getResultList();
    }

    public int count(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String jpql = "SELECT count(c) FROM Category c";
        Query query = em.createQuery(jpql);
        return ((Long)query.getSingleResult()).intValue();
    }
}
