package village_gaulois;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Gaulois chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom, Gaulois chef, final int NB_VILLAGEOIS_MAX) {
			this.nom = nom;
			villageois = new Gaulois[NB_VILLAGEOIS_MAX];
			this.chef = chef;
			chef.setVillage(this);
	}
	
	public String getNom() {
		return nom;
	}
	
	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		gaulois.setVillage(this);
		nbVillageois++;
	}

	public Gaulois trouverVillageois(int numVillageois) {
		Gaulois gauloisCherche = null;
		if (numVillageois > 0 && numVillageois < nbVillageois + 1) {
			gauloisCherche = villageois[numVillageois - 1];
		} 
		else {
			System.out.println("Il n’y a pas autant d’habitant dans notre village !");
		}

		return gauloisCherche;
	}

	public void afficherVillageois() {
		System.out.println("Dans le village \"" + nom + "\" du chef " + chef + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			System.out.println("- " + gaulois);
		}
	}

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irreductibles", abraracourcix, 30);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		Gaulois obelix = new Gaulois("Obélix", 21);
		village.ajouterVillageois(obelix);
		village.afficherVillageois();
		Gaulois doublepolemix = new Gaulois("Doublepolémix", 4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();
	}

	}