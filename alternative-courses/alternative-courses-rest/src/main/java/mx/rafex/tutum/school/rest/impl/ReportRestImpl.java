package mx.rafex.tutum.school.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import mx.rafex.tutum.school.rest.ReportRest;
import mx.rafex.tutum.school.service.StudentService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
public class ReportRestImpl implements ReportRest {

    @Autowired
    private StudentService studentService;

    @Override
    public ResponseEntity<?> list(int idStudent) {

        try {

            JasperPrint empReport = studentService.report(idStudent);

            HttpHeaders headers = new HttpHeaders();
            // set the PDF format
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "scores.pdf");
            // create the report in PDF format
            return new ResponseEntity<byte[]>(
                    JasperExportManager.exportReportToPdf(empReport), headers,
                    HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
