package ecommerce.dao;

import ecommerce.config.DBUtil;
import ecommerce.entity.Product;

import javax.persistence.*;
import java.util.List;


public class ProductDAO {

    private static ProductDAO instance;
    public static ProductDAO getInstance() throws Exception {
        if (instance == null) {
            instance = new ProductDAO();
        }
        return instance;
    }

    public static void addProduct(Product product){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(product);
            trans.commit();
        } catch(Exception e){
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void updateProduct(Product product){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();

        try {
            em.merge(product);
            trans.commit();
        } catch(Exception e){
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void deleteProduct (Long productId) throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            Product product = em.find(Product.class, productId);
            if(product != null){
                em.remove(product);
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

    public Product findByID(Long productId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Product product = em.find(Product.class, productId);
        return product;
    }

    public List<Product> findAll(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            String jpql = "SELECT p FROM Product p";
            TypedQuery<Product> query = em.createQuery(jpql, Product.class);
//            query.setParameter("category", nameCategory);
            List<Product> listProduct = query.getResultList();
            return listProduct;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }finally {
            em.close();
        }
    }

    public List<Product> getProductByNameCategory (String nameCategory) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            String jpql = "SELECT p FROM Product p WHERE p.category.name = :category";
            TypedQuery<Product> query = em.createQuery(jpql, Product.class);
            query.setParameter("category", nameCategory);
            List<Product> listProduct = query.getResultList();
            return listProduct;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }finally {
            em.close();
        }
    }

    public List<Product> searchProduct(String searchString) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            String jpql = "SELECT p FROM Product p WHERE p.name LIKE :searchString";
            TypedQuery<Product> query = em.createQuery(jpql, Product.class);
            query.setParameter("searchString", "%" + searchString + "%");
            List<Product> productList = query.getResultList();
            return productList;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }finally {
            em.close();
        }
    }

    public List<Product> getActiveProduct () {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            String jpql = "SELECT p FROM Product p WHERE p.status = : status";
            TypedQuery<Product> query = em.createQuery(jpql, Product.class);
            query.setParameter("status", "Active");
            List<Product> listProduct = query.getResultList();
            return listProduct;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }finally {
            em.close();
        }
    }

    public List<Product> searchActiveProduct(String searchString) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            String jpql = "SELECT p FROM Product p WHERE p.name LIKE :searchString AND p.status = : status";
            TypedQuery<Product> query = em.createQuery(jpql, Product.class);
            query.setParameter("searchString", "%" + searchString + "%");
            query.setParameter("status", "Active");
            List<Product> productList = query.getResultList();
            return productList;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }finally {
            em.close();
        }
    }

    public int count(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String jpql = "SELECT count(p) FROM Product p";
        Query query = em.createQuery(jpql);
        return ((Long)query.getSingleResult()).intValue();
    }
}
