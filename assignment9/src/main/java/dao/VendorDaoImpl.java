package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pojos.Vendor;

public class VendorDaoImpl implements IVendorDao{

	@Override
	public String addVendor(Vendor vendor) {
		String mesg = "Vendor added..";
		Session session = getFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			Serializable id = session.save(vendor);
			System.out.println("Committed...!!");
			System.out.println(id);
			tx.commit();
			
			mesg = "vendor added with vendor id"+id;
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
		Session session = getFactory().openSession();
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

}
