package candidate.invitation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.AnyVararg;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CandidateInvitationServiceTest {
	@Mock
	CandidateService candidateService;
	
	@Test
	public void testCandidateService_ShouldReturnFullName_When1stNameAndLastName_IsGiven() {
		
		String fullName = "Ngo Nhat Quang";
		Mockito.when(candidateService.buildFullName("Ngo", "Nhat Quang")).thenReturn(fullName);
		assertEquals("Ngo Nhat Quang", fullName);
	}
	
}
