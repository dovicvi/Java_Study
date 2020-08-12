package day0812;

public class Refrigerator extends Product{
	
	private int volume;
	
	public Refrigerator() {}

	public Refrigerator(int no,String name,int price,int stock,int volume) {
		super(no, name, price,stock);
		this.volume=volume;
	}	
	
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Refrigerator [volume=");
		builder.append(volume);
		builder.append(", ");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
