package village_gaulois;
import personnages.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois;
	
	public Village(String nom, int nbVillageois) {
		this.nom = nom;
		this.nbVillageois = nbVillageois;
		this.villageois = new Gaulois[nbVillageois];
	}
	public String getNom() {
		return nom;
	}
	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois ++;
		
	}
	public Gaulois trouverVillageois(int numVillageois) {
		int indice = numVillageois +1;
		if (indice >=0 && indice< numVillageois) {
			return villageois[indice];
			
		}
		
		

	}
	public afficherVillage() {
		
	}
}
