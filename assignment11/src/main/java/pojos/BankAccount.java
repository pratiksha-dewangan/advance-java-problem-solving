package pojos;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "bankaccnt_tbl")
public class BankAccount extends BaseEntity{

	@Enumerated(EnumType.STRING)
	@Column
	private AcctType type;
	@Column
	private double balance;
	@Column(name = "transaction_date")
	private LocalDate transactionDate;
	
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor registeredVendor;
	
	
	public BankAccount() {
		System.out.println("In bankAccount constructor ");
	}
	
	public BankAccount(AcctType type, double balance, LocalDate transactionDate) {
		this.type = type;
		this.balance = balance;
		this.transactionDate = transactionDate;
	}

	public AcctType getType() {
		return type;
	}

	public void setType(AcctType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Vendor getRegisteredVendor() {
		return registeredVendor;
	}

	public void setRegisteredVendor(Vendor registeredVendor) {
		this.registeredVendor = registeredVendor;
	}

	@Override
	public String toString() {
		return "BankAccount [id "+getId()+"type=" + type + ", balance=" + balance + ", transactionDate=" + transactionDate + "]";
	}

	
}
