package com.axonactive.member;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.StoredProcedureParameter;

import com.axonactive.amigo.Amigo;
import com.axonactive.persistence.IEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQueries({
		@NamedQuery(name = "getMembersWithGenderOrFirstName", 
				query = "SELECT m from Member m where m.gender like :gender or m.firstName like :firstname")
		})
@NamedStoredProcedureQuery(
		name="findMemberByTeamID",
		resultSetMappings="MemberMapping",
		procedureName="find_Member_By_AmigoTeam_ID",
		parameters= {
				@StoredProcedureParameter(name = "team_id", 
							mode=ParameterMode.IN,
							type=Integer.class)
		}
		)
@SqlResultSetMapping(
		name="MemberMapping",
		classes=@ConstructorResult(targetClass = MemberDTO.class,
		columns= {
				@ColumnResult(name="firstName"),
				@ColumnResult(name="lastName"),
				@ColumnResult(name="gender"),
				@ColumnResult(name="email"),
				@ColumnResult(name="slogan")
		}
		))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member implements IEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;
	private String lastName;
	private String email;
	private String gender;

	@ManyToOne
	@JoinColumn(name = "amigo_team", nullable = false)
	private Amigo amigo_team;
}
