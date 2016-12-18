package lt.akademija.javatech.reports;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportsService {

    @Autowired
    private ReportsRepository repository;

    // Version 2 - All in one query
    public List<LcdMonitorReport> getLcdMonitorReport() {
        return repository.getLcdMonitorReport();
    }

    // Version 1
    // public List<LcdMonitorReport> getLcdMonitorReport() {
    // return repository.getLcdMonitorReport().stream()
    // .map(p -> {
    // LcdMonitorReport r = new LcdMonitorReport();
    // r.title = p.getTitle();
    // r.count = (long) p.getCarts().size();
    // return r;
    // })
    // .collect(Collectors.toList());
    // }

}
