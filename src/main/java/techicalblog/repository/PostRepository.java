package techicalblog.repository;

import javafx.geometry.Pos;
import org.springframework.stereotype.Repository;
import techicalblog.model.PostModel;

import javax.persistence.*;
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
        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<PostModel> query = em.createQuery("SELECT p from PostModel p order by p.id desc", PostModel.class);
            PostModel result = query.setMaxResults(1).getSingleResult();
            return result;
        }catch(NoResultException nre) {
            return null;
        }
    }

    public PostModel createPost(PostModel newPost) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newPost);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }

        return newPost;
    }

    public PostModel getPost(Integer postId) {
        EntityManager em = emf.createEntityManager();
        return em.find(PostModel.class, postId);
    }

    public void updatePost(PostModel updatedPost) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(updatedPost);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }

    public void deletePost(Integer postId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            PostModel post = em.find(PostModel.class, postId);
            em.remove(post);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }
}
