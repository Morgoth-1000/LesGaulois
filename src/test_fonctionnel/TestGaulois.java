package test_fonctionnel;
	import personnages.Druide;
	import personnages.Gaulois;
	import personnages.Romain;
	public class TestGaulois {
		public static void main(String[] args) {
			Gaulois asterix = new Gaulois("Astérix", 8);
			Gaulois obelix = new Gaulois("Obélix", 16);
				Romain minus = new Romain("Minus", 6);
				asterix.parler("Bonjour Obélix.");
				obelix.parler("Bonjour Astérix. Ca te dirais d'aller chasser des sangliers ?);");
				asterix.parler("Oui très bonne idée");
				System.out.println("Dans la forêt " + asterix + " et " + obelix + " tombe nez à nez sur le romain "
						+ minus.getNom() + ".");
				for (int i = 0; i < 3; i++) {
					asterix.frapper(minus);
				}
				Romain brutus = new Romain("Brutus", 14);
				Druide druide = new Druide("Panoramix",2);
				druide.fabriquerPotion(4, 3);
				druide.booster(obelix);
				druide.booster(asterix);
				for (int i = 0; i < 3; i++) {
					asterix.frapper(brutus);
				}
		}
}