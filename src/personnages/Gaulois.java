package personnages;
import village_gaulois.Village;
import objets.Equipement;
	
public class Gaulois {
	private String nom;
	private Village village;
	private int effetPotion = 1;
	private int force;
	private int nbtrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}

	public void sePresenter() {
		StringBuilder chaine = new StringBuilder("Bonjour, je m'appelle " + nom + ". ");
		if (village == null) {
			chaine.append("Je voyage de villages en villages.");
		} 
		else {
			if (village.getChef().equals(this)) {
				chaine.append("Je suis le chef ");
			}
			else {
				chaine.append("J'habite ");
			}

			chaine.append("le village " + village.getNom() + ".");
		}

		parler(chaine.toString());
	}

	@Override
	public String toString() {
	return nom;
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesBataille = romain.recevoirCoup((force / 3) * effetPotion);
		effetPotion--;
		if (effetPotion < 1) {
			effetPotion = 1;
		}
		for (int i = 0; tropheesBataille != null && i < tropheesBataille.length; i++, nbtrophees++) {
			this.trophees[nbtrophees] = tropheesBataille[i];
		}
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}
}