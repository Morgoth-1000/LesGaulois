package objets;
	public class Chaudron {
		private int quantitePotion = 0;
		private int forcePotion = 0;
		public void remplirChaudron(int quantite, int forcePotion) {
			quantitePotion = quantite;
			this.forcePotion = forcePotion;
		}
		public boolean resterPotion() {
			return quantitePotion > 0;
		}
		public int prendreLouche() {
			quantitePotion--;
			if (quantitePotion == 0) {
				forcePotion = 0;
			}
			return forcePotion;
		}
	}