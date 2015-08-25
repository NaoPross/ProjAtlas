package jan.compiti;

public class Tipi_di_variabili {

	public static void main(String[] args) {
		
		/**
		 * In java sono supportati diversi tipi
		 * di variabili
		 * 
		 * I tipi primitivi ne costituiscono le base
		 * matematica di java
		 * 
		 * Il primo tra questi e' il byte
		 * che comprende numeri interi da -128 a 127
		 */
		
		byte esempio1 = 100; // Occupa 8 bit in memoria RAM
		
		/**
		 * Il secondo e' lo short che comprende
		 * numeri interi da -32768 a 32767
		 */
		
		short esempio2 = 20000; // Occupa 16 bit in memoria RAM
		
		/**
		 * Il terzo e' l'Integer (int) che comprende
		 * numeri interi da  -2^32  a  2^32 - 1
		 */
		
		int esempio3 = 25000000; // Occupa 32 bit in memoria RAM
		
		/**
		 * Il quarto e' il long ed e' molto pesante ma occupa
		 * un range di valori interi da  -2^64  a  2^64 - 1
		 *(il numero viene specificato long aggiungendo L alla fine)
		 */
		
		long esempio4 = 70000000000L; // Occupa 64 bit in memoria RAM (molto pesante)
		
		/**
		 * Per ora si sono visti solo numeri interi
		 * Il computer pero' e' in grado di processare anche
		 * numeri con la virgola attraverso
		 * il tipo float che ha un range
		 * di valori da -10^38 a 10^38 con 7 cifre
		 * di precisione dopo la virgola
		 * (alla fine del numero va aggiunto f)
		 */
		
		float esempio5 = 43.764f; // Occupa 32 bit in memoria RAM
		float esempio6 = 5.875E-11f; // E-10f sta per calcolo scientifico || 5.875 * 10^(-11)
		
		/**
		 * Il secondo tipo di variabile con la virgola
		 * e' il double che come il long e' molto pesante
		 * ma ha un range di valori da -10^308 a 10^308 - 1
		 * con 15 cifre di precisione dopo la virgola
		 * (alla fine del numero va aggiunto d)
		 */
		
		double esempio7 = 6356.241d; // Occupa 64 bit in memoria RAM
		double esempio8 = 2.973648028001d;
		double esempio9 = 3.89E123d; // E123 sta per calcolo scientifico 3.89 * 10^123
		
		/**
		 * I tipi numeri sono quasi finiti
		 * Perche' ce n'e uno ibrido che e'il char
		 * che elabora i caratteri
		 * della tastiera in codice
		 * numerico Unicode (o ASCII) da 16 bit
		 * 
		 * Per piu' info
		 * https://support.office.com/it-it/article/Tabella-di-caratteri-ASCII-d13f58d3-7bcb-44a7-a4d5-972ee12e50e0
		 */
		
		char esempio10 = 97; // Il 97 vale il carattere "a"
		char esempio11 = 122; // Il 122 vale il carattere "z"
		
		/**
		 * Come si potrebbe intuire
		 * Il tipo String non e' altro che
		 * un array di char
		 */
		
		char[] esempio12 = new char[4];
		
		esempio12[0] = 99; // c
		esempio12[1] = 105; // i
		esempio12[2] = 97; // a
		esempio12[3] = 111; // o
		
		/**
		 * Questo procedimento e' lungo e noioso se si vuole
		 * scrive una array di caratteri molto lungo
		 * Percio' la classe String (che non e' un tipo primitivo)
		 * compila automaticamente questi array
		 */
		
		String esempio13 = "ciao"; // Il risultato e analogo all'esempio12
		
		/**
		 * L'ultimo tipo primitivo non e' un numero
		 * bensi una variabile da 1 bit che comprende
		 * solo due valori
		 * 
		 * vero = true
		 * falso = false
		 * 
		 * Questo tipo di variabile si definisce con boolean
		 */
		
		boolean isJanGay = true; // Hai detto al computer che Jan e' gay
		boolean isTeoEtero = false; // Hai detto al computer che Teo non e' etero
		
		
		
		
		/**
		 * L'ultimo tipo di variabile e' la classe Object
		 * che e' la classe madre per default di tutte le altre
		 * come ad esempio questa su cui sto scrivendo
		 */
		
		Tipi_di_variabili oggetto = new Tipi_di_variabili();
		
		/**
		 * Se tutte le classi derivano da Object allora anche
		 * Tipi_di_variabili sara' figlia di Object
		 * Percio' la variabile oggetto ereditera' tutti i metodi (o funzioni)
		 * di Object e in piu' avra quelli implementati in Tipi_di_variabili
		 */
		
		String codiceStringa = oggetto.toString();
		
		/**
		 * toString() e' un metodo di Object che Tipi_di_variabili ha
		 * ereditato dalla classe madre
		 * Converte l'oggetto in un codice di tipo String
		 */
		
		
		
		/**
		 * I tipi primitivi possono convertirsi a vicenda con una semplice operazione
		 * Il cast
		 * 
		 * <tipo finale> variabile = (<tipo finale>)(<calcolo di tipo misto>);
		 */
		
		long esempio14 = 10000000000L;
		int esempio15 = (int)(esempio14 / 100000); // Senza (int) il calcolo genera un errore di esecuzione
		
		/**
		 * Tra esempio14 (che e' long) ed esempio15 (che e' int)
		 * il computer calcola il risultato senza badare al tipo
		 * e infine lo alloca nello spazio di memoria int (32 bit)
		 * 
		 * Altri esempi sono:
		 */
		
		float esempio16 = (float)(500 / 3.5f + 8.904d * 100L); // Un int, un float, un double e un long che infine generano un risultato in float
		
		/**
		 * Il cast possono essere solo applicati ai tipi primitivi
		 * 
		 * Dunque ci sono altri metodi di conversione per le classi,
		 * ad esempio la classe String possiede il metodo valueOf()
		 * che converte un tipo primitivo in stringa
		 * 
		 * (perche String e' una classe e non un tipo primitivo)
		 */
		
		int valoreNumerico = 4000000;
		String valoreStringa = String.valueOf(valoreNumerico); // valoreStringa vale esattamente "4000000" (e non e' piu' calcolabile)
		
		/**
		 * Per riconvertirlo in int si usa il metodo parseInt() della classe
		 * Integer
		 */
		
		int valoreNumericoNuovo = Integer.parseInt(valoreStringa); // valoreNumericoNuovo e' identico a valoreNumerico
	}

}
