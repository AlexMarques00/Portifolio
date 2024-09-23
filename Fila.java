public class Fila {
	private Celula primeiro;
	private Celula ultimo;

	public Fila() {
		primeiro = null;
	}

	public void inserir(int x) {
		if(primeiro == null){
			primeiro = new Celula(x);
			ultimo = primeiro;
		} else {
			ultimo.prox = new Celula(x);
			ultimo = ultimo.prox;
		}
	}

	public int remover() throws Exception {
		if (primeiro == null) {
			throw new Exception("Erro ao remover!");
		}
		Celula tmp = primeiro;
		primeiro = tmp.prox;
		int resp = tmp.elemento;
		tmp.prox = null;
		tmp = null;
		return resp;
	}

	public void mostrar() {
		System.out.print("[ ");

		for (Celula i = primeiro; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}

		System.out.println("] ");
	}
}
