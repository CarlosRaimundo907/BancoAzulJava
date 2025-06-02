import java.util.Locale;
import java.util.Scanner;

public class BancoAzul_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        double saldo = 0;
        String extrato = "";
        int numeroSaques = 0;
        int limiteSaques = 3;
        double limiteValor = 500;

        while(true) {    
            System.out.println("============================");
            System.out.println("Selecione uma opção:=");
            System.out.println("[d] - Depósito");
            System.out.println("[s] - Saque");
            System.out.println("[e] - Extrato");
            System.out.println("[q] - Sair");
            System.out.println("============================");
            System.out.print("Opção");
        
            String menu = scanner.nextLine();

            if (menu.equals("d")) {
                System.out.println("Informe o valor do depósito: R$");
                double valor = scanner.nextDouble();
                scanner.nextLine();
                if (valor > 0) {
                  saldo += valor;
                  extrato += "Depósito de R$ " + valor + " realizado" + "%n";
                  System.out.printf("Depósito de R$ %.2f realizado com sucesso %n", valor);
                }
                else {
                  System.out.println("@@@ Operação falhou! O valor informado é inválido! @@@");
                }
              }
              else if(menu.equals("s")) {
                System.out.println("Informe o valor do saque: R$");
                double valor = scanner.nextDouble();
                scanner.nextLine();
                boolean excedeuSaldo = valor > saldo;
                boolean excedeuLimite = valor > limiteValor;
                boolean excedeuSaque = numeroSaques >= limiteSaques;
                if(excedeuSaldo) {
                  System.out.println("@@@ Operação falhou! Você não tem saldo suficiente! @@@");
                } 
                else if(excedeuSaque) {
                  System.out.println("@@@ Operação falhou! Número máximo de saques excedido! @@@");
                }
                else if(excedeuLimite) {
                  System.out.println("@@@ Operação falhou! O valor do saque excede o limite!  @@@");
                }
                else if(valor > 0) {
                  saldo -= valor;
                  extrato += "Saque de R$ " + valor + " realizado" + "%n";
                  numeroSaques += 1;
                  System.out.printf("Saque de R$ %.2f realizado com sucesso %n", valor);
                } 
                else {
                  System.out.println("@@@ Operação Falhou! O valor informado é inválido! @@@");
                }
              }
              else if((menu.equals("e"))) {
                String mensagem = extrato.isEmpty() ? "Não foram realizadas movimentações" : extrato;
                System.out.println("========== E X T R A T O ==========");
                System.out.println(mensagem);
                System.out.println();
                System.out.printf("SALDO: R$ %.2f %n", saldo);
                System.out.println("=====================================");
              }
              else if((menu.equals("q"))) {
                System.out.println("@@@ Obrigado pela preferência !!! @@@");
                break;
              }
              else {
                System.out.println("@@@ Opção inválida, por favor selecione novamente a operação desejada @@@");
          
              }
            }
            scanner.close();
          }
        }