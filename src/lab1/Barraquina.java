package lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Barraquina {

	private Scanner dados;
	private ArrayList<Venda> listaVenda;
	private int contVendidos= 0;
	private int contCoca = 0;
	private int contDelRio = 0;
	private int contSuco = 0;
	private int contSalsicha = 0;
	private int contLinguica = 0;
	private int contFrango = 0;
	private int contBacon = 0;

	public Barraquina() {
		System.out.println("Bem vindo a barrainha de t�cnicas!\n\n");
		dados = new Scanner(System.in);
		listaVenda = new ArrayList<Venda>();
		menuOperacoes();
	}

	private void menuOperacoes() {

		int op = 0;
		Aluno comprador = null;
		CachorroQuente cachorroQuenteEscolhido;
		Venda venda= null;
		do {
			op = itensDoMenu();
			switch (op) {
			case 1:
				comprador = registrarAluno();
				venda = new Venda(comprador);
				break;
			case 2:
				String tipoQueijo = escolherTipoQueijo();
				String tipoBebida = escolherTipoBebida();
				cachorroQuenteEscolhido = escolherCachorroQuente(tipoQueijo, tipoBebida);
				
				venda.realizarVenda(cachorroQuenteEscolhido);
				
				listaVenda.add(venda);
				break;
			case 3:
				exibirCompra();
				System.out.println("Quantidade de cachorros quentes vendidos:" + contVendidos);
				System.out.println("Bebida mais vendida: " + getTipoSucoMaisVendido());
				System.out.println("Cachorro quente mais vendido: " + getTipoCachorroMaisVendido());
				System.out.println("Valor total arrecadado: " + "R$ " + valorTotal());
				System.out.println();
			default:
				break;
			}

		} while (op != -1);
		System.out.println("Bye!");

	}

	private int itensDoMenu() {
		System.out.println("Escolha uma op��o para registra a venda ou digite -1 para sair!");
		System.out.println("1: informar os dados do aluno comprador");
		System.out.println("2: Escolher cachorro quente");
		System.out.println("3: Mostrar compras");
		return dados.nextInt();
	}

	private String escolherTipoQueijo() {
		System.out.println("Escolha a opcao de queijo: [1 - Mussarela, 2 - Prato, 3 - Parmesao , 4- Coalho]");
		int queijo = dados.nextInt();
		String tipoQueijo = null;

		switch (queijo) {
		case 1:
			tipoQueijo = "Mussarela";
			break;
		case 2:
			tipoQueijo = "Prato";
			break;
		case 3:
			tipoQueijo = "Parmesao";
			break;
		case 4:
			tipoQueijo = "Coalho";
			break;
		default:
			break;
		}
		return tipoQueijo;
	}

	private CachorroQuente escolherCachorroQuente(String tipoQueijo, String tipoBebida) {
		System.out.println("\n Escolha a opcaode cachorro quente: [1 - Salsicha, 2 - Linguica, 3 - Frango, 4- Bacon]");
		int tipo = dados.nextInt();
		CachorroQuente c = null;
		contVendidos++;
		switch (tipo) {
		case 1:
			c = new Salsicha(tipoQueijo, tipoBebida);
			contSalsicha++;
			break;
		case 2:
			c = new Linguica(tipoQueijo, tipoBebida);
			contLinguica++;
			break;
		case 3:
			c = new Frango(tipoQueijo, tipoBebida);
			contFrango++;
			break;
		case 4:
			c = new Bacon(tipoQueijo, tipoBebida);
			contBacon++;
			break;

		default:
			break;
		}
		return c;
	}
	
	private String escolherTipoBebida() {
		System.out.println("Escolha a opcao de bebida: [1 - Coca-Cola, 2 - Del Rio, 3 - Suco do Chaves]");
		int bebida = dados.nextInt();
		String tipoBebida = null;

		switch (bebida) {
		case 1:
			tipoBebida = "Coca-Cola";
			contCoca++;
			break;
		case 2:
			tipoBebida = "Del Rio";
			contDelRio++;
			break;
		case 3:
			tipoBebida = "Suco do Chaves";
			contSuco++;
			break;
		default:
			break;
		}
		return tipoBebida;
	}
	
	private String getTipoSucoMaisVendido() {
	    String tipoSucoMaisVendido = "Coca-Cola";
	    int maxContagem = contCoca;

	    if (contDelRio > maxContagem) {
	        maxContagem = contDelRio;
	        tipoSucoMaisVendido = "Del Rio";
	    }

	    if (contSuco > maxContagem) {
	        maxContagem = contSuco;
	        tipoSucoMaisVendido = "Suco do Chaves";
	    }

	    return tipoSucoMaisVendido;
	}
	
	private String getTipoCachorroMaisVendido() {
	    String tipoCachorroMaisVendido = "Salsicha";
	    int maxContagem = contSalsicha;

	    if (contLinguica > maxContagem) {
	        maxContagem = contLinguica;
	        tipoCachorroMaisVendido = "Linguica";
	    }

	    if (contFrango > maxContagem) {
	        maxContagem = contFrango;
	        tipoCachorroMaisVendido = "Frango";
	    }
	    
	    if (contBacon > maxContagem) {
	        maxContagem = contBacon;
	        tipoCachorroMaisVendido = "Bacon";
	    }

	    return tipoCachorroMaisVendido;
	}
	
	private double valorTotal() {
		double valor = (contSalsicha * 2.0) + (contLinguica * 3.0) + (contFrango * 2.5) + (contBacon * 3.5);
		return valor;	
	}
	
	private void exibirCompra() {
		for (Venda venda : listaVenda) {

			System.out.println("nome: " + venda.getAluno().getNome());
			System.out.println("matricula: " + venda.getAluno().getMatricula());
			venda.dadosCachorroQuente();

			}	
	}

	private Aluno registrarAluno() {
		System.out.print("\n Nome: ");
		String nome = dados.next();
		System.out.print("\n matricula:");
		int matricula = dados.nextInt();
		return new Aluno(nome, matricula);
	}
}
