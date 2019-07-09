import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class TestExample {
	
	@Mock
	private IntegerList integerListMock;
	
	@Captor
	private ArgumentCaptor<Integer> captor1;
	
	@Captor
	private ArgumentCaptor<Integer> captor2;
	
	@Test
	public void testSum_ShouldReturn_SumOf2Ints() {
		Sum sum = new Sum();
		assertEquals(3, sum.sum(1, 2));
	}

	@Test
	public void testMultiple_ShouldReturn_ADouble_WhenMultipleAIntAndADouble() {
		Multiple multiple = new Multiple();
		assertEquals(15.0, multiple.multiple(3.0, 5));
	}
	
	@Test
	public void testJoinString_ShouldReturn_ALongString() {
		JoinString joinString = new JoinString();
		assertEquals("Today is Friday", joinString.join("Today is ","Friday"));
	}
	
	@Test
	public void testEqual_ShouldReturnTrue_WhenTooIntIsTheSame() {
		Equal equal = new Equal();
		assertEquals(true, equal.equal(22,22));
	}
	
	@Test
	public void testException_ShouldThrowsException_WhenCallYourMother() throws ExampleException {
		YourMother mom = new YourMother();
		mom.setIntegerList(integerListMock);
		
		mom.yell();
		
		Mockito.verify(integerListMock).givenList(captor1.capture(), captor2.capture());
		
	}
	
	@Test
	public void Should_ReturnList_When_Given_List() {
		List<Integer> listInt = new ArrayList<>();
		listInt.add(1);
		listInt.add(2);
		listInt.add(4);
		listInt.add(3);
		IntegerList actual = new IntegerList();
		
		Assert.assertEquals(listInt, actual.givenList(1, 2));
	}
}
