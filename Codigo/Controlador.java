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
		System.out.println("Digite o Nome do Cliente");

		String nomeCliente = sc.nextLine();
		Cliente cliente = new Cliente(clientes.size(), nomeCliente);
		clientes.add(cliente);

		System.out.println("Registrado como cliente: " + cliente.getNome());
		return cliente;
	}


	/**
	 * Cadastra um novo equipamento no sistema,
	 * contendo Descrição, Tipo, Valor Diario e quantidade de equipamentos disponiveis.
	 */
	private static void cadastraEquipamento() {
		System.out.println("Digite uma descricao do equipamento: ");
		String descricao = sc.nextLine();

		System.out.println("Digite o Tipo do Equipamento: ");
		String tipo = sc.nextLine();

		System.out.println("Digite o Valor diario do Equipamento: ");
		double valor = sc.nextDouble();

		System.out.println("Digite a quantidade do Equipamento disponivel: ");
		int quantidade = sc.nextInt();

		Equipamento equipamento = new Equipamento(equipamentos.size(), descricao, tipo, valor, quantidade);

		equipamentos.add(equipamento);
	}
	
	
	/**
	 * Pergunta usuario quer continuar registrando equipamentos.
	 * @return Boolean desejo
	 */
	private static boolean continuar() {
		System.out.println("Deseja registrar mais um equipamento? (S ou N)");
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
					+ equipamento.getTipo() + "\nValor: " + equipamento.getValor());
		}
	}
	
	
	/**
	 * Cadastra um contrato no Sistema, contendo 
	 * @param cliente
	 * @return
	 */
	private static Contrato cadastraContrato(Cliente cliente) {
		Equipamento equipamento = validaEquipamento();
		System.out.println("Quantidade disponivel:  " + equipamento.getQuantidadeDisponivel()
				+ "\nQuantidade do equipamento desejado:");
		int quantidade = sc.nextInt();
		while (quantidade < 0 || quantidade > equipamento.getQuantidadeDisponivel()) {
			System.out.println("Numero de quantidade invalidao, digite novamente: ");
			quantidade = sc.nextInt();
		}
		System.out.println("Digite o numero de dias para o contrato: ");
		int numeroDias = sc.nextInt();
		return new Contrato(cliente, equipamento, quantidade, LocalDate.now().plusDays(numeroDias));
	}
	
	
	/**
	 * Valida se o equipamento existe.
	 * @return
	 */
	private static Equipamento validaEquipamento() {
		System.out.println("Digite o id do objeto desejado:");
		int idEquipamento = sc.nextInt();

		while (idEquipamento < 0 || idEquipamento > equipamentos.size()) {
			System.out.println("ERRO! Digite o id do objeto desejado novamente");
			idEquipamento = sc.nextInt();
		}
		return equipamentos.get(idEquipamento);
	}


	public static void main(String[] args) {
		int resp;
		Cliente cliente = null;

		do {
			System.out.println("\nSelecione uma das opcoes abaixo:");
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
				System.out.println("Contrato criado com sucesso: " + contrato);
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
