import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Por favor, digite o seu nome!");
        String nome = scanner.nextLine();

        System.out.println("Por favor, digite o número da Agência!");
        String agencia = scanner.nextLine();

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

        System.out.println("Olá " + nome + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia
                + ", conta " + nrConta + ", e seu saldo " + vlSaldo + " já está disponível para saque.");

        scanner.close();
    }
}
