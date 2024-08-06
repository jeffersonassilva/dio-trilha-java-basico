import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        String nome = obterNome(scanner);
        String agencia = obterAgencia(scanner);
        int nrConta = obterNumeroConta(scanner);
        double vlSaldo = obterValorSaldo(scanner);

        exibirMensagemFinal(nome, agencia, nrConta, vlSaldo);

        scanner.close();
    }

    private static String obterNome(Scanner scanner) {
        System.out.println("Por favor, digite o seu nome!");
        return scanner.nextLine();
    }

    private static String obterAgencia(Scanner scanner) {
        System.out.println("Por favor, digite o número da Agência!");
        return scanner.nextLine();
    }

    private static int obterNumeroConta(Scanner scanner) {
        int nrConta = 0;
        System.out.println("Por favor, digite o número da Conta!");
        while (true) {
            String nrContaStr = scanner.nextLine();
            if (nrContaStr.matches("\\d+")) {
                nrConta = Integer.parseInt(nrContaStr);
                break;
            } else {
                System.out.println("Número da conta inválido! Por favor, digite apenas números.");
            }
        }
        return nrConta;
    }

    private static double obterValorSaldo(Scanner scanner) {
        double vlSaldo = 0.0;
        System.out.println("Por favor, digite o valor do Saldo!");
        String msgErroSaldo = "Valor do saldo inválido! Por favor, digite no formato correto (ex: 1234.56).";
        while (true) {
            String vlSaldoStr = scanner.nextLine();
            if (vlSaldoStr.matches("\\d*\\.?\\d+")) {
                try {
                    vlSaldo = Double.parseDouble(vlSaldoStr);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(msgErroSaldo);
                }
            } else {
                System.out.println(msgErroSaldo);
            }
        }
        return vlSaldo;
    }

    private static void exibirMensagemFinal(String nome, String agencia, int nrConta, double vlSaldo) {
        System.out.println("Olá " + nome + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia
                + ", conta " + nrConta + ", e seu saldo " + vlSaldo + " já está disponível para saque.");
    }
}
