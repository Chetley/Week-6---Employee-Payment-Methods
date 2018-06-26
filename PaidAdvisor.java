package employees;

import java.util.Scanner;

public class PaidAdvisor extends Person {

		private final float regularPayRate = 25;
		private final float specialPayRate = 50;
		private final int regular_weekly_hours = 30;
		private double overtimePayRate = (1.5 * regularPayRate);
		
		private double hoursWorked;
		private double overtime_hours_worked;
		private double special_session_overage;	//if an employee works more than 30 hours but not all hours worked are special session
		private double RegularPayOut;
		private double SpecialSessionPayout;
		private double OvertimePayout;
		private int specialSession;
		private double hoursSpecial;
//		double overtime_rate_after_special;
		private double just_overtime;
		private double Overtime_with_special;

		public PaidAdvisor(double p_hoursWorked)
		{
			set_HoursWorked(p_hoursWorked);
			set_RegularPayOut(p_hoursWorked);
			set_SpecialSessionPayout();
			
		}
		public PaidAdvisor(String p_first, String p_last,double p_hoursWorked)
		{
            super (p_first, p_last);
            set_HoursWorked(p_hoursWorked);
			set_RegularPayOut(p_hoursWorked);
			set_SpecialSessionPayout();
			
		}		
		
		public void set_HoursWorked(double p_hoursWorked)
		{
			hoursWorked = p_hoursWorked;
		}
		public double get_hoursWorked()
		{
			return hoursWorked;
		}
		
		//setter & getter regular pay out
		public void set_RegularPayOut(double p_hoursWorked)
		{
			if (get_hoursWorked() <= 30)
			{
				RegularPayOut = (get_hoursWorked () * regularPayRate);
			}
			else
			{
				RegularPayOut = regular_weekly_hours * regularPayRate;
			}
		}
		public double get_RegularPayOut()
		{
			return RegularPayOut;
		}
		
		//setters & getters for special hours & special session pay out(step (e))
		
		public void set_HoursSpecial(double p_hoursSpecial)
		{
			hoursSpecial = hoursSpecial + p_hoursSpecial;
			if ((hoursWorked - (hoursWorked - regular_weekly_hours - hoursSpecial)) > 0)
		 	{
//		 		special_session_overage = ();
		 		set_Special_session_overage(hoursWorked - regular_weekly_hours - hoursSpecial);
		 	}
		
		}
		public double get_HoursSpecial()
		{
			return hoursSpecial;
		}
		
		public void set_Special_session_overage(double p_special_session_overage)
		{
			special_session_overage = p_special_session_overage;
		}		
		public double get_Special_session_overage()
		{
			return special_session_overage;
		}
		
		
		public void set_specialSession(int p_specialSession)
		{
			specialSession = p_specialSession;
		}
		public double get_specialSession()
		{
			return specialSession;
		}
		
		
		public void set_SpecialSessionPayout()
		{
		if (hoursWorked > 30 && specialSession == 1)
		{
			SpecialSessionPayout = (((hoursWorked - hoursSpecial) 
					                * regularPayRate) + 
					                 (hoursSpecial * specialPayRate));
		}
		}
		public double get_SpecialSessionPayout()
		{
		return SpecialSessionPayout;	
		}
		
		//setter & getter for overtime
		public void set_OvertimeHours(double p_overtime_hours)
		{
			if (special_session_overage > 0)
			{
				overtime_hours_worked = p_overtime_hours + special_session_overage;
			}//if
			else
			{
				overtime_hours_worked = p_overtime_hours;
			}//else
		}//setter
		public double get_OvertimeHours()
		{
			return overtime_hours_worked;
		}
//		public void set_OvertimePayrate()
//		{
//			overtimePayRate = (1.5 * regularPayRate);
//		}
//		public double get_OvertimePayRate()
//		{
//			return overtimePayRate;
//		}
		public void set_OvertimePayout()
		{
			if (hoursWorked > regular_weekly_hours && specialSession ==2)
			OvertimePayout= (overtime_hours_worked * overtimePayRate);
		}
			
		public double get_OvertimePayout ()
		{
			return OvertimePayout;
		}
		
		
		//just overtime & regular, no special sesh
		public void set_Just_Overtime(double p_overtime_hours, double p_regular_hours)
		{
			just_overtime = ((p_overtime_hours * overtimePayRate) + (p_regular_hours * regularPayRate));
		}
		public double get_Just_Overtime()
		{
			return just_overtime;
		}
		
		
		//if overtime & special sesh
		public void set_Overtime_with_special()
		{
			if (special_session_overage > 0)
			{
				Overtime_with_special = ((hoursSpecial * specialPayRate) 
                                       + (special_session_overage * overtimePayRate)
                                       + (RegularPayOut));
			}
			else
			{
				Overtime_with_special = 0;
			}
		}
		public double get_Overtime_with_special()
		{
			return Overtime_with_special;
		}
		
		public String toString()
		{
			String result = super.toString();
			result += "\nJob title: Research Consultant"; //per assignment
			
			if (get_hoursWorked () < regular_weekly_hours)
			{
				result += "\nRegular hours worked: " + get_hoursWorked();
				result += "\nRegular pay rate = $" + regularPayRate + " per hour";
				
				result += "\n\nTotal wages paid = $" +  get_RegularPayOut();
			}
			if (get_hoursWorked () == regular_weekly_hours)
			{
				result += "\nRegular hours worked: " + regular_weekly_hours;
				result += "\nRegular pay rate = $" + regularPayRate + " per hour";
				
				result += "\n\nTotal wages paid = $" +  get_RegularPayOut();
			}
			
//			result += "\nOvertime hours worked: " + overtime_hours_worked;
//			result += "\nSpecial hours worked: " + hoursSpecial;
			
			else if (get_hoursWorked () > regular_weekly_hours)
			{
				if (specialSession == 1 && get_Special_session_overage() > 0)
				{ 
					result += "\nSpecial Session Hours = " + get_HoursSpecial();
					result += "\nSpecial Session pay rate = $" + specialPayRate + " per hour";
					result += "\nOvertime hours after special session = " + get_Special_session_overage();
					result += "\nOvertime pay rate = $" + overtimePayRate + " per hour";
		 
					result += "\n\nTotal wages paid (with special session and overtime) = $" + get_Overtime_with_special();
				}//special session overage
				else if (specialSession == 1 && get_Special_session_overage() == 0)
				{
					result += "\nRegular hours worked: " + regular_weekly_hours;
					result += "\nRegular pay rate = $" + regularPayRate + " per hour";
					result += "\nSpecial Session Hours = " + get_HoursSpecial();
					result += "\nSpecial Session pay rate = $" + specialPayRate + " per hour";
					result += "\nOvertime hours = " + get_OvertimeHours();
				
					if (get_HoursSpecial() >0)
					{
						result += "\n\nTotal wages paid (with special session) = $" + get_SpecialSessionPayout();
					}//hours special
				 
				}//else
			 
				else if (specialSession ==2)
				{
//					result += "\nEmployee worked " + get_OvertimeHours() +  " hours overtime, " + get_hoursWorked() + " hours total";
					result += "\nRegular hours worked: " + regular_weekly_hours;
					result += "\nRegular pay rate = $" + regularPayRate + " per hour";
					result += "\nOvertime hours = " + get_OvertimeHours();
					result += "\nOvertime pay rate = $" + overtimePayRate + " per hour";
//		 	}	 //special session null
//			 if (get_hoursWorked() > 30 && specialSession==2)
//			 {
					result += "\n\nTotal wages paid (with overtime) = $" + get_Just_Overtime();
				}
			
			}//if worked hours more than 30
			 
			return result;
		}//TO STRING
			 
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//class


