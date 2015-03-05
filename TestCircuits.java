import java.util.ArrayList;
import java.util.List;

public class TestCircuits
{
	private static void printIds(Composant[] tab)
	{
		for (int i = 0; i < tab.length; i++)
			System.out.println(tab[i].getId());
	}

	private static void descriptions(Composant[] tab)
	{
		for (int i = 0; i < tab.length; i++)
			System.out.println(tab[i].description());
	}

	private static void traceEtats(Composant[] tab)
	{
		for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i].traceEtat());
		}
	}
	
	private static void test(Circuit circ) {
		//circ.nomenclature();
		circ.description();
		List<Interrupteur> inputs = circ.getIns();
		List<Vanne> outputs = circ.getOuts();
		
		System.out.println("\nInputs:");
		for (int i = 0; i < inputs.size(); i++)
			System.out.println(inputs.get(i).getId());
		
		System.out.println("\nOutputs:");
		for (int i = 0; i < outputs.size(); i++)
			System.out.println(outputs.get(i).getId());
		
		System.out.println("\nSetting input values...");
		inputs.get(0).on();
		inputs.get(1).on();
		inputs.get(2).off();
		System.out.println(outputs.get(0).traceEtat());
	}

	public static void main(String[] args)
	{
		//Construction
		Composant[] composants = new Composant[7];
		composants[0] = new Interrupteur();
		composants[1] = new Interrupteur();
		composants[2] = new Interrupteur();
		composants[3] = new Or();
		composants[4] = new And();
		composants[5] = new Not();
		composants[6] = new Vanne();

		//Connexions
		((Vanne)composants[6]).setIn(composants[4]);
		((And)composants[4]).setIn1(composants[3]);
		((And)composants[4]).setIn2(composants[5]);
		((Or)composants[3]).setIn1(composants[0]);
		//((Or)composants[3]).setIn1(new LazySonde((Or)composants[3], "in1"));
		((Or)composants[3]).setIn2(composants[1]);
		((Not)composants[5]).setIn(composants[2]);
		//((Not)composants[5]).setIn(new Sonde((Not)composants[5], "in1"));
		Circuit circuit = new Circuit("Circuit2ouf", composants);

		//Affichage
		/*System.out.println("Liste des composants");
		printIds(composants);

		System.out.println("\nDescription des composants");
		descriptions(composants);

		System.out.println("\nEtat des composants");
		traceEtats(composants);
		*/
		
		test(circuit);

		System.out.println("\nAu revoir!");
	}
}
