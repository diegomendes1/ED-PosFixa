package principal;
import java.util.StringTokenizer;

public class CalculadoraPosFixa{
	private TADPilha pilha;
	
	public CalculadoraPosFixa() {
		this.pilha = new PilhaDinamica();
	}
	
	public int calcularExpressao(String expressao) throws NumberFormatException{
		if(expressao.matches(".*[^0-9 \\+\\-\\*\\/].*")) {
			System.out.println("Expressao Mal-Formada.");
			return -3440; //erro
		}
		
		StringTokenizer s = new StringTokenizer(expressao);
		while(s.hasMoreTokens()) {
			String atual = s.nextToken();
			if(!atual.equals("+") && !atual.equals("-") && !atual.equals("*") && !atual.equals("/")) {
				try {
					pilha.push(Integer.parseInt(atual));
				}catch(NumberFormatException e) {
					System.out.println("Expressao Mal-Formada.");
					return -3440; //erro
				}
			}else {
				if(pilha.getQtdNodes() >= 2) {
					int a = pilha.pop();
					int b = pilha.pop();
					fazerCalculo(a, b, atual);
				}else {
					System.out.println("Expressao Invalida: Mais operadores que operandos.");
					return -3440; //erro
				}
			}
		}
		
		int resultado = pilha.pop();
		if(!pilha.isEmpty()) {
			System.out.println("Expressao Invalida: Mais operandos que operadores.");
			return -3440; //erro
		}
		return resultado;
	}
	
	public void fazerCalculo(int a, int b, String operacao) throws ArithmeticException{
		if(operacao.equals("+")) {
			pilha.push(b + a);
		}else if(operacao.equals("-")) {
			pilha.push(b - a);
		}else if(operacao.equals("*")) {
			pilha.push(b * a);
		}else if(operacao.equals("/")){
			try {
				pilha.push(b / a);
			}catch(ArithmeticException e){
				System.out.println("Expressao Invalida: Tentando dividir por zero?");
				pilha.push(-3440); //erro
			}
			
		}
	}
}