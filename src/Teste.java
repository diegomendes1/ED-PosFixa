import java.util.Scanner;
import java.util.StringTokenizer;

public class Teste {
	public static void main(String[] args) {
		CalculadoraPosFixa calc = new CalculadoraPosFixa();
		
		System.out.print("Digite a expressao: ");
		Scanner scan = new Scanner(System.in);
		String texto = scan.nextLine();
		
		int resultado = calc.calcularExpressao(texto);
		System.out.println("Resultado: " + resultado);
	}
}
