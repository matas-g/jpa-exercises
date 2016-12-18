package lt.akademija.javatech.reports;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportsRepository {

    @Autowired
    private EntityManager em;

    // Version 2 - All in one query
    public List<LcdMonitorReport> getLcdMonitorReport() {
        String q = "SELECT p.title, count(c) from ProductEntity p " +
                "JOIN p.specifications s " +
                "JOIN p.carts c " +
                "WHERE s.key = 'monitorType' AND s.value = 'LCD' " +
                "GROUP BY p.title";

        List<Object[]> resultList = em.createQuery(q).getResultList();
        return resultList.stream().map(objArr -> {
            LcdMonitorReport r = new LcdMonitorReport();
            r.title = objArr[0].toString();
            r.count = (Long) objArr[1];
            return r;
        }).collect(Collectors.toList());
    }

    // Version 1 - Rodo ir prekes nepriklausancias krepseliui.
    
    // public List<ProductEntity> getLcdMonitorReport() {
    // return em.createQuery(
    // "SELECT p From ProductEntity p " +
    // "JOIN p.specifications s " +
    // "WHERE s.key = 'monitorType' AND s.value = 'LCD'"
    // ).getResultList();
    // }

}
