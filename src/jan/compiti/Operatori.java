package jan.compiti;

public class Operatori {

	public static void main(String[] args) {
		
		/**
		 * Ogni linguaggio di programmazione
		 * e' in grado operare con i numeri in modo matematico
		 * con degli operatori specifici
		 * 
		 * Gli operatori aritmetici
		 * sono la somma, la sottrazione, la moltiplicazione, la divisione, e il modulo (o resto della divisione)
		 */
		
		int a = 4 + 13; // somma
		int b = 15 - 8; // sottrazione
		int c = 9 * 5; // moltiplicazione
		int d = 21 / 7; // divisione		
		int e = 45 % 8; // modulo, equivalente a scrivere 45 mod 8
		
		/**
		 * Gli operatori aritmetici possono essere abbreviati
		 * nel caso si voglia ridefinire una variabile gia' esistente partendo
		 * da quella vecchia
		 */
		
		a = a + 3;
		// oppure analogamente
		a += 3; // ad a aggiungi 3
		
		// Cio' funziona con tutti le operazioni
		
		b -= 2; // a b sottrai 2
		c *= 4; // moltiplica c per 4
		d /= 3; // dividi d per 3
		e %= 2; // applica mod 2 a e
		
		/**
		 * Tuttavia non esistono operatori aritmetici
		 * 
		 * Gli operatori di confronto ad esempio servono a
		 * confrontare due variabili e solitamente ritornano
		 * una variabile boolean (true o false)
		 * 
		 * Questi sono maggiore, minore, uguale, maggiore-uguale, minore-uguale, diverso
		 */
		
		boolean f = 5 > 6; // true se maggiore
		boolean g = 5 < 6; // true se minore
		boolean h = 2 == 4; // true se uguale
		boolean i = 2 >= 4; // true se maggiore-uguale
		boolean j = 3 <= -5; // true se minore-uguale
		boolean k = 1 != 10; // true se diverso
		
		/** Attenzione non funziona con valori boolean!!!!
		 * 
		 * boolean l = true == true; NON ESISTE!!
		 */
		
		/**
		 * Gli operatori di confronto non sono pero' gli
		 * unici a ritornare espressioni boolean
		 * 
		 * Gli operatori logici operano solo con espressioni
		 * boolean
		 * 
		 * Questi sono and, or, not
		 */
		
		boolean l = true && false; // true se entrambe le parti sono true
		boolean m = false || true; // true se almeno una delle due parti e' true
		boolean n = !false; // inverte true e false
		
		/**
		 * Altri esempi
		 */
		
		int o = 45 + 9 * 10; // ritorna 135
		
		o -= 5; // ritorna 130
		
		int p = 31 % 2; // ritorna 1
		
		boolean q = p == 1; // ritorna true
		
		boolean r = p < 0; // ritorna false
		
		boolean s = q || r; // ritorna true perche' q = true e r = false
	}

}
