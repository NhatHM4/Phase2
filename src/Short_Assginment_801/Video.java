package Short_Assginment_801;

public class Video extends Multimedia{
	
	public Video() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Video(String name, double duration) {
		super(name,duration);
	}
	
	public void createVideo() {
		super.createMultimedia();
	}
	
	@Override
	public String toString() {

		return "Video :             " + getName() + "           " + getDuration();
	}

}
