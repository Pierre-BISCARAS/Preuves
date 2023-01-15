package exo5;

/**
 * Ici on a un système qui n'est pas ouvert / fermé
 * ajouter un nouveau type de forme nécessite de modifier
 * le code de ListeFormes
 * 
 * On a aussi un problème de responsabilité unique,
 * ListeFormes gérant à la fois l'aire totale
 * et l'aire de chaque forme
 * 
 * On compose ListeFormes avec un type abstrait pour pouvoir étendre
 * facilement
 * 
 * Au passage, on a corrigé le problème d'encapsulation en ne laissant plus
 * les attributs de ListeFormes public
 */

public class ListeFormes {
	private Forme[] formes;

	public ListeFormes(Forme... formes)  {
		this.formes = formes;
	}
	
	public double aireTotale() {
		double aire = 0;
		for (Forme forme : this.formes)
			aire += forme.aire();
		return aire;
	}
}
