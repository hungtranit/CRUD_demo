package com.axonactive.jsfdemo.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.axonactive.jsfdemo.department.DepartmentEntity;
import com.axonactive.jsfdemo.persistence.IEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
//@NamedQueries({
//	@NamedQuery(name = EmployeeEntity.FIND_ONE, query = "SELECT e FROM EmployeeEntity e WHERE e.id = :eid")
//})
public class EmployeeEntity implements IEntity {
	public static final String FIND_ONE = "";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_Name", nullable = false)
	private String lastName;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "email", nullable = false)
	private String email;

	@ManyToOne
	@JoinColumn(name = "department", nullable = false)
	private DepartmentEntity department;

}
