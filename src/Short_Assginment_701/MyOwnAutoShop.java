package Short_Assginment_701;

import java.util.ArrayList;

public class MyOwnAutoShop {

	public static void main(String[] args) {
		ArrayList<Car> listCar = new ArrayList<Car>();
		Sedan sd1 = new Sedan(100,5000,"Red",25);
		Sedan sd2 = new Sedan(110,7000,"Blue",18);
		Sedan sd3 = new Sedan(120,8000,"Yellow",20);
		Ford f1 = new Ford(150, 5500, "White", 2015, 10);
		Ford f2 = new Ford(170, 10000, "Black", 2021, 15);
		Truck tr1 = new Truck(140, 6000, "Gray", 3000);
		Truck tr2 = new Truck(130, 7500, "Green", 1000);
		listCar.add(sd1);
		listCar.add(sd2);
		listCar.add(sd3);
		listCar.add(f1);
		listCar.add(f2);
		listCar.add(tr1);
		listCar.add(tr2);	
		
		for (Car car : listCar) {
			System.out.println("Name " + car.getName() +" "+car.getRegularPrice() + " After "+ car.getSalePrice());
		}
	}

}
