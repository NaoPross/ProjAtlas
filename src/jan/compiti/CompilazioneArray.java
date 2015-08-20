package jan.compiti;

public class CompilazioneArray {

	public static void main(String[] args) {
		
		int lunghezza = 10; // definisco la variabile intera lunghezza
		
		int[] lista = new int[lunghezza]; // definisco un nuovo array vuoto di numeri interi di 10 slot
		
		/**
		 * Compilo l'array in modo tradizionale ma inefficiente
		 */
		
		lista[0] = 1;
		lista[1] = 2;
		lista[2] = 3;
		lista[3] = 4;
		lista[4] = 5;
		lista[5] = 6;
		lista[6] = 7;
		lista[7] = 8;
		lista[8] = 9;
		lista[9] = 10;
		
		/**
		 * Compilando l'array in questo modo si
		 * si finisce tra due giorni
		 * 
		 * Percio utilizzando un ciclo for si puo
		 * esser piu veloci se i numeri dell'array seguono una logica
		 * matematica
		 * 
		 * Appunto avere una variabile i che aumenta ad ogni ripetizione
		 * rende la vita piu semplice
		 * 
		 * In questo caso i numeri sono ordinati aritmeticamente
		 * (1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		 */
		
		for (int i = 0; i < lunghezza; i++) {
			
			lista[i] = i + 1;
		}
		
		/**
		 * Alla prima ripetizione i = 0
		 * Percio lista[i] = i + 1 significa lista[0] = 0 + 1 = 1
		 * 
		 * Alla seconda i = 1
		 * Percio lista[1] = 1 + 1 = 2
		 * 
		 * Ecc... fino a compilare l'intero array di 10 slot
		 * 
		 * La funzione matematica con cui e stato compilato
		 * l'array e
		 * y = x + 1 (in un ciclo for la i prende il posto della x)
		 */
	}

}
