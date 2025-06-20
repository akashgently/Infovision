package LoanApplication;

import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<LoanApplication> loanApplicants=new ArrayList<>();
	
	public void addApplicant(LoanApplication application) {	
		loanApplicants.add(application);
		System.out.println("Loan applicant added successfully");
	}
	
	public static void showAllApplications() {
		
		loanApplicants.forEach(applicant->System.out.println(applicant));
	}
	
	public static LoanApplication getApplicantById(int id) {
		
		return loanApplicants.get(id-1);
	}
	
	public static void updateStatus(int id) {
		LoanApplication applicant= getApplicantById(id);
		if(applicant.getLoanAmount()>50000) {
			applicant.setLoanStatus("Approved");
			System.out.println(applicant.getApplicantName()+ " loan status Approved");
		}
		else
		{
			System.out.println("Loan Amount is less than 50000");
		}	
	}
	
	public static  void deleteApplicant(int id) {
		loanApplicants.remove(id-1);
		System.out.println(getApplicantById(id).getApplicantName()+" Loan applicant removed");
	}
	
	public static void main(String args[])
	{
		 LoanApplication pawan=new LoanApplication(1,"Pawan", 100000, "pending");
		 LoanApplication jayaBalaji=new LoanApplication(2,"Jaya Balaji", 100000, "pending");
		 LoanApplication Jeevan=new LoanApplication(3,"Jeevan", 100000, "pending");
		 LoanApplication Akash=new LoanApplication(4,"Akash", 100000, "pending");
		 LoanApplication Shrinivas=new LoanApplication(5,"Srinivas", 100000, "pending");
		 
		 loanApplicants.add(pawan);
		 loanApplicants.add(Akash);
		 loanApplicants.add(Jeevan);
		 loanApplicants.add(jayaBalaji);
		 loanApplicants.add(Shrinivas);
		 
		 System.out.println(getApplicantById(5));
		 updateStatus(1);	
		 deleteApplicant(3);
		 showAllApplications();
		 
	}
	

}
