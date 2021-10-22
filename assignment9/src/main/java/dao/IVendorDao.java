package dao;

import java.util.ArrayList;

import pojos.Vendor;

public interface IVendorDao {
	/*2.5 Get all vendor details

2.6 Update reg amount */
	String addVendor(Vendor vendor);
	Vendor findVendorDetailsById(int vendorId);
	//ArrayList<Vendor> getAllVendorDetails();
//	double updateRegistrationAmt(double regAmt);
}
