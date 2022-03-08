/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webservice.create.api.pertemuan.empatbelas.c;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import webservice.create.api.pertemuan.empatbelas.c.exceptions.NonexistentEntityException;
import webservice.create.api.pertemuan.empatbelas.c.exceptions.PreexistingEntityException;

/**
 *
 * @author pascal
 */
public class MahasiswadataJpaController implements Serializable {

    public MahasiswadataJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("webservice.create.api_pertemuan.empatbelas.c_jar_0.0.1-SNAPSHOTPU");

    
    MahasiswadataJpaController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
    

    public void create(Mahasiswadata mahasiswadata) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mahasiswadata);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMahasiswadata(mahasiswadata.getId()) != null) {
                throw new PreexistingEntityException("Mahasiswadata " + mahasiswadata + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mahasiswadata mahasiswadata) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mahasiswadata = em.merge(mahasiswadata);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mahasiswadata.getId();
                if (findMahasiswadata(id) == null) {
                    throw new NonexistentEntityException("The mahasiswadata with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mahasiswadata mahasiswadata;
            try {
                mahasiswadata = em.getReference(Mahasiswadata.class, id);
                mahasiswadata.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mahasiswadata with id " + id + " no longer exists.", enfe);
            }
            em.remove(mahasiswadata);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mahasiswadata> findMahasiswadataEntities() {
        return findMahasiswadataEntities(true, -1, -1);
    }

    public List<Mahasiswadata> findMahasiswadataEntities(int maxResults, int firstResult) {
        return findMahasiswadataEntities(false, maxResults, firstResult);
    }

    private List<Mahasiswadata> findMahasiswadataEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mahasiswadata.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Mahasiswadata findMahasiswadata(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mahasiswadata.class, id);
        } finally {
            em.close();
        }
    }

    public int getMahasiswadataCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mahasiswadata> rt = cq.from(Mahasiswadata.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
