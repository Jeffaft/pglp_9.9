package Forme;
import java.util.List; 
import java.util.ArrayList;
import java.util.Iterator;

public class GroupeForme implements Forme {
	private String nom;
	private ArrayList<Forme>listForme = new ArrayList<Forme>();
	
	public GroupeForme (String nom) {
		this.nom = nom;
	}
	
	public void add (Forme f) {
		listForme.add(f);
	}
	public void delete (String nom) {
		Iterator<Forme> itr = listForme.iterator();
		Forme f = null;
		while (itr.hasNext()) {
			f = itr.next();
			if(f.getNom().equals(nom)) {
				this.listForme.remove(this.listForme.indexOf(f));
				return;
			}				
		}
	}
	
	public String toString() {
		String str = nom+ " (\n\n\t";
		Iterator<Forme> itr = listForme.iterator();
		while (itr.hasNext()) {
			str += itr.next().toString() +"\n\t"; 
		}
		
		str += "\n)";
		return str;
	}
	public String getNom() {
		return nom;
	}
	
	public Iterator<Forme> getListIteraror() {
		return listForme.iterator();
	}
	
	public boolean contain(String nom) {
		Iterator<Forme> itr = listForme.iterator();
		while (itr.hasNext()) {
			if(itr.next().getNom().equals(nom))
					return true;
		}
		return false;
	}
	
	@Override
	public void moove(int x, int y) {
		Iterator<Forme> itr = listForme.iterator();
		while (itr.hasNext()) {
			itr.next().moove(x, y);
		}
	}
	public Forme getForme(String nom) {
		Iterator<Forme> itr = listForme.iterator();
		Forme f = null;
		while (itr.hasNext()) {
			f = itr.next();
			if(f.getNom().equals(nom))
					return f;
		}
		return f;
	}
	
}
