package Long_Assginment_902;

import java.util.ArrayList;
import java.util.Scanner;

public class Airports implements Comparable<Airports> {
	private String id;
	private String name;
	private int runWaySize;
	private int maxFW;
	private ArrayList<FixedWing> FixedWing;
	private int maxRW;
	private ArrayList<Helicoper> Helicoper;

	public Airports() {
		// TODO Auto-generated constructor stub
	}

	public Airports(String id, String name, int runWaySize, int maxFW, ArrayList<FixedWing> fixedWing, int maxRW,
			ArrayList<Helicoper> helicoper) {
		super();
		this.id = id;
		this.name = name;
		this.runWaySize = runWaySize;
		this.maxFW = maxFW;
		FixedWing = fixedWing;
		this.maxRW = maxRW;
		Helicoper = helicoper;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID Airport");
		this.id = Validator.validateAP();
		System.out.println("Enter name ");
		this.name = sc.nextLine();
		System.out.println("Enter Run Way Size");
		this.runWaySize = Validator.validateNumber();
		System.out.println("Enter maxFW");
		this.maxFW = Validator.validateNumber();
		System.out.println("Enter number of Fixed Wing");
		int n = Validator.validateMinRNS(maxFW);
		FixedWing = new ArrayList<FixedWing>();
		for (int i = 0; i < n; i++) {
			FixedWing fw = new FixedWing();
			fw.input();
			System.out.println("Enter MinRNS");
			fw.setMinNRS(Validator.validateMinRNS(this.runWaySize));
			FixedWing.add(fw);
		}
		System.out.println("Enter maxRW");
		this.maxRW = Validator.validateNumber();
		System.out.println("Enter number of Helicoper");
		int m = Validator.validateMinRNS(maxRW);
		Helicoper = new ArrayList<Helicoper>();
		for (int i = 0; i < m; i++) {
			Helicoper hp = new Helicoper();
			hp.input();
			Helicoper.add(hp);
		}

	}

	public String getID() {
		return id;
	}

	public void setID(String iD) {
		id = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRunWaySize() {
		return runWaySize;
	}

	public void setRunWaySize(int runWaySize) {
		this.runWaySize = runWaySize;
	}

	public int getMaxFW() {
		return maxFW;
	}

	public void setMaxFW(int maxFW) {
		this.maxFW = maxFW;
	}

	public ArrayList<FixedWing> getFixedWing() {
		return FixedWing;
	}

	public void setFixedWing(ArrayList<FixedWing> fixedWing) {
		FixedWing = fixedWing;
	}

	public int getMaxRW() {
		return maxRW;
	}

	public void setMaxRW(int maxRW) {
		this.maxRW = maxRW;
	}

	public ArrayList<Helicoper> getHelicoper() {
		return Helicoper;
	}

	public void setHelicoper(ArrayList<Helicoper> helicoper) {
		Helicoper = helicoper;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airports other = (Airports) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + " " + this.name + " ";
	}

	public void display() {
		if ((FixedWing != null) && (!FixedWing.isEmpty())) {
			System.out.printf(
					"|%-15s |%-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n",
					"ID Airport", "Name Airport", "Run waysize", "Max FW", "ID FixedWing", "Model", "Plan Type",
					"Cruise Speed", "Empty weight", "MaxTOV", "MinRNS");
			for (FixedWing fixedWing2 : FixedWing) {
				System.out.printf("|%-15s |%-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n",
						this.id, this.name, this.runWaySize, this.maxFW, fixedWing2.getId(), fixedWing2.getModel(),
						fixedWing2.getPlanType(), fixedWing2.getCruiseSpeed(), fixedWing2.getEmptyWeight(),
						fixedWing2.getMaxTakeOffWeight(), fixedWing2.getMinNRS());
			}
		}
		
		if ((Helicoper != null) && (!Helicoper.isEmpty())) {
			System.out.printf(
					"|%-15s |%-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n",
					"ID Airport", "Name Airport", "Run waysize", "Max Helicoper", "ID Helicoper", "Model",
					"Cruise Speed", "Empty weight", "MaxTOV", "Range");
			for (Helicoper heli : Helicoper) {
				System.out.printf("|%-15s |%-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n", this.id,
						this.name, this.runWaySize, this.maxFW, heli.getId(), heli.getModel(), heli.getCruiseSpeed(),
						heli.getEmptyWeight(), heli.getMaxTakeOffWeight(), heli.getRange());
			}
		}
		System.out.println();
	}

	@Override
	public int compareTo(Airports o) {
		return this.id.compareTo(o.id);
	}
}
