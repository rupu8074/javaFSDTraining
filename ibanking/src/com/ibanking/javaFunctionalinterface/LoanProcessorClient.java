package com.ibanking.javaFunctionalInterface;

public class LoanProcessorClient {
	public static void main(String args[]) {
		Loan loan = () -> {
			System.out.println("lamda function");
			return "lamda";
		};
		loan.createLoan();
		Loan loan1 = () -> {
			System.out.println("lamda function");
			return "lamda";
		};
		loan1.createLoan();
		LoanDAO loanDAO = new LoanDAO();
		loanPojo loanPojo = new loanPojo();
		loanPojo.setAge(12);
		loanPojo.setCustomerName("Deepali");
		loanPojo.setGender("F");
		LoanType loanType = (loanPojoObj) -> {
			if (loanPojoObj.getGender().equals("F")) {
				System.out.println("Loan accepted");
				return loanPojoObj;
			} else {
				System.out.println("Loan accepted");
				return loanPojoObj;
			}
		};
		loanDAO.createLoan(loanType, loan1);
	}
	

}
