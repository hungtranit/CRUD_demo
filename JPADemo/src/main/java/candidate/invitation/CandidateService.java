package candidate.invitation;

public class CandidateService {
	
	public String buildFullName(String firstName, String lastName) {
		return String.join(" ", firstName, lastName);
	}
}
