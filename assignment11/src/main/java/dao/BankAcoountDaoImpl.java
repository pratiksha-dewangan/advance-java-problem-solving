package dao;
import static utils.HibernateUtils.getFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.AcctType;
import pojos.BankAccount;

public class BankAcoountDaoImpl implements IBankAcoountDao{

	@Override
	public String addBankAcoount(BankAccount bankaccnt, AcctType accntype) {
				// get session
				Session session= getFactory().getCurrentSession();
				//begin tx
				Transaction tx=session.beginTransaction();
				String mesg =" ";
				try {
					
					tx.commit();
				}
				catch (RuntimeException e) {
					if(tx != null)
						tx.rollback();
					throw e;
	}

}
