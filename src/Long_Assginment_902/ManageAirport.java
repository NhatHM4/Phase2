package Long_Assginment_902;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ManageAirport {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Set<Airports> listAirport = new HashSet<Airports>();
		do {
			System.out.println("================== AIRPORT MANAGEMENT SYSTEM ==================");
			System.out.println("1.Add new airport");
			System.out.println("2.Add new Fixed Wing");
			System.out.println("3.Remove Helicoper");
			System.out.println("4.Add new Helicoper");
			System.out.println("5.Remove Fixed Wing");
			System.out.println("6.Change type and min needed runway size");
			System.out.println("7.Airport Infomation");
			System.out.println("8.Display Fixed Wing");
			System.out.println("9.Display Helicoper");
			System.out.println("===============================================================");
			System.out.println("Enter your option");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				Airports ap = new Airports();
				ap.input();
				listAirport.add(ap);
				saveToFile(listAirport);
				break;
			case 2:
				addFixedWing(sc);
				break;
			case 3:
				removeHelicoper(sc);
				break;
			case 4:
				addHelicoper(sc);
				break;
			case 5:
				removeFixedWing(sc);
				break;
			case 6:
				changeTypeAndNeedRunway(sc);
				break;
			case 7:
				airportInfomation();
				break;
			case 8:
				displayFW();
				break;
			case 9:
				displayRW();
				break;
			case 0:
				listAirport = getData();
				for (Airports airports : listAirport) {
					airports.display();
				}
				break;
			}
		} while (true);

	}

	private static void displayRW() throws IOException {
		Set<Airports> listAirport = getData();
		System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "ID Airport", "Name Airport",
				"ID Helicoper", "Model", "Speed", "Empty weight", "Take Off weight");
		for (Airports airports : listAirport) {
			for (Helicoper heli : airports.getHelicoper()) {
				System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", airports.getID(),
						airports.getName(), heli.getId(), heli.getModel(), heli.getCruiseSpeed(), heli.getEmptyWeight(),
						heli.getMaxTakeOffWeight());
			}
		}
	}

	private static void displayFW() throws IOException {

		Set<Airports> listAirport = getData();
		System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "ID Airport", "Name Airport",
				"ID FixWing", "Model", "Speed", "Empty weight", "Take Off weight");
		for (Airports airports : listAirport) {
			for (FixedWing fw : airports.getFixedWing()) {
				System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", airports.getID(),
						airports.getName(), fw.getId(), fw.getModel(), fw.getCruiseSpeed(), fw.getEmptyWeight(),
						fw.getMaxTakeOffWeight());
			}
		}
	}

	private static void airportInfomation() throws IOException {
		Set<Airports> listAirport = getData();
		String statusFW = "";
		String statusRW = "";
		System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "ID", "Name", "Run Way Size",
				"Max FW", "Status", "Max RW", "Status");
		for (Airports airports : listAirport) {
			statusFW = airports.getMaxFW() <= airports.getFixedWing().size() ? "unavailable" : "available";
			statusRW = airports.getMaxFW() <= airports.getFixedWing().size() ? "unavailable" : "available";
			System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", airports.getID(),
					airports.getName(), airports.getRunWaySize(), airports.getMaxFW(), statusFW, airports.getMaxRW(),
					statusRW);
		}
	}

	private static void changeTypeAndNeedRunway(Scanner sc) throws IOException {
		Set<Airports> listAirport = getData();
		System.out.println("There are the airport available:");
		for (Airports airports : listAirport) {
			System.out.print(airports.getID() + " ");
		}
		System.out.println("Enter ID Airport want to change");
		String idAirport = sc.nextLine();
		System.out.println("Enter idFW want to change");
		String idFW = sc.nextLine();
		for (Airports airports : listAirport) {
			if (airports.getID().equals(idAirport)) {
				for (FixedWing fw : airports.getFixedWing()) {
					if (fw.getId().equals(idFW)) {
						System.out.println("Enter Plan Type want to change");
						String planType = sc.nextLine();
						fw.setPlanType(planType);
						System.out.println("Enter min needed runway size");
						int minRNS = Integer.parseInt(sc.nextLine());
						fw.setMinNRS(minRNS);
					}
				}
			}
		}
		saveToFile(listAirport);
	}

	private static void removeFixedWing(Scanner sc) throws IOException {
		Set<Airports> listAirport = getData();
		boolean aError = true;
		String c = "";
		System.out.println("There are the airport available:");
		for (Airports airports : listAirport) {
			System.out.print(airports.getID() + " ");
		}
		do {
			System.out.println("Enter ID Airport want to remove");
			String idAirport = sc.nextLine();
			System.out.println("Enter idFW want to remove");
			String idFW = sc.nextLine();
			for (Airports airports : listAirport) {
				if (airports.getID().equals(idAirport)) {
					for (int i = 0; i < airports.getFixedWing().size(); i++) {
						if (airports.getFixedWing().get(i).getId().equals(idFW)) {
							airports.getFixedWing().remove(i);
							System.out.println("remove successfully!!");
						}
					}
				}
			}
			System.out.println("Do you want to continue (Y/N)");
			c = sc.nextLine();
			if (c.equalsIgnoreCase("n")) {
				aError = false;
			} else {
				aError = true;
			}
		} while (aError);
		saveToFile(listAirport);
	}

	private static void addHelicoper(Scanner sc) throws IOException {
		Set<Airports> listAirport = getData();
		boolean aError = true;
		String c = "";
		System.out.println("There are the airport available:");
		for (Airports airports : listAirport) {
			System.out.print(airports.getID() + " ");
		}
		System.out.println("Enter ID Airport want to add Helicoper");
		String idAirport = sc.nextLine();
		do {
			System.out.println("Enter ID Helicoper");
			String idHelicoper = sc.nextLine();
			if (!checkContainHelicoper(listAirport, idHelicoper)) {
				for (Airports airports : listAirport) {
					if (airports.getMaxRW() > airports.getHelicoper().size() + 1) {
						if (airports.getID().equals(idAirport)) {
							Helicoper heli = new Helicoper();
							heli.input();
							airports.getHelicoper().add(heli);
							airports.setHelicoper(airports.getHelicoper());
							System.out.println("Do you want to continue (Y/N)");
							c = sc.nextLine();
							if (c.equalsIgnoreCase("n")) {
								aError = false;
							} else {
								aError = true;
							}
						}
					}
				}
			} else {
				System.out.println("ID helicoper is existed in other airport");
				System.out.println("Do you want to continue (Y/N)");
				c = sc.nextLine();
				if (c.equalsIgnoreCase("n")) {
					aError = false;
				} else {
					aError = true;
				}
			}
		} while (aError);
		saveToFile(listAirport);
	}

	private static boolean checkContainHelicoper(Set<Airports> listAirport, String idHelicoper) {
		for (Airports airports : listAirport) {
			for (Helicoper heli : airports.getHelicoper()) {
				if (heli.getId().equals(idHelicoper)) {
					return true;
				}
			}
		}
		return false;
	}

	private static void removeHelicoper(Scanner sc) throws IOException {
		Set<Airports> listAirport = getData();
		boolean aError = true;
		String c = "";
		System.out.println("There are the airport available:");
		for (Airports airports : listAirport) {
			System.out.print(airports.getID() + " ");
		}
		do {
			System.out.println("Enter ID Airport want to remove");
			String idAirport = sc.nextLine();
			System.out.println("Enter idHP want to remove");
			String idHP = sc.nextLine();
			for (Airports airports : listAirport) {
				if (airports.getID().equals(idAirport)) {
					for (int i = 0; i < airports.getHelicoper().size(); i++) {
						if (airports.getHelicoper().get(i).getId().equals(idHP)) {
							airports.getHelicoper().remove(i);
							System.out.println("remove successfully!!");
						}
					}
				}
			}
			System.out.println("Do you want to continue (Y/N)");
			c = sc.nextLine();
			if (c.equalsIgnoreCase("n")) {
				aError = false;
			} else {
				aError = true;
			}
		} while (aError);
		saveToFile(listAirport);
	}

	private static void addFixedWing(Scanner sc) throws IOException {
		Set<Airports> listAirport = getData();
		boolean aError = true;
		String c = "";
		System.out.println("There are the airport available:");
		for (Airports airports : listAirport) {
			System.out.print(airports.getID() + " ");
		}
		System.out.println("Enter ID Airport want to add FixedWing");
		String idAirport = Validator.validateAP();
		do {
			System.out.println("Enter idFW want to add");
			String idFW = Validator.validateFW();
			if (!checkParitcipateFW(listAirport, idFW)) {
				for (Airports airports : listAirport) {
					if (airports.getMaxFW() >= airports.getFixedWing().size() + 1) {
						if (airports.getID().equals(idAirport)) {
							FixedWing fw = new FixedWing();
							fw.setId(idFW);
							System.out.println("Enter model");
							String model = Validator.validateModel();
							fw.setModel(model);
							System.out.println("Enter Plane type");
							String planType = Validator.validateType();
							fw.setPlanType(planType);
							System.out.println("Enter crusie speed");
							int speed = Validator.validateNumber();
							fw.setCruiseSpeed(speed);
							System.out.println("Enter empty weight");
							int weight = Validator.validateNumber();
							fw.setEmptyWeight(weight);
							System.out.println("Enter max weight");
							int maxweight = Validator.validateTakeoffWeight(weight);
							fw.setMaxTakeOffWeight(maxweight);
							System.out.println("Enter minRNS");
							int minRNS = Validator.validateMinRNS(airports.getRunWaySize());
							fw.setMinNRS(minRNS);
							airports.getFixedWing().add(fw);
							airports.setFixedWing(airports.getFixedWing());
							System.out.println("Do you want to continue (Y/N)");
							c = sc.nextLine();
							if (c.equalsIgnoreCase("n")) {
								aError = false;
							} else {
								aError = true;
							}
						}
					} else {
						System.out.println("Parking place of Fixed Wing is full");
						return;
					}
				}
			} else {
				System.out.print("Exists ID Fixed Wing");
				checkParitcipateFW(listAirport, idFW);
				System.out.println("Do you want to continue (Y/N)");
				c = sc.nextLine();
				if (c.equalsIgnoreCase("n")) {
					aError = false;
				} else {
					aError = true;
				}
			}

		} while (aError);
		saveToFile(listAirport);

	}

	private static boolean checkParitcipateFW(Set<Airports> listAirport, String idFW) {
		for (Airports airports : listAirport) {
			for (FixedWing fw : airports.getFixedWing()) {
				if (fw.getId().equals(idFW)) {
					System.out.println(airports.getID());
					return true;
				}
			}
		}
		return false;

	}

	private static Set<Airports> getData() throws IOException {
		Set<Airports> listAirport = new HashSet<Airports>();
		ArrayList<FixedWing> listFixedWing = null;
		ArrayList<Helicoper> listHelicoper = null;
		String line1 = "";
		String line2 = "";
		String line3 = "";
		try {
			BufferedReader bff1 = new BufferedReader(new FileReader("D:\\Airport.txt"));
			while ((line1 = bff1.readLine()) != null) {
				Airports ap = new Airports();
				String[] data = line1.split(" ");
				ap.setID(data[0]);
				ap.setName(data[1]);
				ap.setRunWaySize(Integer.parseInt(data[2]));
				ap.setMaxFW(Integer.parseInt(data[3]));
				BufferedReader bff2 = new BufferedReader(new FileReader("D:\\FixedWing.txt"));
				listFixedWing = new ArrayList<FixedWing>();
				while ((line2 = bff2.readLine()) != null) {
					String[] data1 = line2.split(" ");
					if (data1[0].equals(data[0])) {
						FixedWing fw = new FixedWing();
						fw.setId(data1[1]);
						fw.setModel(data1[2]);
						fw.setPlanType(data1[3]);
						fw.setCruiseSpeed(Integer.parseInt(data1[4]));
						fw.setEmptyWeight(Integer.parseInt(data1[5]));
						fw.setMaxTakeOffWeight(Integer.parseInt(data1[6]));
						fw.setMinNRS(Integer.parseInt(data1[7]));
						listFixedWing.add(fw);
					}
				}
				ap.setFixedWing(listFixedWing);
				ap.setMaxRW(Integer.parseInt(data[4]));
				BufferedReader bff3 = new BufferedReader(new FileReader("D:\\Helicoper.txt"));
				listHelicoper = new ArrayList<Helicoper>();
				while ((line3 = bff3.readLine()) != null) {
					String[] data2 = line3.split(" ");
					if (data2[0].equals(data[0])) {
						Helicoper hp = new Helicoper();
						hp.setId(data2[1]);
						hp.setModel(data2[2]);
						hp.setCruiseSpeed(Integer.parseInt(data2[3]));
						hp.setEmptyWeight(Integer.parseInt(data2[4]));
						hp.setMaxTakeOffWeight(Integer.parseInt(data2[5]));
						hp.setRange(data2[6]);
						listHelicoper.add(hp);
					}
				}
				ap.setHelicoper(listHelicoper);
				listAirport.add(ap);
				bff2.close();
				bff3.close();
			}
			bff1.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAirport;
	}

	private static void saveToFile(Set<Airports> listAirport) {
		File file1 = new File("D:\\Airport.txt");
		File file2 = new File("D:\\FixedWing.txt");
		File file3 = new File("D:\\Helicoper.txt");
		OutputStream outputStream1 = null;
		OutputStream outputStream2 = null;
		OutputStream outputStream3 = null;
		OutputStreamWriter outputStreamWriter1 = null;
		OutputStreamWriter outputStreamWriter2 = null;
		OutputStreamWriter outputStreamWriter3 = null;
		try {
			outputStream1 = new FileOutputStream(file1);
			outputStream2 = new FileOutputStream(file2);
			outputStream3 = new FileOutputStream(file3);
			outputStreamWriter1 = new OutputStreamWriter(outputStream1);
			outputStreamWriter2 = new OutputStreamWriter(outputStream2);
			outputStreamWriter3 = new OutputStreamWriter(outputStream3);
			for (Airports airports : listAirport) {
				try {
					outputStreamWriter1.write(airports.getID() + " ");
					outputStreamWriter1.write(airports.getName() + " ");
					outputStreamWriter1.write(airports.getRunWaySize() + " ");
					outputStreamWriter1.write(airports.getMaxFW() + " ");
					for (int i = 0; i < airports.getFixedWing().size(); i++) {
						outputStreamWriter2.write(airports.getID() + " ");
						outputStreamWriter2.write(airports.getFixedWing().get(i).getId() + " ");
						outputStreamWriter2.write(airports.getFixedWing().get(i).getModel() + " ");
						outputStreamWriter2.write(airports.getFixedWing().get(i).getPlanType() + " ");
						outputStreamWriter2.write(airports.getFixedWing().get(i).getCruiseSpeed() + " ");
						outputStreamWriter2.write(airports.getFixedWing().get(i).getEmptyWeight() + " ");
						outputStreamWriter2.write(airports.getFixedWing().get(i).getMaxTakeOffWeight() + " ");
						outputStreamWriter2.write(airports.getFixedWing().get(i).getMinNRS() + " ");
						outputStreamWriter2.write("\n");
					}
					outputStreamWriter1.write(airports.getMaxRW() + " ");
					for (int i = 0; i < airports.getHelicoper().size(); i++) {
						outputStreamWriter3.write(airports.getID() + " ");
						outputStreamWriter3.write(airports.getHelicoper().get(i).getId() + " ");
						outputStreamWriter3.write(airports.getHelicoper().get(i).getModel() + " ");
						outputStreamWriter3.write(airports.getHelicoper().get(i).getCruiseSpeed() + " ");
						outputStreamWriter3.write(airports.getHelicoper().get(i).getEmptyWeight() + " ");
						outputStreamWriter3.write(airports.getHelicoper().get(i).getMaxTakeOffWeight() + " ");
						outputStreamWriter3.write(airports.getHelicoper().get(i).getRange() + " ");
						outputStreamWriter3.write("\n");
					}
					outputStreamWriter1.write("\n");
					outputStreamWriter1.flush();
					outputStreamWriter2.flush();
					outputStreamWriter3.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				outputStreamWriter1.close();
				outputStreamWriter2.close();
				outputStreamWriter3.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
}
