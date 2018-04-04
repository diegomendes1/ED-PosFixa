package principal;
public class PilhaDinamica implements TADPilha {

	private NoLista topo;
	private int qtdNodes = 0;
	
	public void push(int x) {
		NoLista novo = new NoLista(x);
		novo.setProximo(topo);
		topo = novo;
		qtdNodes++;
	}

	public int pop() {
		int r = -1;
		if (!isEmpty()) {
			r = topo.getValor();
			topo = topo.getProximo();
		}
		qtdNodes--;
		return r;
	}

	public int top() {
		int r = -1;
		if (!isEmpty()) {
			r = topo.getValor();
		}
		return r;
	}

	public boolean isEmpty() {
		return (topo == null);
	}
	
	public int getQtdNodes() {
		return this.qtdNodes;
	}

}
