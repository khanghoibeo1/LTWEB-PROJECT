package ecommerce.dao;

import ecommerce.config.DBUtil;
import ecommerce.entity.Cart;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class CartDAO {

    private static final CartDAO instance = new CartDAO();

    private CartDAO() {}

    public static CartDAO getInstance() {
        return instance;
    }
    public static void createCart(Cart cart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();

        try {
            em.persist(cart);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public Cart getCartByUserId (Long accountId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            String jpql = "SELECT c FROM Cart c WHERE c.account.accountId = :accountId";
            TypedQuery<Cart> query = em.createQuery(jpql, Cart.class);
            query.setParameter("accountId", accountId);

            Cart cart = query.getSingleResult();
            return cart;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

//    public double totalPrice(){
//        double total = 0;
//        CartLine cartLine = new CartLine();
//        Product p = new Product();
//        total = p.getPrice() * cartLine.getQuantity();
//        return  total;
//    }
}
