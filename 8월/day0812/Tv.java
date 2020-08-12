package day0812;

public class Tv extends Product{
	
	private int inch;
	
	public Tv() {}

	public Tv(int no, String name, int price, int stock,int inch) {
		super(no, name, price, stock);
		this.inch=inch;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tv [volume=");
		builder.append(inch);
		builder.append(", ");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}	
	
	
}
