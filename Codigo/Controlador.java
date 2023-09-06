import java.time.LocalDate;
import java.util.*;

public class Controlador {
  private static final List<Cliente> clientes = new ArrayList<>();
  private static final List<Equipamento> equipamentos = new ArrayList<>();

  private static Cliente cadastraCliente(Scanner scanner) {
    System.out.println("Digite o Nome do Cliente");

    String nomeCliente = scanner.nextLine();
    Cliente cliente = new Cliente(clientes.size(), nomeCliente);
    clientes.add(cliente);

    System.out.println("Registrado como cliente: " + cliente.getNome());
    return cliente;
  }

  private static void cadastraEquipamento(Scanner scanner) {
    System.out.println("Digite uma descricao do equipamento: ");
    String descricao = scanner.nextLine();

    System.out.println("Digite o Tipo do Equipamento: ");
    String tipo = scanner.nextLine();

    System.out.println("Digite o Valor diario do Equipamento: ");
    double valor = scanner.nextInt();

    Equipamento equipamento = new Equipamento(equipamentos.size(), descricao, tipo, valor);

    equipamentos.add(equipamento);
  }

  private static Equipamento validaEquipamento(Scanner scanner) {
    System.out.println("Digite o id do objeto desejado:");
    int idEquipamento = scanner.nextInt();

    while (idEquipamento < 0 || idEquipamento > equipamentos.size()) {
      System.out.println("ERRO! Digite o id do objeto desejado novamente");
      idEquipamento = scanner.nextInt();
    }
    return equipamentos.get(idEquipamento);
  }

  private static Contrato cadastraContrato(Scanner scanner, Cliente cliente) {
    Equipamento equipamento = validaEquipamento(scanner);
    System.out.println("Digite um numero para a quantidade do equipamento desejado: ");
    int quantidade = scanner.nextInt();
    System.out.println("Digite o numero de dias para o contrato: ");
    int numeroDias = scanner.nextInt();
    return new Contrato(cliente, equipamento, quantidade, LocalDate.now().plusDays(numeroDias));
  }

  private static boolean continuar(Scanner scanner) {
    System.out.println("Deseja registrar mais um equipamento? (S ou N)");
    String desejo = scanner.nextLine();
    desejo = scanner.nextLine();
    return !desejo.contains("N") && !desejo.contains("n");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Cliente cliente = cadastraCliente(scanner);
    boolean continuar = true;

    while (continuar) {
      cadastraEquipamento(scanner);

      continuar = continuar(scanner);
    }

    System.out.println("Equipamentos disponiveis: ");

    for (Equipamento equipamento : equipamentos) {
      System.out.println(
          "id:"
              + equipamento.getId()
              + "Descricao: "
              + equipamento.getDescricao()
              + " Tipo: "
              + equipamento.getTipo()
              + " Valor: "
              + equipamento.getValor());
    }

    Contrato contrato = cadastraContrato(scanner, cliente);
    System.out.println("Contrato criado com sucesso: " + contrato);
    scanner.close();
  }
}
