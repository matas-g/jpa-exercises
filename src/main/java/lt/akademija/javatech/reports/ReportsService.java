package lt.akademija.javatech.reports;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportsService {

    @Autowired
    private ReportsRepository repository;

    public List<LcdMonitorReport> getLcdMonitorReport() {
        return repository.getLcdMonitorReport();
    }
}
