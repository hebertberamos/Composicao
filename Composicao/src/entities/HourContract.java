package entities;

import java.util.Date;

public class HourContract {

	private Date data;
	private double valorPorHora;
	private int horas;
	
	public HourContract() {
		
	}
	
	public HourContract(Date data, double valorPorHora, int horas) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.horas = horas;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public double valorTotal() {
		return valorPorHora * horas;
	}
}
