package techicalblog.repository;

import org.springframework.stereotype.Repository;
import techicalblog.model.UserModel;

import javax.persistence.*;

@Repository
public class UserRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public void registerUser(UserModel newUser) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newUser);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }

    public UserModel checkUser(String username, String password) {

        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<UserModel> typedQuery = em.createQuery("SELECT u FROM UserModel u WHERE u.username = :username AND u.password = :password", UserModel.class);
            typedQuery.setParameter("username", username);
            typedQuery.setParameter("password", password);

            return typedQuery.getSingleResult();
        }catch(NoResultException nre) {
            return null;
        }
    }
}
