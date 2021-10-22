package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import pojos.Vendor;

public class VendorDaoImpl implements IVendorDao{

	@Override
	public String addVendor(Vendor vendor) {
		String mesg = "Vendor cannot  be added...";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Serializable id = session.save(vendor);
			System.out.println("Committed...!!");
			System.out.println(id);
			tx.commit();
			mesg = "Vendor register with vendor id"+id;
		}
		catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		finally {
			if(session != null)
				session.close();
		}
		return mesg;
	}

	@Override
	public Vendor findVendorDetailsById(int vendorId) {
		Vendor vendor = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			vendor =session.get(Vendor.class, vendorId);
			tx.commit();
		}
		catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		finally {
			if(session!= null)
				session.close();
		}
		return vendor;
	}

	@Override
	public Vendor vendorLogin(String email) {
		Vendor vendor = null;
		String mesg = "Invalid login..!!";
		String jpql = "select v from Vendor v where v.email = :em";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			vendor = session.createQuery(jpql, Vendor.class).setParameter("em", email).getSingleResult();
			mesg ="Successful Login....!!";
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx!= null)
				tx.rollback();
			throw e;
		}
		System.out.println(mesg);
		return vendor;
	}

	@Override
	public String UpdateRegistrationAmount(String email, double regAmount) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String mesg= "Updating reg amt failed...";
		String jpql = "update  Vendor v set v.regAmount = :regamt where email = :em";
		try {
			
			int count = session.createQuery(jpql).setParameter("regamt", regAmount).setParameter("em", email).executeUpdate();
			tx.commit();
			mesg="Vendor with "+ count +" registration amount successfully updated";
			System.out.println(mesg);
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteVendorDetails(double regAmount, LocalDate regDate) {
		String mesg = "cannot delete vendor..";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = " delete from Vendor v where v.regAmount < :regamt and v.regDate > :regdate";
		try {
			int count =session.createQuery(jpql).setParameter("regamt", regAmount).setParameter("regdate", regDate).executeUpdate();
			if(count == -1)
				mesg = "no such vendor exist...";
			else
				mesg = "Vendor with "+count+ " successfully deleted";
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx !=null)
				tx.rollback();
		}
		return mesg;
	}

	@Override
	public String deleteVendor(int vendorId) {
		String mesg = "cannot delete vendor..";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Vendor vendor = session.get(Vendor.class, vendorId);
			if(vendor != null)
				session.delete(vendor);
				mesg = "Vendor with"+vendorId + " removed successfully..!!";
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx !=null)
				tx.rollback();
		}
		return mesg;
	}

	@Override
	public Vendor getVendorDetails(int vendorId) {
		Vendor vendor = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			vendor = session.get(Vendor.class, vendorId);
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx !=null)
				tx.rollback();
		}
		return vendor;
	}

	@Override
	public List<Vendor> getAllVendorDetails() {
		List<Vendor> vendor = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select v from Vendor v";
		try {
			
			vendor = session.createQuery(jpql, Vendor.class).getResultList();
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx !=null)
				tx.rollback();
		}
		return vendor;
	}	

}
