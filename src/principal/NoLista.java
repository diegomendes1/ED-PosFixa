package principal;

public class NoLista {
	private int valor;
	private NoLista proximo;
	
	public NoLista(int v) {
		setValor(v);
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public NoLista getProximo() {
		return proximo;
	}
	public void setProximo(NoLista proximo) {
		this.proximo = proximo;
	}
}
