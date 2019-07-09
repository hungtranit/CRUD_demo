package com.axonactive.member;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import com.axonactive.persistence.AbtractCRUDBean;
import com.axonactive.persistence.PersistenceService;

@Stateless
public class MemberService extends AbtractCRUDBean<Member> {
	@Inject
//	@EJB
	private PersistenceService<Member> persistenceService;

//	@PersistenceContext(name = "JSFDEMO")
//	protected EntityManager em;

	@PersistenceContext
	private EntityManager em;

//	
	@Override
	protected PersistenceService<Member> getPersistenceService() {
		return this.persistenceService;
	}

	@SuppressWarnings("unchecked")
	public List<Member> getListMembers(String gender, String firstName) {
		Query query = persistenceService
				.createQuery("from Member where gender like :gender or firstName like :firstname")
				.setParameter("gender", gender).setParameter("firstname", firstName);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Member> getMembers(String gender, String firstName) {
		Query query = em.createNamedQuery("getMembersWithGenderOrFirstName").setParameter("gender", gender)
				.setParameter("firstname", firstName);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<MemberDTO> getListMemberById_usingNameQuery(Integer teamID) {
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("findMemberByTeamID");
		query.setParameter("team_id", teamID);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<MemberDTO> getListMemberById_usingStoredProcedureDirectly(Integer teamID) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("find_Member_By_AmigoTeam_ID", "MemberMapping");
		query.registerStoredProcedureParameter("team_id", Integer.class, ParameterMode.IN);
		query.setParameter("team_id", teamID);
		return query.getResultList();
	}

}
