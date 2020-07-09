package condo.entities;

import java.util.Calendar;
import java.util.Date;

public class Informativo {
	protected String assuntoInfo;
	protected String conteudoInfo;
	protected Date dataInfo;

	public Informativo(String assuntoInfo, String conteudoInfo, Date dataInfo) {
		super();
		this.assuntoInfo = assuntoInfo;
		this.conteudoInfo = conteudoInfo;
		this.dataInfo = dataInfo;
	}

	public String getAssuntoInfo() {
		return assuntoInfo;
	}

	public void setAssuntoInfo(String assuntoInfo) {
		this.assuntoInfo = assuntoInfo;
	}

	public String getConteudoInfo() {
		return conteudoInfo;
	}

	public void setConteudoInfo(String conteudoInfo) {
		this.conteudoInfo = conteudoInfo;
	}

	public String getDataInfo() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataInfo);
		String ano = "/" + cal.get(Calendar.YEAR);
		String mes = ((cal.get(Calendar.MONTH) + 1) < 10) ? "/0" + (cal.get(Calendar.MONTH) + 1)
				: "/" + (cal.get(Calendar.MONTH) + 1);
		String dia = ((cal.get(Calendar.DATE)) < 10) ? "0" + (cal.get(Calendar.DATE)) : "" + (cal.get(Calendar.DATE));
		String data = dia + mes + ano;
		return data;
	}

	public void setDataInfo(Date dataInfo) {
		this.dataInfo = dataInfo;
	}
}
