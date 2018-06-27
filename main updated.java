package employees;

import java.util.Scanner;

public class main extends Person{


	public static void main(String[] args) {

		int l_specialSession;
		int l_hoursSpecial;
		double l_hoursworked;
		double l_special_session_overage;
		double l_regular_weekly_hours = 30;
		String l_firstname;
		String l_lastname;
		
		PaidAdvisor [] employees;
		employees = new PaidAdvisor[20];
			
		System.out.println("Employee first name: ");
		Scanner scan = new Scanner(System.in);
		l_firstname = scan.nextLine();
		
		System.out.println("Employee last name: ");
		l_lastname = scan.nextLine();
		

		
		System.out.println("How many hours did employee work this week?");
		 l_hoursworked = scan.nextInt();
		 
		 employees[10] = new PaidAdvisor(l_firstname, l_lastname, l_hoursworked);
		 
		 System.out.println("-------------------------"); //fancy

		 System.out.println("Hours worked = " + employees[10].get_hoursWorked());
		 
		 
		 //regular
		 if (l_hoursworked <= 30)
		 {
			 System.out.println("-------------------------"); //fancy
//			 employees[10].get_RegularPayOut();//debug1
			 System.out.println("Employee name: " + employees[10].toString());

			 System.out.println("-------------------------"); //fancy
		 }//regular
		 
		 //overtime
		
		 if (l_hoursworked > 30)
		 {
			 System.out.println("-------------------------"); //fancy
			 System.out.println("Did employee work for a special session?\nPress 1 for yes\nPress 2 for no");
			 l_specialSession = scan.nextInt();
			 while (l_specialSession > 2)
			 {
				 System.out.println("Error! Please select 1 for yes, or 2 for no");
				 l_specialSession = scan.nextInt();
			 }
			 
		     
			 //special
			 if (l_specialSession == 1)
		 	 {
				 System.out.println("How many hours did employee work for a special session?");
				 
				 l_hoursSpecial = scan.nextInt();
				 
				 while (l_hoursSpecial > (employees[10].get_hoursWorked() - l_regular_weekly_hours))
				 {
					 System.out.println("Error! Special hours cannot replace regular weekly hours,\nplease resubmit");
					 l_hoursSpecial = scan.nextInt();
				 }
				 
				 employees[10].set_specialSession (l_specialSession);
				 
				 employees[10].set_HoursSpecial (l_hoursSpecial);
				 
				 System.out.println("-------------------------"); //fancy
				 
					 
				 if (employees[10].get_Special_session_overage() > 0)
				 {
					 employees[10].set_Overtime_with_special();
				 }
				 else
				 {
					 employees[10].set_SpecialSessionPayout();
				 }//else
		 
		 	}//special
		 	
		 System.out.println("-------------------------"); //fancy
		 	
		 	if (l_specialSession ==2)
		 	{
		 		employees[10].set_specialSession (l_specialSession);
		 		employees[10].set_HoursWorked(l_hoursworked);
		 		employees[10].set_OvertimeHours (l_hoursworked - 30);
		 			
		 		 	
		 		employees[10].set_Just_Overtime(employees[10].get_OvertimeHours(), l_regular_weekly_hours );
		
		 		
		 	}//if

			System.out.println("Employee name: " + employees[10].toString());
			
		 System.out.println("-------------------------"); //fancy	
		 	
		 	
		 	
		 	
		 }//overtime
//		
		
		
		
		
		
	}//main

}//package
