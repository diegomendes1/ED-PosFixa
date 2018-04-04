import java.util.StringTokenizer;

public class CalculadoraPosFixa{
	private TADPilha pilha;
	
	
	public CalculadoraPosFixa() {
		this.pilha = new PilhaDinamica();
	}
	
	public int calcularExpressao(String expressao) {
		
		if(expressao.matches(".*[^0-9 \\+\\-\\*\\/\\%].*")) {
			System.out.println("Expressao Mal-Formada.");
			return -3440;
		}
		
		StringTokenizer s = new StringTokenizer(expressao);
		
		while(s.hasMoreTokens()) {
			String atual = s.nextToken();
			
			if(!atual.equals("+") && !atual.equals("-") && !atual.equals("*") && !atual.equals("/")) {
				pilha.push(Integer.parseInt(atual));
			}else {
				if(pilha.getQtdNodes() >= 2) {
					int a = pilha.pop();
					int b = pilha.pop();
					fazerCalculo(a, b, atual);
				}else {
					System.out.println("Expressao Invalida: Mais operadores que operandos.");
					return -3440;
				}
			}
		}
		
		int resultado = pilha.pop();
		
		if(!pilha.isEmpty()) {
			System.out.println("Expressao Invalida: Mais operandos que operadores.");
			return -3440;
		}
		return resultado;
	}
	
	public void fazerCalculo(int a, int b, String operacao) {
		if(operacao.equals("+")) {
			pilha.push(a + b);
		}else if(operacao.equals("-")) {
			pilha.push(a - b);
		}else if(operacao.equals("*")) {
			pilha.push(a * b);
		}else if(operacao.equals("/")){
			pilha.push(a / b);
		}
	}
}