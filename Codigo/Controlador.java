package Projeto1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controlador {
	private static final List<Cliente> clientes = new ArrayList<>();
	private static final List<Equipamento> equipamentos = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	
	/**
	 * Cadastra um novo cliente no sistema.
	 * Clientes ficam apenas com o nome salvo.
	 * @return cliente
	 */
	private static Cliente cadastraCliente() {
		System.out.print("\nDigite o Nome do Cliente: ");

		String nomeCliente = sc.nextLine();
		Cliente cliente = new Cliente(clientes.size()+1, nomeCliente);
		clientes.add(cliente);

		System.out.println("Registrado como cliente: " + cliente.getNome() + "\n");
		return cliente;
	}


	/**
	 * Cadastra um novo equipamento no sistema,
	 * contendo Descrição, Tipo, Valor Diario e quantidade de equipamentos disponiveis.
	 */
	private static void cadastraEquipamento() {
		System.out.print("\nDigite uma descricao do equipamento: ");
		String descricao = sc.nextLine();

		System.out.print("Digite o Tipo do Equipamento: ");
		String tipo = sc.nextLine();

		System.out.print("Digite o Valor diario do Equipamento: ");
		double valor = sc.nextDouble();

		System.out.print("Digite a quantidade do Equipamento disponivel: ");
		int quantidade = sc.nextInt();

		Equipamento equipamento = new Equipamento(equipamentos.size(), descricao, tipo, valor, quantidade);

		equipamentos.add(equipamento);
	}
	
	
	/**
	 * Pergunta usuario se quer continuar registrando equipamentos.
	 * @return Boolean desejo
	 */
	private static boolean continuar() {
		System.out.println("\nDeseja registrar mais um equipamento? (S/N)");
		String desejo = sc.nextLine();
		desejo = sc.nextLine().toUpperCase();
		return desejo.contains("S");
	}
	
	
	/**
	 * Mostra todos os equipamentos disponiveis, juntamente com seu Id, Descrição, Tipo e Valor diario
	 */
	private static void verEquipamentosDisponiveis() {
		System.out.println("\nEquipamentos disponiveis: ");
	
		for (Equipamento equipamento : equipamentos) {
			System.out.println("\nid:" + equipamento.getId() + "\nDescricao: " + equipamento.getDescricao() + "\nTipo: "
					+ equipamento.getTipo() + "\nValor: R$" + String.format("%.2f", equipamento.getValor()) 
					+ "\nQuantidade Disponivel: " + equipamento.getQuantidadeDisponivel() + "\n");
		}
	}
	
	
	/**
	 * Cadastra um contrato no Sistema, contendo 
	 * @param cliente
	 * @return
	 */
	private static Contrato cadastraContrato(Cliente cliente) {
		Equipamento equipamento = validaEquipamento();
		System.out.print("Quantidade disponivel:  " + equipamento.getQuantidadeDisponivel()
				+ "\nQuantidade do equipamento desejado: ");
		int quantidade = sc.nextInt();
		while (quantidade < 0 || quantidade > equipamento.getQuantidadeDisponivel()) {
			System.out.print("\nNumero de quantidade invalidao, digite novamente: ");
			quantidade = sc.nextInt();
		}
		equipamento.setQuantidadeDisponivel(quantidade);
		System.out.print("Digite o numero de dias para o contrato: ");
		int numeroDias = sc.nextInt();
		int id = 0;
		id++;
		return new Contrato(id, cliente, equipamento, quantidade, LocalDate.now().plusDays(numeroDias));
		
	}
	
	
	/**
	 * Valida se o equipamento existe.
	 * @return
	 */
	private static Equipamento validaEquipamento() {
		System.out.print("\nDigite o id do objeto desejado: ");
		int idEquipamento = sc.nextInt();
		
		while (idEquipamento < 0 || idEquipamento > equipamentos.size()) {
			System.out.print("\n\tERRO!\nDigite o id do objeto desejado novamente: ");
			idEquipamento = sc.nextInt();
		}
		return equipamentos.get(idEquipamento);
	}


	public static void main(String[] args) {
		int resp;
		Cliente cliente = null;

		do {
			System.out.println("Selecione uma das opcoes abaixo:");
			System.out.println("1-Cadastrar Cliente\n2-Cadastrar Equipamentos");
			System.out.println("3-Ver Equipamentos Disponiveis\n4-Cadastrar Contrato");
			System.out.println("0-Para Sair");

			if (!sc.hasNextInt()) {
				sc.nextLine();

			}
			resp = sc.nextInt();
			sc.nextLine();

			switch (resp) {
			case 1:
				cliente = cadastraCliente();
				break;
			case 2:
				cadastraEquipamento();
				while (continuar()) {
					cadastraEquipamento();
				}
				break;
			case 3:
				verEquipamentosDisponiveis();
				break;
			case 4:
				Contrato contrato = cadastraContrato(cliente);
				System.out.println("\nContrato criado com sucesso!\n\n" + contrato);
				break;
			case 0:
				System.out.println("Saindo do programa.");
				break;
			default:
				System.out.println("\nOpcao invalida!\n");
			}
		} while (resp != 0);

		sc.close(); 
	}
}
