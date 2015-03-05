import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;

public class Circuit {

	String nom;
	List<Composant> composants = new ArrayList<Composant>();

	public Circuit(String nom, Composant[] cps) {
		this.nom = nom;
		composants.addAll(Arrays.asList(cps));
		Collections.sort(composants);
	}
	
	public List<String> nomenclature() {
		Iterator<Composant> iter = composants.iterator();
		List<String> res = new ArrayList<String>();
		while (iter.hasNext())
			res.add(iter.next().getId());
		return res;
	}
	
	public void description(){
		Iterator<Composant> iter = composants.iterator();
		System.out.println("Circuit description of: " + nom);
		while (iter.hasNext())
			System.out.println(iter.next().description());
	}
	
	public void traceEtats() {
		Iterator<Composant> iter = composants.iterator();
		System.out.println("Circuit state of: " + nom);
		while (iter.hasNext())
			System.out.println(iter.next().traceEtat());
	}
	
	public List<Interrupteur> getIns() {
		List<Interrupteur> res = new ArrayList<Interrupteur>();
		Iterator<Composant> iter = composants.iterator();
		while (iter.hasNext()) {
			Composant currentCp = iter.next();
			if (currentCp instanceof Interrupteur)
				res.add((Interrupteur) currentCp);
		}
		return res;
	}
	
	public List<Vanne> getOuts() {
		List<Vanne> res = new ArrayList<Vanne>();
		Iterator<Composant> iter = composants.iterator();
		while (iter.hasNext()) {
			Composant currentCp = iter.next();
			if (currentCp instanceof Vanne)
				res.add((Vanne) currentCp);
		}
		return res;
	}
}
