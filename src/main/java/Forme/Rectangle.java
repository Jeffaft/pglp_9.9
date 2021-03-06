package Forme;
public class Rectangle implements Forme {
	private String nom;
	private int hauteur;
	private int longueur;
	private Point bas_gauche;
	
	public Rectangle (String nom, Point p, int h, int l) {
		this.nom = nom;
		this.bas_gauche = p;
		this.hauteur = h;
		this.longueur = l;
	}
	
	public String toString () {
		return  "Rectangle (" + nom + ", " + bas_gauche.toString() + ", "
						+ hauteur +", "+longueur+")";
	}
	public String getNom() {
		return nom;
	}
	public int getHauteur() {
		return hauteur;
	}
	public int getLongueur() {
		return longueur;
	}
	public Point getBas_gauche() {
		return bas_gauche;
	}
	@Override
	public void moove(int x, int y) {
		this.bas_gauche.moovePoint(x, y);
	}
}
