package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoHora;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		System.out.print("Entre com o nome do departamento: ");
		String nomeDepartamento=sc.nextLine();
		System.out.println("Entre com os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nomeTrabalhador= sc.nextLine();
		System.out.print("Nível: ");
		String nivel=sc.nextLine();
		System.out.print("Salário base: ");
		double salario=sc.nextDouble();
		
		Trabalhador trabalhador= new Trabalhador(nomeTrabalhador,NivelTrabalhador.valueOf(nivel.toUpperCase()),salario,new Departamento(nomeDepartamento));
		System.out.print("Quantos contratos terá o trabalhador: ");
		int n=sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			System.out.printf("Contrato #%d: %n", i);
			System.out.print("Data: ");
			LocalDate data= LocalDate.parse(sc.next(),formato);
			System.out.print("Valor da hora: ");
			double valorHora=sc.nextDouble();
			System.out.print("Horas trabalhadas: ");
			int horas=sc.nextInt();
			ContratoHora contrato= new ContratoHora(data,valorHora,horas);
			trabalhador.adicionarContratos(contrato);
		}
		System.out.println();
		System.out.print("Entre com o mês e o ano para calcular a renda do período em questão(MM/yyyy): " );
		sc.nextLine();
		String mesEAno= sc.nextLine();
		int mes= Integer.parseInt(mesEAno.substring(0,2));
		int ano= Integer.parseInt(mesEAno.substring(3));
		
		System.out.println("Nome: "+trabalhador.getNome());
		System.out.println("Departamento: "+trabalhador.getDepartamento().getNome());
		System.out.printf("Renda do %s: $ %.2f%n",mesEAno, trabalhador.renda(mes, ano));
		
		
		
		
		
		
		sc.close();

	}

}
