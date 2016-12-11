package lt.akademija.javatech.reports;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportsRepository {

    @Autowired
    private EntityManager em;

    public List<LcdMonitorReport> getLcdMonitorReport() {
        String q = "TODO fill me";

        List<Object[]> resultList = em.createQuery(q).getResultList();
        return resultList.stream()
                 .map(objArr -> {
                     LcdMonitorReport r = new LcdMonitorReport();
                     r.title = objArr[0].toString();
                     r.count = (Long) objArr[1];
                     return r;
                 }).collect(Collectors.toList());
    }

}
