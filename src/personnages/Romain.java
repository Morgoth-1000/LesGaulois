package personnages;
import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements= new Equipement [2];
	private int nbEquipement = 0;
	private static final String LE_SOLDAT = "Le soldat ";
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}
	

	public int getForce() {
		return force;
	}


	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println( LE_SOLDAT  + nom + " est déjà bien protégé !");
			break;
		case 1:
			if(equipements[0].equals(equipement)) {
				System.out.println(LE_SOLDAT  + nom + " possède déjà un " + equipement + ".");
			} 
			else {
				equiperSoldat(equipement);
			}

			break;
		default:
			equiperSoldat(equipement);
			break;
		}
	}

	private void equiperSoldat(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println(LE_SOLDAT  + nom + " s'équipe avec " + equipement);
	}

	public static void main(String[] args) {
		new Romain("Minus", -6);
	}


	
	
	private int calculResistanceEquipement(int forceCoup) {
	   
	    String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
	    int resistanceEquipement = 0;
	    if (nbEquipement != 0) {
	        for (int i = 0; i < nbEquipement; i++) {
	            if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
	                resistanceEquipement += 8;
	            } else {
	                System.out.println("Equipement casque");
	                resistanceEquipement += 5;
	            }
	        }
	        if (resistanceEquipement >= forceCoup) {
	            texte += "\nMais heureusement, grâce à mon équipement sa force a été complètement absorbée.";
	            forceCoup = 0; 
	        } else {
	            texte += "\nMais heureusement, grâce à mon équipement sa force est diminuée de " + resistanceEquipement + "!";
	            forceCoup -= resistanceEquipement; 
	        }
	    }

	    parler(texte);
	    return forceCoup;
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
		    parler("Aïe");
		} else {
		    equipementEjecte = ejecterEquipement();
		    parler("J'abandonne...");
		}
		return equipementEjecte;
	}
	
		private Equipement[] ejecterEquipement() {
			Equipement[] equipementEjecte = new Equipement[nbEquipement];
			System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
            if (equipements[i] != null) {
                equipementEjecte[nbEquipementEjecte] = equipements[i];
                nbEquipementEjecte++;
                equipements[i] = null;
            }
        }
		return equipementEjecte;
	}
}