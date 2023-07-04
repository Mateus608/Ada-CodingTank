import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculoDeSalario {
    public static void main(String[] args) {

        DecimalFormat formatar = new DecimalFormat("0.00");

        Scanner scanner = new Scanner(System.in);

        double[] salariosBrutos = new double[5];
        double[] descontosINSS = new double[5];
        double[] descontosImpostoRenda = new double[5];
        double[] salariosLiquidos = new double[5];


        for (int i = 0; i < 5; i++) {
            System.out.println("Digite o salário bruto do funcionário " + (i + 1) + ": ");
            salariosBrutos[i] = scanner.nextDouble();

            descontosINSS[i] = descontoINSS(salariosBrutos[i]);
            descontosImpostoRenda[i] = descontoImpostoRenda(salariosBrutos[i]);
            salariosLiquidos[i] = salariosBrutos[i] - descontosINSS[i] - descontosImpostoRenda[i];

        }

        /*
         * Salário bruto.
         * Quanto pagou ao INSS.
         * Quanto pagou de Imposto de Renda.
         * Salário líquido.
         */

        System.out.println("\nResultado:");
        for (int i = 0; i < 5; i++) {

            String valorFormatadoSalariosBrutos = formatar.format(salariosBrutos[i]);
            String valorFormatadoDescontoINSS = formatar.format(descontosINSS[i]);
            String valorFormatadoImpostoRenda = formatar.format(descontosImpostoRenda[i]);
            String valorFormatadoSalariosLiquidos = formatar.format(salariosLiquidos[i]);


            System.out.println("Funcionário " + (i + 1));
            System.out.println("Salário bruto: R$" + valorFormatadoSalariosBrutos);
            System.out.println("Desconto INSS: R$" + valorFormatadoDescontoINSS);
            System.out.println("Desconto Imposto de Renda: R$" + valorFormatadoImpostoRenda);
            System.out.println("Salário líquido: R$" + valorFormatadoSalariosLiquidos);
            System.out.println();
        }

        scanner.close();
    }

    public static double descontoINSS(double salarioBruto) {

        // % Desconto INSS

        if (salarioBruto <= 1212.00) {
            return salarioBruto * 0.075; // Desconto 7,5%
        } else if (salarioBruto <= 2427.35) {
            return salarioBruto * 0.09; // Desconto 9%
        } else if (salarioBruto <= 3641.03) {
            return salarioBruto * 0.12; // Desconto 12%
        } else {
            return salarioBruto * 0.14; // Desconto 14%
        }
    }

    public static double descontoImpostoRenda(double salarioBruto) {

        // % Desconto Imposto de Renda

        if (salarioBruto <= 1903.98) {
            return 0; // Desconto 0%
        } else if (salarioBruto <= 2826.65) {
            return salarioBruto * 0.075; // Desconto 7,5%
        } else if (salarioBruto <= 3751.05) {
            return salarioBruto * 0.15; // Desconto 15%
        } else if (salarioBruto <= 4664.68) {
            return salarioBruto * 0.225; // Desconto 22,5%
        } else {
            return salarioBruto * 0.275; // Desconto 27,5%
        }
    }
}
