/**
 * Pilha dinamica
 * 
 * @author Max do Val Machado
 * @version 2 01/2015
 */
public class Pilha {
	private Celula topo;

	public Pilha() {
		topo = new Celula();
	}

	public void inserir(int x) {
		Celula tmp = new Celula(x);
		tmp.prox = topo.prox;
		topo.prox = tmp;
		tmp = null;
	}

	public int remover() throws Exception {
		if (topo.prox == null) {
			throw new Exception("Erro ao remover!");
		}
		int resp = topo.prox.elemento;
		Celula tmp = topo.prox;
		topo.prox = tmp.prox;
		tmp.prox = null;
		tmp = null;
		return resp;
	}

	public void mostrar() {
		System.out.print("[ ");
		for (Celula i = topo.prox; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] ");
	}

	public int getSoma() {
		return getSoma(topo);
	}

	private int getSoma(Celula i) {
		int resp = 0;
		if (i != null) {
			resp += i.elemento + getSoma(i.prox);
		}
		return resp;
	}

	public int getMax() {
		int max = topo.elemento;
		for (Celula i = topo.prox; i != null; i = i.prox) {
			if (i.elemento > max)
				max = i.elemento;
		}
		return max;
	}

	public void mostraPilha() {
		mostraPilha(topo);
	}

	private void mostraPilha(Celula i) {
		if (i != null) {
			mostraPilha(i.prox);
			System.out.println("" + i.elemento);
		}
	}

}
