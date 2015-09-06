package jan.compiti;

public class Strutture {

	public static void main(String[] args) {

		/**
		 * Le strutture principali di un linguaggio
		 * sono sistemi che permettono di deviare la
		 * direzione di esecuzione del codice
		 * 
		 * La struttura fondamentale e' if
		 */
		
		int x = 0;
		
		if (x == 0) {
			// esegui cio' che c'e scritto qui
			// perche' x = 0
		}
		
		/**
		 * if permette di far eseguire il codice
		 * all'interno della struttura solo se
		 * si verifica la condizione di esecuzione
		 * 
		 * if (<condizione>) {
		 * 
		 * 		...
		 * }
		 * 
		 * Le condizioni sono SEMPRE di tipo boolean percio'
		 * vale inserire ad esempio
		 * 
		 * if (true)
		 * if (false)
		 * if (x == 1) // uguale
		 * if (x > 9) // maggiore
		 * if (3 == 2)
		 * if (x <= 2) // minore-uguale
		 * if (x >= 2) // maggiore-uguale
		 * 
		 * La seconda struttura e' strettamente connessa ad if
		 * perche' senza if non puo' essere esegui
		 * ed e' la struttura else
		 */
		
		if (x == 0) {
			// esegui qui se x = 0
		}
		else {
			// altrimenti esegui qui
		}
		
		/**
		 * if e' l'istruzione se,
		 * else e' l'istruzione altrimenti
		 * 
		 * se la condizione di if non si verifica
		 * viene eseguito il codice all'interno di else
		 * 
		 * if (<condizione>) {
		 * 
		 * 		... se condizione e' vera
		 * }
		 * else {
		 * 		... se condizione e' falsa
		 * }
		 * 
		 * 
		 * Inoltre se si volesse avere piu' condizioni
		 * con piu' codici bisogna integrarli in questo modo
		 * 
		 * if (<condizione1>) {
		 * 		... se condizione1 e' vera
		 * }
		 * else if (<condizione2>) {
		 * 		... se condizione2 e' vera
		 * }
		 * else if (<condizione3>) {
		 * 		... se condizione3 e' vera
		 * }
		 * else {
		 * 		... se nessuna delle condizioni si verifica
		 * }
		 */
		
		x = 1; // assegno il valore 1 a x
		
		if (x == 0) {
			// non viene eseguito
		}
		else if (x == 1) {
			// viene eseguito
		}
		else if (x == -1) {
			// non viene eseguito
		}
		else if (x < 0) {
			// non viene eseguito
		}
		else {
			// non viene eseguito
		}
		
		/**
		 * Nel caso si volesse far in modo di
		 * verificare valori precisi (x == 1) e non intervalli (ad es. x < 0)
		 * e' piu' conveniente usare switch e case (facoltativo!!)
		 */
		
		int indice = 1;
		String giorno;
		
		switch (indice) {
		
			case 1:
				giorno = "Lunedi";
				break;
				
			case 2:
				giorno = "Martedi";
				break;
				
			case 3:
				giorno = "Mercoledi";
				break;
				
			case 4:
				giorno = "Giovedi";
				break;
				
			case 5:
				giorno = "Venerdi";
				break;
				
			case 6:
				giorno = "Sabato";
				break;
				
			case 7:
				giorno = "Domenica";
				break;
				
			default:
				giorno = "Non esiste questo giorno";
				break;
				
		}
		
		// in questo caso giorno sara' "Lunedi" perche indice = 1
		// break serve a far terminare lo switch
		
		/**
		 * Piu' importante invece e' il concetto di ciclo
		 * 
		 * Un ciclo e' una struttura che
		 * ripete il codice al suo interno in continuazione.
		 * Per poter ripetere una linea di codice
		 * pero' deve esserci una condizione di continuita'
		 * Percio' un ciclo ha come struttura sia il codice da ripetere
		 * sia la condizione per continuare a ripetere
		 * Per scrivere un ciclo si usa while
		 */
		
		x = 3;
		
		while (x == 3) {
			// codice da eseguire all'infinito finche' x = 3
		}
		
		// in questo caso il codice si ripete all'infinito
		
		/**
		 * while (<condizione>) {
		 * 		...
		 * }
		 * 
		 * ATTENZIONE!!
		 * Se la condizione e' vera il ciclo continua a ripetersi
		 * Dal momento che la condizione diviene falsa, il ciclo
		 * si interrompe (e non viceversa)
		 * 
		 * Se si volesse ripetere del codice un certo numero di
		 * volte si utilizza un indice che ha come valore iniziale 0
		 * e lo si incrementa di 1 ad ogni fine ciclo
		 * Pero' perche' il ciclo s'interrompa dopo un tot di volte
		 * la condizione del ciclo deve essere vera giusto un tot di volte
		 */
		
		indice = 0;
		int volte = 10;
		
		while (indice < volte) {
			// esegui in continuazione se indice e' minore di volte
			indice++; // incrementa indice di 1
		}
		
		// in questo caso quando indice raggiunge il numero 10 il ciclo s'interrompe
		// perche' indice rimane minore di 10, per 10 volte
		// dopodiche' e' maggiore-uguale
		
		/**
		 * La presenza di un indice in un ciclo e' spesso fondamentale
		 * Infatti esiste addirittura un struttura che ripete come
		 * un ciclo while ma con un indice che esiste solo nel ciclo (e poi viene eliminato)
		 * Il ciclo for
		 * 
		 * for (<inizializza indice>; <condizione>; <cosa succede alla fine>) {
		 * 		...
		 * }
		 * 
		 * Per ripetere qualcosa tot volte non e' dunque necessario un ciclo while
		 */
		
		volte = 10;
		
		for (int i = 0; i < volte; i++) {
			// ... esegui in continuazione se i e' minore di volte
		}
		
		// In pratica e' uguale a prima ma piu' sintetico
		// Ripete il codice all'interno per 10 volte
		
		/**
		 * L'ultimo tipo di ciclo (facoltativo!!)
		 * e' il do while
		 * 
		 * esegue come il ciclo while con la particolarita'
		 * che anche se la condizione e' falsa, il codice all'interno
		 * viene eseguito almeno una volta
		 * 
		 * do {
		 * 		...
		 * } while (<condizione>);
		 */
		
		do {
			// codice di eseguire almeno una volta
		} while (x == 0);
		
		/**
		 * In teoria la condizione di un ciclo e' solo una
		 * Pero' attraverso l'istruzione break si puo' bloccare
		 * un ciclo forzatamente
		 */
		
		x = 0;
		
		while (x < 7) {
			
			if (x == 5) {
				break;
			}
			
			x++;
		}
		
		/**
		 * La condizione del ciclo dice che se x = 7 il ciclo si interrompe
		 * ma una seconda condizione data da un if all'interno dice di
		 * bloccarlo quando x = 5
		 * Dato che break e' un'uscita forzata, quando x = 5 il ciclo s'interrompe
		 * senza curarsi della condizione del ciclo
		 */

	}

}
