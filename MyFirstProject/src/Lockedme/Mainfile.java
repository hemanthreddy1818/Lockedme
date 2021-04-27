package Lockedme;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;



public class Mainfile {

	String directory;
	File file_folder;
	public Mainfile() {

		 directory=System.getProperty("user.dir");
	 file_folder=new File(directory+"\\files");
		System.out.println(file_folder.getAbsolutePath());
	}

public void firstmain() throws IOException {
	System.out.println(Menuprompt);
	Scanner sc=new Scanner(System.in);
	int name=sc.nextInt();
   switch (name) {
   case 1:
	   showFiles();
	  
	 
   case 2:
	   secondaryMenu();
	   break;
   case 3: 
	   System.out.println("Thank You");
       System.exit(0);
   
   default:
showFiles();
   }
}








	private void secondaryMenu() throws IOException {
	System.out.println(SECONDARY_MENU_PROMPT);
	Scanner sm=new Scanner(System.in);
	char c=sm.next().charAt(0);
	switch(c) {
	case 'a': 
		System.out.println("please enter a file name :");
		Scanner adfile=new Scanner(System.in);
		String file=adfile.nextLine().trim().toLowerCase();
		addfile(file);
		
		break;
	
	
	case 'b':
	System.out.println("please enter the delete file name");
	Scanner sc=new Scanner(System.in);
	String filename=sc.nextLine();
	delete(filename);
	break;
	
	case 'c':
		System.out.println("please enter the file name");
   Scanner sch=new Scanner(System.in);
   String searchfile=sch.nextLine();
    Search(searchfile);
break;
	case 'd':
	System.out.println( Menuprompt);
	break;
	
	default :
		System.out.println("your entered digit is invalid ");
	}
	firstmain();
	}
	
	

	private void Search(String filename) {
		String [] file=file_folder.list();
		for(String s:file) {
			if(filename.equals(s)) {
				System.out.println(filename);
				return;
				}
			}
		System.out.println(filename+" is not there");
	}

	private void addfile(String file) throws IOException {
		 file_folder=new File(directory+"\\files");
		 File filepath=new File(file_folder+"/"+file);

		 String [] list=file_folder.list();
		 
		 for(String s:list) {
			 if(file.equalsIgnoreCase(s)) {
				 System.out.println(s);
	                System.out.println("File " + file + "  already exists at " + file_folder);
                return;
			 }
		 }
		 filepath.createNewFile();
		 System.out.println("file " +file+"is added to " +filepath);
		  
		}
    private void delete(String filename) {
        File filepath = new File(file_folder+"/"+filename);

				String [] list=file_folder.list();
				for(String s:list) {
					if(filename.equals(s) &&filepath.delete()) {
						System.out.println(filename+ " is deleted" + " sucessfully !");
						return;
					}
					}
				System.out.println("file is not found");
}

	private void showFiles() {
		 file_folder=new File(directory+"\\files");
		 if(file_folder.list().length==0 ) {
			 System.out.println("file is empty");
		 }
		  String[] list = file_folder.list();
		  for(String s:list) {
			  System.out.println(s);
		  }
		}
	

public static String mainprompt=  "*****************Locked Me**************" +
	"\n***************Hemanth Reddy***************\n";
	
	  private static final String SECONDARY_MENU_PROMPT =
	            "   \nSelect any of the following: \n"+
	                    "   a -> Add a file\n"+
	                    "   b -> Delete a file\n"+
	                    "   c -> Search a file\n"+
	                    "   d -> GoBack";

	public static String Menuprompt="welcome to main menu : "
			+ "\n 1 -> List files in directory "
			+ "\n 2 -> Add , Delete ,Search "
			+"\n 3-> Exit program \n";
	
	public static void main(String[] args) throws IOException {
		System.out.println(mainprompt);

		Mainfile mf=new Mainfile();
		mf.firstmain();

	}

}
