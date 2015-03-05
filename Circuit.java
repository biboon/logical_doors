import java.util.List;
import java.util.Arrays;

public class Circuit {

	String nom;
	List<Composant> composants;

	public Circuit(String nom, Composant[] cps){
		this.nom = nom;
		composants.addAll(Arrays.asList(cps));
	}

}
