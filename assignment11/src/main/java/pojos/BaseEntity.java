package pojos;
import javax.persistence.*;

//to make it superclass
@MappedSuperclass
public class BaseEntity {
//4.1 Create Vendor 1<---->* BankAccount , bi directional one to many association
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//def cons - 
	public BaseEntity() {
		System.out.println("in base entity ctor");
	}

	//getter n setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
