package Projeto1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controlador {
	public static final List<Cliente> clientes = new ArrayList<>();
	public static final List<Equipamento> equipamentos = new ArrayList<>();
	public static final List<Contrato> contratos = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	
	public static DateTimeFormatter formatter() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return formatter;
	}
	

	/**
	 * Cadastra um novo cliente no sistema. Clientes ficam apenas com o nome salvo.
	 * 
	 * @return cliente
	 */
	public static Cliente cadastraCliente() {
		System.out.print("\nDigite o Nome do Cliente: ");

		String nomeCliente = sc.nextLine();
		Cliente cliente = new Cliente(clientes.size() + 1, nomeCliente);
		clientes.add(cliente);

		System.out.println("Registrado como cliente: " + cliente.getNome() + "\n");
		return cliente;
	}

	/**
	 * Cadastra um novo equipamento no sistema, contendo Descrição, Tipo, Valor
	 * Diario e quantidade de equipamentos disponiveis.
	 */
	public static void cadastraEquipamento() {
		System.out.print("\nDigite uma descricao do equipamento: ");
		String descricao = sc.nextLine();

		System.out.print("Digite o Tipo do Equipamento: ");
		String tipo = sc.nextLine();

		System.out.print("Digite o Valor diario do Equipamento: ");
		double valor = sc.nextDouble();

		System.out.print("Digite a quantidade do Equipamento disponivel: ");
		int quantidade = sc.nextInt();

		Equipamento equipamento = new Equipamento(equipamentos.size() + 1, descricao, tipo, valor, quantidade);

		equipamentos.add(equipamento);
	}

	/**
	 * Pergunta usuario se quer continuar registrando equipamentos.
	 * 
	 * @return Boolean desejo
	 */
	public static boolean continuar() {
		System.out.println("\nDeseja registrar mais um equipamento? (S/N)");
		String desejo = sc.nextLine();
		desejo = sc.nextLine().toUpperCase();
		return desejo.contains("S");
	}

	/**
	 * Mostra todos os equipamentos disponiveis, juntamente com seu Id, Descrição,
	 * Tipo e Valor diario
	 */
	public static void verEquipamentosDisponiveis() {
		System.out.println("\nEquipamentos disponiveis: ");

		for (Equipamento equipamento : equipamentos) {
			System.out.println("\nid:" + equipamento.getId() + "\nDescricao: " + equipamento.getDescricao() + "\nTipo: "
					+ equipamento.getTipo() + "\nValor: R$" + String.format("%.2f", equipamento.getValor())
					+ "\nQuantidade Disponivel: " + equipamento.getQuantidadeDisponivel() + "\n");
		}
	}

	public static   Object verificaExistencia() {
		return (clientes.size() == 0 && equipamentos.size() == 0)?naoExiste():cadastraContrato();
	}
	
	public static Object naoExiste() {
		System.out.println("\nAntes de cadastrar um contrato deve-se cadastrar pelo menos um cliente e um Equipamento");
		return null;
	}
	
	/**
	 * Cadastra um contrato no Sistema, contendo
	 * 
	 * @param cliente
	 */
	public static Object cadastraContrato() {
		Cliente cliente = clienteExiste();
		Equipamento equipamento = validaEquipamento();
		int id = 0;
		id++;

		System.out.println("Quantidade disponivel:  " + equipamento.getQuantidadeDisponivel());
		System.out.print("\nQuantidade do equipamento desejado: ");
		int quantidade = sc.nextInt();
		while (!equipamento.validaQuantidaDisponivel(quantidade)) {
			System.out.print("\nNumero de quantidade invalidao, digite novamente: ");
			quantidade = sc.nextInt();
		}
		LocalDate dataInicio = validaDataInicio();
		LocalDate dataFim = validaDataFim(dataInicio);

		String dataInicioFormatada = formatoData(dataInicio);
		String dataFimFormatada = formatoData(dataFim);

		Contrato contrato = new Contrato(id, cliente, equipamento, quantidade, dataFimFormatada, dataInicioFormatada);
		contratos.add(contrato);
		System.out.println("\nContrato criado com sucesso!\n\n" + contrato);
		return false;

	}

	/**
	 * Formata a data recebida para o formato (DD/MM/AAAA)
	 * 
	 * @param data : LocalDate
	 * @return retorna a data formatada
	 */
	public static String formatoData(LocalDate data) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyy");
		return data.format(formato);
	}

	/**
	 * Valida se o equipamento existe.
	 * 
	 * @return
	 */
	public static Equipamento validaEquipamento() {
		System.out.print("\nDigite o id do objeto desejado: ");
		int idEquipamento = sc.nextInt();

		while (idEquipamento < 0 || idEquipamento > equipamentos.size() + 1) {
			System.out.print("\n\tERRO!\nDigite o id do objeto desejado novamente: ");
			idEquipamento = sc.nextInt();
		}
		return equipamentos.get(idEquipamento - 1);
	}

	/**
	 * Verifica se o id fornecido para cadastrar no contrato pertence a um cliente
	 * cadastrado no sistema
	 * 
	 * @return
	 */
	public static Cliente clienteExiste() {
		System.out.print("\nDigite o id do Cliente responsavel: ");
		int clienteId = sc.nextInt();
		for (Cliente cliente : clientes) {
			while (cliente.getId() != clienteId) {
				System.out.print("\n\tCliente Nao encontrado!\n\n");
				System.out.print("\nDigite o id do cliente responsavel novamente: ");
				clienteId = sc.nextInt();
			}
		}
		return clientes.get(clienteId - 1);
	}

	/**
	 * Valida se a data digitada está no formato correto
	 * 
	 * @return
	 */
	public static LocalDate validaDataInicio() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean validDate = false;
		LocalDate dataInicio;
		do {
			System.out.print("Digite a data de inicio do contrato (DD/MM/AAAA):  ");
			if (!sc.hasNextInt()) {
				sc.nextLine();
			}
			String data = sc.nextLine();
			try {
				dataInicio = LocalDate.parse(data, dateFormatter);
			} catch (java.time.format.DateTimeParseException e) {
				System.out.println("Formato de data inválido. Certifique-se de usar (dd/MM/yyyy)");
				validDate = true;
				dataInicio = null;
			}
		} while (validDate);
		return dataInicio;
	}

	/**
	 * Assegura que a data de termino do contrato é valida, além de assegurar que o
	 * contrato não tenha dias negativos
	 * 
	 * @param dataInicio
	 * @return
	 */
	public static LocalDate validaDataFim(LocalDate dataInicio) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean validDate = false;
		LocalDate dataFim = null;
		do {
			System.out.print("Digite a data de termino do contrato (DD/MM/AAAA):  ");

			String data = sc.nextLine();
			try {
				dataFim = LocalDate.parse(data, dateFormatter);
				validDate = (!dataInicio.isBefore(dataFim)) ? true : false;
				if (validDate)
					System.out.println("O contrato nao pode ter dias negativos! ");

			} catch (java.time.format.DateTimeParseException e) {
				System.out.println("Formato de data inválido. Certifique-se de usar (dd/MM/yyyy)");
				validDate = true;
			}
		} while (validDate);
		return dataFim;
	}

	public static void verContratosDoCliente() {
		System.out.println("Digite o Id do cliente: ");
		int id = sc.nextInt();
		double somatoriaContratos = 0.00;
		
		for(Contrato contrato : contratos) {
			 if (contrato.getCliente().getId() == id) {
				 System.out.println("\n" + contrato.toString());
		            String status = (verificaStatusDoContrato(contrato.getDataFim()))?"Ativo":"Finalizado";
		            System.out.println("Status: " + status);
		            somatoriaContratos += contrato.getValorTotal();
		        }
		}
		System.out.println("Montante total: R$" + String.format("%.2f", somatoriaContratos) + "\n");
	}
	
	/**
	 * Verifica se o contrato está ativo, 
	 * recebe uma string com a Data de termino do contrato no formato ("dd/MM/yyyy"), 
	 * e retorna  verdadeiro para contratos ativos e falso para contratos não ativos.
	 * @param data
	 * @return verifyStatus
	 */
	public static boolean verificaStatusDoContrato(String data) {
		 LocalDate dataFinal = LocalDate.parse(data, formatter());
		 boolean verifyStatus = dataFinal.isAfter(LocalDate.now());
		 return verifyStatus;
	}
	
	public static void emiteRelatorioMensal() {
		System.out.println("Digite o mes que deseja emitir o relatorio: ");
		int mesDesejado = sc.nextInt();
		boolean existe = false;
		double somatoriaContratos = 0.00;
		for (Contrato contrato : contratos) {
            String data = contrato.getDataInicio();
            LocalDate dataContrato = LocalDate.parse(data, formatter());
            int mesContrato = dataContrato.getMonthValue();
            if (mesContrato == mesDesejado) {
            	existe=true;
            	System.out.println("\n" + contrato.toString());
	            String status = (verificaStatusDoContrato(contrato.getDataFim()))?"Ativo":"Finalizado";
	            System.out.println("Status: " + status);
	            somatoriaContratos += contrato.getValorTotal();
            }
        }
		String existeRelatorio = (existe)?"Faturamento Mensal: R$" + String.format("%.2f", somatoriaContratos) :"Nao existem contratos no mes";
		System.out.println("\n" + existeRelatorio + "\n");
	}
	
	public static void main(String[] args) {
		int resp;

		do {
			System.out.println("Selecione uma das opcoes abaixo:");
			System.out.println("1-Cadastrar Cliente\n2-Cadastrar Equipamentos");
			System.out.println("3-Ver Equipamentos Disponiveis\n4-Cadastrar Contrato");
			System.out.println("5-Buscar Contratos de um Cliente\n6-Emitir relatorio Mensal");
			System.out.println("0-Para Sair");

			if (!sc.hasNextInt()) {
				sc.nextLine();

			}
			resp = sc.nextInt();
			sc.nextLine();

			switch (resp) {
			case 0:
				System.out.println("Saindo do programa.");
				break;
			case 1:
				cadastraCliente();
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
				verificaExistencia();
				break;
			case 5:
				verContratosDoCliente();
				break;
			case 6:
				emiteRelatorioMensal();
				break;
			default:
				System.out.println("\nOpcao invalida!\n");
			}
		} while (resp != 0);

		sc.close();
	}




}
