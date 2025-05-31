import java.util.Scanner;

public class BancoAzul {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int deposito = 0;
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
                
                if(valor > 0 ) {
                    saldo += valor;
                    extrato += String.format("Depósito de R$ %.2f\n", valor);                   System.out.printf("Depósito de R$ %.2f realizado com sucesso %n", valor);

                } else {
                    System.out.println("Operação falhou! O valor informado é inválido!");

                }

            }
            else if (menu.equals("s")) {
                System.out.println("Informe o valor do saque: R$");
                double valor = scanner.nextDouble();
                scanner.nextLine();
                if (valor <= 0) {
                    System.out.println("Operação falhou! O valor informado é inválido!");
                } else if (valor > saldo) {
                    System.out.println("Operação falhou! Você não tem saldo suficiente!");
                } else if (numeroSaques >= limiteSaques) {
                    System.out.println("Operação falhou! Número máximo de saques excedido!");
                } else if (valor > limiteValor) {
                    System.out.println("Operação falhou! O valor do saque excede o limite!");
                } else {
                    saldo -= valor;
                    extrato += String.format("Saque de R$ %.2f\n", valor);
                    numeroSaques++;
                    System.out.printf("Saque de R$ %.2f realizado com sucesso\n", valor);
                }

            } else if (menu.equals("e")) {
                String mensagem = extrato.isEmpty() ? "Não foram realizadas movimentações." : extrato;
                System.out.printf("======== EXTRATO ============\n%sSaldo: R$ %.2f\n=============================\n", mensagem, saldo);

            } else if (menu.equals("q")) {
                System.out.println("Obrigado pela preferência!!!");
                break;

            } else {
                System.out.println("Opção inválida, por favor selecione uma opção válida");
            }
        }
        scanner.close();
    }
}
  
// Depósito:
// - Deve aceitar apenas valores **positivos**.
// - Todos os depósitos devem ser **armazenados** em memória.
// - O sistema considera apenas **um único usuário** (sem necessidade de autenticação ou identificação de conta).
// - Os depósitos devem aparecer no extrato.

// Saque:
//  - Permitir **no máximo 3 saques diários**.
// Cada saque pode ter o valor **máximo de R$ 500,00**.
// O sistema deve bloquear saques se o usuário não tiver saldo suficiente, exibindo mensagem:

// `Saldo insuficiente para saque.`

// Os saques devem ser armazenados e aparecer no extrato.

// Extrato:
// - Listar todas as **movimentações** (depósitos e saques) feitas.
// - No final da listagem, mostrar o **saldo atual**.
// - Formatar os valores no padrão brasileiro:

// Ex: `R$ 1500.45`

// - Se não houver movimentações, mostrar: `Não foram realizadas movimentações.`

