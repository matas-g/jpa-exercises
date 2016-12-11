package lt.akademija.javatech.reports;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportsController {

    @Autowired
    private ReportsService service;

    @GetMapping("/api/reports/lcd-monitors")
    public List<LcdMonitorReport> getLcdMonitorReport() {
        return service.getLcdMonitorReport();
    }
}
