package lt.akademija.javatech.reports;

import javax.persistence.EntityManager;
import java.util.List;

import lt.akademija.javatech.product.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportsRepository {

    @Autowired
    private EntityManager em;

    public List<ProductEntity> getLcdMonitorReport() {
        return em.createQuery("TODO fill me").getResultList();
    }
}
