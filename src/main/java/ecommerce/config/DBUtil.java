package ecommerce.config;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("ecommerceWebPU");

    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
