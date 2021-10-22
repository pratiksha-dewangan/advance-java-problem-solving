package dao;

import java.time.LocalDate;

import pojos.Vendor;

public interface IVendorDao {
	//1.Register new Vendor
	String addVendor(Vendor vendor);
	
	//2. Login via id
	Vendor findVendorDetailsById(int vendorId);
	
	//3. Vendor Login via email--I/P email , password
	Vendor vendorLogin(String email);
	
	//4. Update vendor's reg amount --I/P : email , reg amount offset --O/P a message indicating success or failure
	String UpdateRegistrationAmount(String email, double regAmount);
	 
	//5. Delete all vendor details whose reg amount < specified amount & registered after specific date.
    //I/P : reg amount n reg date ---O/P a message indicating success or failure.
	String deleteVendorDetails(double regAmount, LocalDate regDate);
	
}
