package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.enumeracao.WorkerLevel;
import entities.Departamento;
import entities.HourContract;
import entities.Worker;


public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("INFORME O DEPARTAMENTO: ");
		String nomeDepartamento = sc.nextLine();
		
		System.out.println(" ---- INFORMA��ES DO FUNCION�RIO ---- ");
		System.out.println();
		System.out.print("NOME: ");
		String nomeFuncionario = sc.nextLine();
		System.out.print("N�VEL: ");
		String nivel = sc.nextLine();
		System.out.print("SAL�RIO BASE: ");
		double salarioBase = sc.nextDouble();
		Worker funcionario = new Worker(nomeFuncionario, WorkerLevel.valueOf(nivel), salarioBase, new Departamento(nomeFuncionario));
		
		System.out.print("QUANTOS CONTRATOS TEM O FUNCION�RIO? ");	
		int n = sc.nextInt();
		
		for(int i = 0; i<n; i++) {
			System.out.println("Entre com as informa��es do contrato #" + i);
			System.out.println("DARA DD/MM/YYYY");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("VALOR POR HORA TRABALHADA: ");
			double valorHora = sc.nextDouble();
			System.out.print("DURA��O (horas): ");
			int horas = sc.nextInt();
			HourContract contrato = new HourContract(dataContrato, valorHora, horas);
			funcionario.addContrato(contrato);
		}
		
		System.out.print("Entre com o m�s e ano para que possa ser feito o calculo da renda (MM/YYYY): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("nome: " + funcionario.getNome());
		System.out.println("Departamento: " + funcionario.getDepartamento().getNome());
		System.out.println("Renda para " + mesAno + ": " + String.format("%.2f", funcionario.renda(ano, mes)));
		
		sc.close();
	}

}
