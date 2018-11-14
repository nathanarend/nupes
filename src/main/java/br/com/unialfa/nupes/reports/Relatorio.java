package br.com.unialfa.nupes.reports;

import java.io.InputStream;
import java.util.List;

import br.com.unialfa.nupes.entity.Declaracao;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {

	public void gerarRelatorio(List<Declaracao> lista) throws Exception{
		
		InputStream fonte = Relatorio.class.getResourceAsStream("/report/relatorio.jrxml");
		
		JasperReport report = JasperCompileManager.compileReport(fonte);
		JasperPrint prit = JasperFillManager.fillReport(report,  null, new JRBeanCollectionDataSource(lista));
		JasperViewer.viewReport(prit, false);
	}
}
