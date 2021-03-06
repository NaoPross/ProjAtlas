package jan.compiti;

public class Compito1 {
	
	/*
	 * Teo crea una nuova classe (in questo package),
	 * chiamala Mechanics e crea un metodo
	 * calcAtt che ingloba le variabili intere
	 * (ATT, IVs, EVs, liv, nat)
	 * 
	 * ATT = attacco di base {dipende dal pokemon in questione}
	 * IVs = valori individuali {da 0 a 31}
	 * EVs = punti allenamento {da 0 a 252}
	 * liv = livello {da 1 a 100}
	 * nat = natura {0.9 (se svantaggiosa), 1 (se non influisce) oppure 1.1 (se vantaggiosa)}
	 * 
	 * e ritorna la variabile intera att
	 * 
	 * per poter ritornare il risultato corretto
	 * la funzione elabora le variabili nel seguente modo
	 * 
	 * moltiplica per 2 ATT
	 * dividi per 4 Evs
	 * i due risultati ottenuti si sommano
	 * al risultato somma anche IVs
	 * moltiplica il risultato per liv e dividilo per 100
	 * aggiungi 5
	 * moltiplicalo per nat
	 * 
	 * ottenuto il risultato finale att ritornalo
	 * per farlo uscire dalla funzione
	 * 
	 * Dopodich� applica il metodo (dal main()) al pokemon Garchomp
	 * che possiede ATT = 130
	 * le altre variabili definiscile a tua scelta
	 * 
	 * usando il metodo definito prima calcola statistica attacco di garchomp (cioe att)
	 */

	public static void main(String[] args) {
		
		Mechanics oggetto = new Mechanics();
		
		int ATT = 130;
		int IVs = 31;
		int EVs = 252;
		int liv = 100;
		float nat = 1.1f;
		
		int attGarchomp = oggetto.calcAtt(ATT, IVs, EVs, liv, nat);
		
		System.out.println(attGarchomp);
		
		int ATTjolteon = 50;
		int IVsjolteon = 10;
		int EVsjolteon = 0;
		int livjolteon = 50;
		float natjolteon = 0.9f;
		
		int attjolteon = oggetto.calcAtt(ATTjolteon, IVsjolteon, EVsjolteon, livjolteon, natjolteon);
		
		System.out.println(attjolteon);
	} 

}
