package com.company;
import java.util.Scanner;
import java.util.Arrays;


public class LibraryOperation {
	
	public static int a =0;
	public static int b=0;
	public int x;
	public int y;


	Books books[] = new Books [100];
	ListMembers members[] = new ListMembers [100];
	String memberBookName[][] = new String[100][500];
	

	
	public void booksArray(){
		
			books[a] = addingBooks();
			a++;
	}
	
	public void membersArray(){
		
		   members[b] = addingMembers();
		    b++;
		
	}
	
	
	public Books addingBooks(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter book's name");
		Books b1 = new Books();
		
		b1.title = scanner.nextLine();
		
		System.out.println("enter author's name");
		b1.author = scanner.nextLine();
		
		System.out.println("enter date of publishing");
		b1.dateOfPublishing = scanner.nextLine();
		
		System.out.println("enter the number of copies");
		b1.numberOfCopies = scanner.nextInt();
		
			
		return b1;
	}
	
	public ListMembers addingMembers(){
		
		Scanner scanner1=new Scanner(System.in);
		ListMembers m1 = new ListMembers();
		System.out.println("enter the member name");
		m1.memberName = scanner1.nextLine();
		
		System.out.println("you have become a member");
		
		
		return m1;
	
	}
	
	public void borrowedBooks(){          // determine the available and extracted books
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("enter your name to confirm membership");
		String name = scanner2.nextLine();
		for( y=0; y<100; y++){
			if(members[y] == null){
				continue;
			
			
			}else if(members[y].memberName.equalsIgnoreCase(name)){
				System.out.println("enter the book title");
				
				
				String bookTitle = scanner2.nextLine();
				
				for( x=0; x<100; x++){ 
					
					if(books[x] == null){
						continue;
					
					
					}else if(books[x].title.equalsIgnoreCase(bookTitle)){
						
						if(books[x].numberOfCopies == 0){
							
							System.out.println("the book is not available");
							
						
						
						}else if(members[y].memberNumberOfBooks<5){         // every member can borrow at most 5 copies
							    System.out.println("NOTE : The book is only available for less than 14 days");
							    System.out.println("the book has been borrowed successfully");
								members[y].memberNumberOfBooks = members[y].memberNumberOfBooks +1;
								books[x].numberOfCopies = books[x].numberOfCopies-1;
								for(int i=0; i<members[y].memberNumberOfBooks; i++) {
								    if(memberBookName[y][i] == null) {
									memberBookName[y][i] = bookTitle; 
								}else {
									continue;
								}
								    
							}
								
							
						}else{
								System.out.println("only 5 books are allowed");
							}
						
						
					}else{
					System.out.println("invalid title");}
						
					}
						
				
			}else{
				System.out.println("invalid member name");
			}
			
		}
	}
			
	public void returnBooks(){
		Scanner scanner4 = new Scanner(System.in);
		System.out.println("enter the member name");
		String theName = scanner4.nextLine();
		for( y=0; y<100; y++){
			if(members[y] == null){
				continue;
			
			}else if(members[y].memberName.equalsIgnoreCase(theName)){
				System.out.println("enter the name of the book");
				String theNameOfBook = scanner4.nextLine();
				for( x=0; x<100; x++){
					if(books[x] == null){
						continue;
					
					}else if(books[x].title.equalsIgnoreCase(theNameOfBook)){
						members[y].memberNumberOfBooks = members[y].memberNumberOfBooks-1;
						books[x].numberOfCopies = books[x].numberOfCopies+1;
						System.out.println("the book has been returned");
					
					}else{
						System.out.print(" invalid title");
					}
				}		
			
			}else{
				System.out.println(" invalid name");}
				
		}
	}
		
  public void returnBooks1(){
     Scanner scanner4 = new Scanner(System.in);
	 System.out.println("enter the member name again to confirm");
     String name = scanner4.nextLine();
    
       for( y=0; y<100; y++){
		if(members[y] == null){
			continue;
		
		}else if(members[y].memberName.equalsIgnoreCase(name)){
			for(int i=0; i<members[y].memberNumberOfBooks; i++){
			System.out.println("enter the name of the book");
			String theNameOfBook = scanner4.nextLine();
			for( x=0; x<100; x++){
				if(books[x] == null){
					continue;
				
				}else if(books[x].title.equalsIgnoreCase(theNameOfBook)){
					members[y].memberNumberOfBooks = members[y].memberNumberOfBooks-1;
					books[x].numberOfCopies = books[x].numberOfCopies+1;
					System.out.println("the book has been returned");
				
				}else{
					System.out.println(" invalid title");
				}
			}		
		
		}
		}else{
			System.out.println(" invalid name");}	
     }
     }
    	
		
	public void searchingBooks(){           
		System.out.println("enter the book title or author name");
		Scanner scanner6 = new Scanner(System.in);
		String bookTitleOrAuthor = scanner6.nextLine();
		
		for( x=0; x<100; x++){
			
			if(books[x] == null){ 
				continue;
			
			
			}else if(books[x].title.equalsIgnoreCase(bookTitleOrAuthor) || books[x].author.equalsIgnoreCase(bookTitleOrAuthor)){
				System.out.println("the book info " + "\n" + "book title: "+books[x].title + "\n" +"book author: "+books[x].author + "\n" +"book date of publishing: " +books[x].dateOfPublishing +"\n" +"book number of copies: "+ books[x].numberOfCopies);
			
			}else{
				System.out.println("invalid book name");
			}
			
		}
		
	}
	
	public void searchingMembers(){
		
		for(y=0; y<100; y++){
			
			if(members[y] == null){
				continue;
			}
			System.out.println("member name: " + members[y].memberName + "\n"+ "number of books: "+members[y].memberNumberOfBooks );
			if(members[y].memberNumberOfBooks>0) {
			System.out.println("the names of borrowed books : ");
			
			for(int i=0; i<members[y].memberNumberOfBooks; i++) {
				
				System.out.println(memberBookName[y][i]);
				
				
			}
			}
			System.out.println();
		}	
	}
	
	
	 public static ListMembers[] removeTheElement(ListMembers[] members, int index) { // this function is used to delete members

            if (members == null|| index < 0|| index >= members.length) { 
                    return members; 
                } 
            ListMembers[] anotherArray = new ListMembers[members.length ]; 
             for (int i = 0, k = 0; i < members.length; i++) { 
                 if (i == index) { 
                      continue; 
                     } 
                    anotherArray[k++] = members[i]; 
                      } 
                   return anotherArray; 
             }
	
	
	public void deleteMember(){
		System.out.println("first you should return the borrowed books ");
		System.out.println("enter the member name");
		Scanner scanner8 = new Scanner(System.in);
		String TheNameOfTheMember = scanner8.nextLine();
		
		
		for( y=0; y<100; y++){
			if(members[y] == null){
				continue;
			
			}else if(members[y].memberName.equalsIgnoreCase(TheNameOfTheMember)){
		
			returnBooks1();
		}
		}
		for( y=0; y<99; y++){
			if(members[y] == null){
				continue;
			
			}else if(members[y].memberName.equalsIgnoreCase(TheNameOfTheMember)){
				
				 members = removeTheElement(members, y);          // function to remove the element of index y
				System.out.println("the member has been deleted");
				
				
			
			}else{
				System.out.println("invalid member name");
			}			
		}
	}
	
	public void deleteCopyOfBook(){
		
		System.out.println("enter the name of the book ");
		Scanner scanner9 = new Scanner(System.in);
		String bookname = scanner9.nextLine();
		for( x=0; x<100; x++){
			if(books[x] == null){
				continue;
			
			}else if(books[x].title.equalsIgnoreCase(bookname)){
				
				books[x].numberOfCopies = books[x].numberOfCopies-1;
				System.out.println("the copy has been deleted ");
				
			
			}else{
				System.out.println("invalid book name ");
			}
				
		}
			
	}
			
}