package teo.compiti;

public class Compito2 {
	
	/**
	 * Inizializza un array
	 * di numeri interi di 1000 slot
	 * e compilalo con i risultati di
	 * questa funzione matematica
	 * 
	 * y = 3 * x + 5 (consiglio: in un ciclo for la i prende il posto della x)
	 * 
	 * Dopodiche definisci un metodo che verifica
	 * se un numero è pari o dispari
	 * ritorna 0 se è pari
	 * ritorna 1 se è dispari
	 * (consiglio: l'operazione matematica resto della divisione è %)
	 * (consiglio: utilizza il resto della divisione per 2 per verificare)
	 * 
	 * Applica poi il metodo a tutti i numeri dell'array
	 * contando quanti sono i numeri pari
	 * (consiglio: inizializza una nuova variabile intera contatore)
	 * 
	 * Infine stampa sulla console quanti sono
	 */

	public static void main(String[] args) {
		
		int lunghezza = 1000;
		int[] lista = new int[lunghezza];
		
		for (int i = 0; i < lunghezza; i++) {
			lista[i] = 3 * i + 5;
		}
		
		Compito2 ciao = new Compito2();
		
		int contatore = 0;
		
		for (int i = 0; i < lunghezza; i++) {
			if (ciao.verifica(lista[i]) == 1) {
				contatore++;
			}
		}
		
		System.out.println(contatore);
	}
		
	public int verifica(int x) {
		
		int risultato = x % 2;
		return risultato;
	}

}
