package techicalblog.repository;

import javafx.geometry.Pos;
import org.springframework.stereotype.Repository;
import techicalblog.model.PostModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public List<PostModel> getAllPosts() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<PostModel> query = em.createQuery("SELECT p from PostModel p", PostModel.class);
        List<PostModel> resultList = query.getResultList();

        return resultList;
    }

    public PostModel getLatestPost() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<PostModel> query = em.createQuery("SELECT p from PostModel p order by p.id desc", PostModel.class);
        PostModel result = query.setMaxResults(1).getSingleResult();
        return result;
    }
}
