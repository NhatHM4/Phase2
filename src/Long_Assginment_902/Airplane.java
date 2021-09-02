package Long_Assginment_902;

import java.util.Scanner;


public abstract class Airplane {
	private String id;
	private String model;
	private int cruiseSpeed;
	private int emptyWeight;
	private int maxTakeOffWeight;
	
	public Airplane() {
		// TODO Auto-generated constructor stub
	}

	public Airplane(String id, String model, int cruiseSpeed, int emptyWeight, int maxTakeOffWeight) {
		this.id = id;
		this.model = model;
		this.cruiseSpeed = cruiseSpeed;
		this.emptyWeight = emptyWeight;
		this.maxTakeOffWeight = maxTakeOffWeight;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter model");
		this.model = Validator.validateModel();
		System.out.println("Enter speed");
		this.cruiseSpeed =Validator.validateNumber();
		System.out.println("Enter empty Weight");
		this.emptyWeight = Validator.validateNumber();
	}
	
	public abstract void flyMethod();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCruiseSpeed() {
		return cruiseSpeed;
	}

	public void setCruiseSpeed(int cruiseSpeed) {
		this.cruiseSpeed = cruiseSpeed;
	}

	public int getEmptyWeight() {
		return emptyWeight;
	}

	public void setEmptyWeight(int emptyWeight) {
		this.emptyWeight = emptyWeight;
	}

	public int getMaxTakeOffWeight() {
		return maxTakeOffWeight;
	}

	public void setMaxTakeOffWeight(int maxTakeOffWeight) {
		this.maxTakeOffWeight = maxTakeOffWeight;
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
        Airplane other = (Airplane) obj;
        if (id == null) {
          if (other.id != null)
            return false;
        } else if (!id.equals(other.id))
          return false;
        return true;
      }
	

}
