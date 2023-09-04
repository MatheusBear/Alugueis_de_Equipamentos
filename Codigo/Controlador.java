import java.util.*;

public class Controlador{
    public static void main(String[] args){
        int idCliente = 0;
        int idEquipamento = 0;

        System.out.println("Digite o Nome do Cliente");
        Scanner scanner = new Scanner(System.in);

        String NomeCliente = scanner.nextLine();

        Cliente cliente = new Cliente(idCliente, NomeCliente);
        idCliente++;

        System.out.println("Registrado como cliente: " + cliente.getNome());

        boolean Continuar = true;

        List<Equipamento> Equipments = new ArrayList<Equipamento>();

        while(Continuar == true){
            System.out.println("Digite uma descricao do equipamento: ");
            String Descricao = scanner.nextLine();

            System.out.println("Digite o Tipo do Equipamento: ");
            String Tipo = scanner.nextLine();

            System.out.println("Digite o Valor diario do Equipamento: ");
            double Valor = scanner.nextInt();

            System.out.println("Digite a Quantidade do Equipamento: ");
            int Quantidade = scanner.nextInt();  

            Equipamento equipamento = new Equipamento(idEquipamento, Descricao, Tipo, Valor, Quantidade);

            Equipments.add(equipamento);

            idEquipamento++;
            
            System.out.println("Deseja registrar mais um equipamento? (S ou N)");
            String desejo = scanner.nextLine();
            desejo = scanner.nextLine();

            if(desejo.contains("N") || desejo.contains("n")) Continuar = false;
        }

        System.out.println("Equipamentos disponiveis: ");

        for(int i = 0; i < Equipments.size(); i++){
            System.out.println("Descricao: " + (Equipments.get(i)).getDescricao() + " Tipo: " + (Equipments.get(i)).getTipo() + " Quntidade: " + (Equipments.get(i)).getQuantidade() + " Valor: " + (Equipments.get(i)).getValor());
        }

        String equipsDesejados = " "; 

        while(equipsDesejados != ""){
            System.out.println("Digite a descricao do objeto desejado");
            equipsDesejados = scanner.nextLine();

            int IDEquipamento = 0;

            //Verificar se equipamento existe
            boolean exists = false;

            while(exists = false){
                for(int i = 0; i < Equipments.size(); i++){
                    if(((Equipments.get(i)).getDescricao()) == equipsDesejados){
                        IDEquipamento = (Equipments.get(i)).getID();
                        exists = true; 
                        break;
                    }
                }
                System.out.println("ERRO! Digite a descricao do objeto desejado novamente");
                equipsDesejados = scanner.nextLine();

            }

            System.out.println("Digite a Quantidade do Equipamento desejado: ");
            int Quantidade = scanner.nextInt(); 
            scanner.nextLine();

            //Verificar se a Quantidade desejado é valida
            boolean Quant = true;

            if(Quantidade > (Equipments.get(IDEquipamento).getID())) {
                Quant = false;
            }

            while(Quant == false){
                System.out.println("Digite um numero valido para a Quantidade do Equipamento desejado: ");
                Quantidade = scanner.nextInt(); 
                scanner.nextLine();
            }



            System.out.println("Deseja adicionar mais um Equipamento? (Deixe vazio, caso queira sair, e aperte enter)");
            equipsDesejados = scanner.nextLine();
        }
        
    }
}