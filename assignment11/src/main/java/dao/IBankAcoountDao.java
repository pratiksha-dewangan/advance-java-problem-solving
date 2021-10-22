package dao;

import pojos.AcctType;
import pojos.BankAccount;

public interface IBankAcoountDao {

	String addBankAcoount(BankAccount bankaccnt , AcctType accntype);
	
	
	/*		// get session
		Session session=getSf().getCurrentSession();
		//begin tx
		Transaction tx=session.beginTransaction();
		try {
			
			tx.commit();
		}
		catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}*/
}
