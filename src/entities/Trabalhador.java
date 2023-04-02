package entities;

import java.util.ArrayList;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {
	
	private String nome;
	private NivelTrabalhador nivel;
	private Double salario;
	
	private Departamento departamento;
	
	private List<ContratoHora> contratos= new ArrayList<>();
	
	public Trabalhador() {
		
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double salario, Departamento departamento) {
		super();
		this.nome = nome;
		this.nivel = nivel;
		this.salario = salario;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public void adicionarContratos(ContratoHora contrato) {
		contratos.add(contrato);
	}
	public void removerContratos(ContratoHora contrato) {
		contratos.remove(contrato);
	}
	public double renda(int mes, int ano) {
		double total=salario;
		for(ContratoHora contrato: contratos) {
			int c_mes= contrato.getData().getMonthValue();
			int c_ano= contrato.getData().getYear();
			
			if(mes==c_mes && ano==c_ano) {
				total+=contrato.valorTotal();
			}
		}
		return total;
	}

}
