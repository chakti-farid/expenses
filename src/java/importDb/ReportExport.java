/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importDb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author fchakti
 */
@ManagedBean(name="reportexport")
@SessionScoped
 
public class ReportExport {
    
    Connection conn;
    JasperPrint jasperprint; 
    
    public void exp(String reportpath ) throws JRException, ClassNotFoundException, SQLException{
        System.out.print("xxx");
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/family_expenses","root","123");
    System.out.print("vvv");
    jasperprint= JasperFillManager.fillReport(reportpath, new HashMap(),conn);
    System.out.print("ttttt");
        
    }
    
    public void pdf(String rpath ) throws JRException, IOException, ClassNotFoundException, SQLException {
    exp(rpath);
    System.out.print("expxompete");
    HttpServletResponse httpServletResponse= (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pdf");
    ServletOutputStream servletOutputStream;
    servletOutputStream = httpServletResponse.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperprint, servletOutputStream); 
    System.out.print("ggg");
    FacesContext.getCurrentInstance().responseComplete();
    servletOutputStream.flush();
    servletOutputStream.close();
    }
    
    
    
}
