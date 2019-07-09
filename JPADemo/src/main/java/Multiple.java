import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Multiple {
	private int ints;
	
	private double doubles;
	
	
	public double multiple(double a, int b) {
		return a*b;
	}
}
