package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enumeracao.WorkerLevel;

public class Worker {

	private String nome;
	private WorkerLevel nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	
	private List<HourContract> contrato = new ArrayList<>();
	
	public Worker() {
	}
	
	public Worker(String nome, WorkerLevel nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public WorkerLevel getNivel() {
		return nivel;
	}

	public void setNivel(WorkerLevel nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	public void addContrato(HourContract contratos) {
		contrato.add(contratos);
	}
	
	public void removerContrato(HourContract contratos) {
		contrato.remove(contratos);
	}
	
	public double renda(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance(); 
		for(HourContract c : contrato) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if(ano == c_ano && mes ==  c_mes) {
			soma += c.valorTotal();
			}
		}
		return soma;
	}
}
