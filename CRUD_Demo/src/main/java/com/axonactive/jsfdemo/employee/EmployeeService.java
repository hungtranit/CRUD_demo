package com.axonactive.jsfdemo.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.axonactive.jsfdemo.persistence.AbstractCRUDBean;
import com.axonactive.jsfdemo.persistence.PersistenceService;

@Stateless
public class EmployeeService extends AbstractCRUDBean<EmployeeEntity> {
	@Inject
	private PersistenceService<EmployeeEntity> persistenceService;

	@Override
	protected PersistenceService<EmployeeEntity> getPersistenceService() {
		return this.persistenceService;
	}

	public EmployeeEntity toEntity(EmployeeBOM bom) {
		if (bom != null) {
			return new EmployeeEntity(bom.getId() != null ? bom.getId() : 0, bom.getFirstName(), bom.getLastName(),
					bom.getGender(), bom.getEmail(), bom.getDepartment());
		}
		return null;
	}

	public EmployeeBOM toBom(EmployeeEntity entity) {
		if (entity != null) {
			return new EmployeeBOM(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getGender(),
					entity.getEmail(), entity.getDepartment());
		}
		return null;
	}

	public List<EmployeeEntity> toFileEntities(List<EmployeeBOM> boms) {
		if (boms == null) {
			return Collections.emptyList();
		}
		List<EmployeeEntity> entities = new ArrayList<>();
		boms.stream().map(each -> toEntity(each)).filter(Objects::nonNull).forEach(entity -> entities.add(entity));
		return entities;
	}

	public List<EmployeeBOM> toBoms(List<EmployeeEntity> entities) {
		if (entities == null) {
			return Collections.emptyList();
		}
		List<EmployeeBOM> boms = new ArrayList<>();
		entities.stream().map(each -> toBom(each)).filter(Objects::nonNull).forEach(bom -> boms.add(bom));
		return boms;
	}

	public EmployeeEntity readOne(int value) {
		return (EmployeeEntity) persistenceService.createQuery("SELECT e FROM EmployeeEntity e WHERE e.id = :eid")
				.setParameter("eid", value).getSingleResult();
//		TypedQuery<EmployeeEntity> query = persistenceService.createNamedQuery(EmployeeEntity.FIND_ONE);
//		query.setParameter("eid", value);
//		return query.getSingleResult();
	}
	
	public EmployeeEntity add(EmployeeEntity entity) {
		return persistenceService.save(entity);
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeEntity> readAll() {
		return persistenceService.createQuery("FROM EmployeeEntity order by id DESC").getResultList();
	}

}
