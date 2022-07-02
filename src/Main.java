package com.company;
import java.util.Scanner;
import java.util.Arrays;


public class Main {
	

   
	public static void main(String[] args) {



	    
	    LibraryOperation l2 = new LibraryOperation();
	    
	    int j=0;
	    
	    do{
			System.out.println("Menu");
			System.out.println("1. adding books");
			System.out.println("2. adding members");
			System.out.println("3. borrow books");
			System.out.println("4. return books");
			System.out.println("5. search books");
			System.out.println("6. search members");
			System.out.println("7. delete a member");
			System.out.println("8. delete a book copy");
			System.out.println("enter your choice please: ");
			
			Scanner scanner1=new Scanner(System.in);
	    	j = scanner1.nextInt();
	    	
	    	switch(j)
	    	{
	    	case 1 :
	    		l2.booksArray();        // for adding books
	    		break;
	    	case 2 :
	    		l2.membersArray();      // for adding members
	    		break;
	    	case 3 :
	    		l2.borrowedBooks();
	    		break;
	    	case 4 :
	    		l2.returnBooks();
	    		break;
	    	case 5 :
	    		l2.searchingBooks();
	    		break;
	    	case 6 :
	    		l2.searchingMembers();
	    		break;
	    	case 7 :
	    		l2.deleteMember();
	    		break;
	    	case 8 :
	    		l2.deleteCopyOfBook();
	    		break;
	    	default :
	    		System.out.println("invalid choice");
	    		
	    	
	    	}	
	    
	    }while( j>0 && j<9 ); 
	    
		
	 
    }

}