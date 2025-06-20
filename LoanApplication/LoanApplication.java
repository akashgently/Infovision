package LoanApplication;

public class LoanApplication  {
	
	private int applicantId;
	private String applicantName;
	private double loanAmount;
	private String loanStatus;
	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public String getApplicantName() {
		return applicantName;
	}
	@Override
	public String toString() {
		return "LoanApplication [applicantId=" + applicantId + ", applicantName=" + applicantName + ", loanAmount="
				+ loanAmount + ", loanStatus=" + loanStatus + "]";
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public LoanApplication(int applicantId, String applicantName, double loanAmount, String loanStatus) {
		super();
		this.applicantId = applicantId;
		this.applicantName = applicantName;
		this
		.loanAmount = loanAmount;
		this.loanStatus = loanStatus;
	}

}
