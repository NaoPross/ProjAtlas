package jan.compiti;

public class Mechanics {

	public int calcAtt(int ATT, int IVs, int EVs, int liv, float nat) {
		
		int att = (2 * ATT + EVs / 4 + IVs) * liv / 100 + 5;
		att = (int)(att * nat);
		return att;
	}
}
