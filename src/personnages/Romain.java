package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	private String prendreParole() {
		// TODO Auto-generated method stub
		return "Le romain" + nom + ":";
	}
		
	public void recevoirCoup(int forceCoup) {
		force = force - forceCoup;
		if (force < 1) {
			force=0;
			System.out.println("Le Romain " + nom + " : J'abandonne " );
		}
		else {
			parler("Aie");
		}		
	
	}
}
