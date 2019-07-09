
public class YourMother {
	
	private IntegerList integerList;
	
	public YourMother() {
		integerList = new IntegerList();
	}
	
	public void yell()throws ExampleException {
		integerList.givenList(2, 2);
	}

	public void setIntegerList(IntegerList integerList) {
		this.integerList = integerList;
	}
	
	
}
