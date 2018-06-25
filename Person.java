package employees;



public class Person
{

	private String firstName;	//stores first name
	private String lastName;	//stores last name
	public Person ()		//default constructor
	{
		firstName = "";
		lastName = "";
	}	//constructor with parameters
	
	public Person (String first, String last)
	{
		setName( first, last);
	}	//method to output the first name and last name
	public String toString()
	{
		return(firstName + " " + lastName);
	}	//set firstName and lastName
	
	public void setName(String first, String last)
	{
		firstName = first;
		lastName = last;		
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}//class

