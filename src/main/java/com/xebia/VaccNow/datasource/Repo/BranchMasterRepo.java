package com.xebia.VaccNow.datasource.Repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.xebia.VaccNow.services.dto.HospitalVaccinationDetailRequest;
import com.xebia.VaccNow.util.VaccNowUtil;

@Repository
public class BranchMasterRepo {

    Logger logger = LoggerFactory.getLogger(BranchMasterRepo.class);

	
	@Autowired
	@Qualifier("h2FactoryManager")
	private EntityManager em;

	
	private static final String VACCINE_BRANCH  = "select bm.branchCode, VaccineName, VaccineCode, AvailabiltyCount from branchmaster bm, vaccinemaster vm, VaccineBranchMaster vbm  where bm.vaccineid = vm.vaccineId and bm.branchcode= vbm.branchcode";
	private static final String VACCINE_PER_BRANCH  = VACCINE_BRANCH + " and bm.branchCode = :code";
	
	
	public List<BranchMaster> getAllBranches(){

		logger.info("Started executing getAllBranches method");
		
		CriteriaBuilder cb  = em.getCriteriaBuilder();
		List<BranchMaster> list =new ArrayList<BranchMaster>();
		
		try {
			CriteriaQuery<BranchMaster> cq = cb.createQuery(BranchMaster.class);
			Root<BranchMaster> stud = cq.from(BranchMaster.class);
			CriteriaQuery<BranchMaster> select = cq.select(stud);
			TypedQuery<BranchMaster> q = em.createQuery(select);
			list = q.getResultList();
		}
		catch(Exception e) {
			logger.error("An excpetion occured while fetching branches records from DB {}",e);
			throw e;
		}
		return list;
	}
	
	
	
	public List<Object[]> getAllVaccineInfoAllBranch() {

		logger.info("Started executing getAllVaccineInfoAllBranch method");

		List<Object[]> result = new ArrayList<Object[]>();
		try {
			Query query = em.createNativeQuery(VACCINE_BRANCH);
			result = query.getResultList();
		} catch (Exception e) {
			logger.error("An excpetion occured while fetching vaccine records from DB {}", e);
			throw e;
		}

		return result;

	}
	
	
	public List<Object[]> getAllVaccineInfoAllParticularBranch(String branchCode) {

		logger.info("Started executing getAllVaccineInfoAllParticularBranch method");

		List<Object[]> result = new ArrayList<Object[]>();
		try {
			Query query = em.createNativeQuery(VACCINE_PER_BRANCH);
			query.setParameter("code", branchCode);
			result = query.getResultList();

		} catch (Exception e) {
			logger.error("An excpetion occured while fetching branches records from DB {}", e);
		}
		return result;

	}

	public List<TimeSlotMaster> getTimeForBanch(String branchCode){

		logger.info("Started executing getTimeForBanch method");
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		List<TimeSlotMaster> resultlist = new ArrayList<TimeSlotMaster>();
		try {
			CriteriaQuery<VaccineBranchMaster> cq = cb.createQuery(VaccineBranchMaster.class);
			Root<VaccineBranchMaster> stud = cq.from(VaccineBranchMaster.class);
			CriteriaQuery<VaccineBranchMaster> select = cq.select(stud).where(cb.equal(stud.get("BranchCode"),branchCode));
			TypedQuery<VaccineBranchMaster> q = em.createQuery(select);
			List<VaccineBranchMaster> list = q.getResultList();
			resultlist = list.stream().map(v -> v.getTimeSlotId()).collect(Collectors.toList());

		} catch (Exception e) {
			logger.error("An excpetion occured while fetching branches records from DB {}", e);
			throw e;
		}

		return resultlist;
	}


	public List<HosipltalVaccinationDetals> getAllAppliedVaccines(String branchCode){
		
		logger.info("Started executing getAllAppliedVaccines method");
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		List<HosipltalVaccinationDetals> list = new ArrayList<HosipltalVaccinationDetals>();

		try {
			CriteriaQuery<HosipltalVaccinationDetals> cq = cb.createQuery(HosipltalVaccinationDetals.class);
			Root<HosipltalVaccinationDetals> stud = cq.from(HosipltalVaccinationDetals.class);
			CriteriaQuery<HosipltalVaccinationDetals> select = cq.select(stud)
					.where(cb.equal(stud.get("BranchCode"), branchCode));
			TypedQuery<HosipltalVaccinationDetals> q = em.createQuery(select);
			list = q.getResultList();

		} catch (Exception e) {
			logger.error("An excpetion occured while fetching branches records from DB {}", e);
			throw e;
		}

		return list;
	}
	
	public List<HosipltalVaccinationDetals> getAllAppliedVaccinesPerDay(Date inputDate){

		logger.info("Started executing getAllAppliedVaccinesPerDay method");
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		List<HosipltalVaccinationDetals> list = new ArrayList<HosipltalVaccinationDetals>();

		try {
			CriteriaQuery<HosipltalVaccinationDetals> cq = cb.createQuery(HosipltalVaccinationDetals.class);
			Root<HosipltalVaccinationDetals> stud = cq.from(HosipltalVaccinationDetals.class);
			CriteriaQuery<HosipltalVaccinationDetals> select = cq.select(stud)
					.where(cb.equal(stud.get("VaccinationDate"), inputDate));
			TypedQuery<HosipltalVaccinationDetals> q = em.createQuery(select);
			list = q.getResultList();
		} catch (Exception e) {
			logger.error("An excpetion occured while applied Vaccines records from DB {}", e);
			throw e;
		}
		return list;
	}

	public List<HosipltalVaccinationDetals> getAllConfirmedVaccinationsOveraTimePerid(Date startDate, Date endDate) {
		
		logger.info("Started executing getAllConfirmedVaccinationsOveraTimePerid method");

		CriteriaBuilder cb = em.getCriteriaBuilder();
		List<HosipltalVaccinationDetals> list = new ArrayList<HosipltalVaccinationDetals>();
		try {
			CriteriaQuery<HosipltalVaccinationDetals> cq = cb.createQuery(HosipltalVaccinationDetals.class);
			Root<HosipltalVaccinationDetals> stud = cq.from(HosipltalVaccinationDetals.class);
			Predicate p = cb.equal(stud.get("IsVaccineApplied"), "Y");
			Predicate p2 = cb.between(stud.get("VaccinationDate"), startDate, endDate);
			CriteriaQuery<HosipltalVaccinationDetals> select = cq.select(stud).where(cb.and(p, p2));
			TypedQuery<HosipltalVaccinationDetals> q = em.createQuery(select);
			list = q.getResultList();
		} catch (Exception e) {
			logger.error("An excpetion occured while fetching branches records from DB {}", e);
		}
		return list;
	}

	@Transactional(isolation = Isolation.SERIALIZABLE)
	public String savePatientDetails(HospitalVaccinationDetailRequest request){
		logger.info("Started executing savePatientDetails method");
		try {
			VaccineMaster vm = em.find(VaccineMaster.class, request.getVaccineId());
			TimeSlotMaster tsm = em.find(TimeSlotMaster.class, request.getTimeSlotId());
			PaymentDetails pd = em.find(PaymentDetails.class, request.getPayModeid());
			if (vm != null && tsm != null && pd != null) {
				HosipltalVaccinationDetals hvd = new HosipltalVaccinationDetals();
				hvd.setAmount(request.getAmount());
				hvd.setBookingBy(request.getBookingBy());
				hvd.setBranchCode(request.getBranchCode());
				hvd.setBookingTime(VaccNowUtil.formatdate2(request.getBookingTime()));
				hvd.setConfirmMailSent(request.getConfirmMailSent());
				hvd.setIsVaccineApplied(request.getIsVaccineApplied());
				hvd.setPaitentAddress(request.getPaitentAddress());
				hvd.setPaitentEmail(request.getPaitentEmail());
				hvd.setPaitentName(request.getPaitentName());
				hvd.setPayModeDetails(request.getPayModeDetails());
				hvd.setPayModeid(request.getPayModeid());
				hvd.setTimeSlotId(tsm);
				hvd.setVaccinationDate(request.getVaccinationDate());
				hvd.setConfirmMailSent(request.getConfirmMailSent());
				hvd.setVaccine(vm);
				em.persist(hvd);
				
				EmailDetails ed = new EmailDetails();
				ed.setDetail(hvd);
				ed.setEmailAddess(request.getPaitentEmail());
				ed.setMailContent("Your vaccinaton has been confirmed. Stay Safe");
				ed.setMailSubject("Confirmed - vaccination Information");
				em.persist(ed);
			}
		} catch (Exception e) {
			logger.info("Error occured while saving patient details in DB");
			return "ERROR";
		}
		return "SUCCESS";
	}
	

}
