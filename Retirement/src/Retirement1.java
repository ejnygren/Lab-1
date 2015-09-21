import org.apache.poi.ss.formula.functions.FinanceLib;
import java.util.Scanner;
// This program will ask for the users input on different aspects of thier income and 
//return how much they will have to save
public class Retirement1 {
	public static void main(String[]args){
		//Have users input their values
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of years you plan to work: ");
		double YearsWorked = input.nextDouble();
		System.out.print("Enter your annual return percentage for investment: ");
		double AnnualReturnInvestment = (input.nextDouble() / 100);
		//While loop checks to make sure the inputted data is in the range
		while (AnnualReturnInvestment < 0 || AnnualReturnInvestment > .2) {
			System.out.print("The percentage must be within the range 0% -20%" + "\n");
			System.out.print("Enter your annual return percentage for investment: ");
			AnnualReturnInvestment = (input.nextDouble() / 100);
		}
		System.out.print("Enter the number of years you plan to be retired: ");
		double YearsRetired = input.nextDouble();
		System.out.print("Enter your required income: ");
		double RequiredIncome = input.nextDouble();
		System.out.print("Enter your Monthly SSI: ");
		double MonthlySSI = input.nextDouble();
		System.out.print("Enter your annual return percentage for payback: ");
		double AnnualReturnPayback = (input.nextDouble() / 100);
		//While loop checks to make sure the inputted data is in the range
		while (AnnualReturnPayback < 0 || AnnualReturnPayback > .03) {
			System.out.print("The percentage must be within the range 0% - 3%" + "\n");
			System.out.print("Enter your annual return percentage for payback: ");
			AnnualReturnPayback = (input.nextDouble() / 100);
		}
		double FutureValue;
		double PresentValue;
		boolean f;
		double ReturnCalc;
		double RetiredCalc;
		double PaymentCalc;
		
		double PV;
		//Calculates the present value using the FinanceLib equation
		ReturnCalc = (AnnualReturnPayback/12);
		RetiredCalc = (YearsRetired * 12);
		PaymentCalc = (RequiredIncome - MonthlySSI);
		FutureValue = 0;
		f = false;
		
		PV = FinanceLib.pv(ReturnCalc,RetiredCalc,PaymentCalc,FutureValue,f);
		//Prints answer
		System.out.println(PV);
		
		double PMT;
		// Calculates the payment time value using the FinanceLib equation
		ReturnCalc = (AnnualReturnInvestment/12);
		RetiredCalc = (YearsWorked * 12);
		PresentValue = 0;
		FutureValue = PV;
		f = false;
		
		PMT = FinanceLib.pmt(ReturnCalc,RetiredCalc,PresentValue,FutureValue,f);
		//Prints answer
		System.out.println(PMT);
				

      }
}