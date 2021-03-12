package main;

import java.util.ArrayList;
import java.util.Scanner;

import vcmd_exceptions.CommandDoesNotExistException;
import vcmd_exceptions.WrongCommandException;

/**
 * Class for Virtual CMD
 * @author vishnu.jangid_metacu
 *
 */
public class VirtualCMD {
	
	/**
	 * Method to start Virtual CMD
	 */
	public void start(){
		
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		DirectoryTree directoryTree = new DirectoryTree();
		while(flag){
			System.out.print(directoryTree.getRoute());
			String command = scanner.nextLine();
			String[] tokens = command.split(" ");
			try{
				if(tokens.length==0 || tokens.length == 3){
					throw new WrongCommandException("Wrong Command");
				}
				switch (tokens[0].toLowerCase()) {
				case "mkdir": if(tokens.length == 1){
								throw new WrongCommandException("Wrong Command");
							}
				              directoryTree.makeDirectory(tokens[1]);
					        break;
				case "cd": 	if(tokens.length == 1){
					 			throw new WrongCommandException("Wrong Command");
							}
				  				directoryTree.changeDirectory(tokens[1]);
							break;	 
				case "find":  if(tokens.length == 1){
		 						throw new WrongCommandException("Wrong Command");
							}
				            ArrayList<String> resultDirectories = directoryTree.find(tokens[1]);
				            for(String path : resultDirectories){
				            	System.out.println(path);
				            }
							break;	
							
				case "bk":	if(tokens.length == 2){
								throw new WrongCommandException("Wrong Command");
							}
							directoryTree.back();
					  		break;
					  		
				case "ls":  if(tokens.length == 2){
								throw new WrongCommandException("Wrong Command");
							}
					        ArrayList<Directory> subDirectories = directoryTree.listFolders();  
							for(Directory directory: subDirectories){
				            	System.out.println(directory.getName() + "  " + directory.getTimeCreated());
				            }	 
							System.out.println(subDirectories.size() + "  Folder<s>");
							break;
				case "tree": if(tokens.length == 2){
								throw new WrongCommandException("Wrong Command");
							}
							Directory headDirectory = directoryTree.getRoot();
				 			printTree(headDirectory,0);
				  			break;
				case "exit" :if(tokens.length == 2){
								throw new WrongCommandException("Wrong Command");
							}
				 			System.out.print("\nAre you sure you want to exit ( y for yes, Other Key for no) :  ");
				 			String confirmation = scanner.nextLine();
				 			if(confirmation.toLowerCase().equals("y")){
				 				flag = false;	
				 				System.out.print("\nExited.......");
				 			}
				           	break;
					          
	
				default:  System.out.println("Command Not Found");
					break;
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			System.out.print("\n");
		}
	}
	
	/**
	 * Method to print directory tree
	 * @param headDirectory Directory, head Directory
	 * @param level int, level or depth
	 */
	public void printTree(Directory headDirectory,int level){
		if(level!=0){
			System.out.print("|");
		}
		for(int spaceNo = 1 ; spaceNo <= (level-1)*3 ;spaceNo++){
			System.out.print(" ");
		}
		if(level!=0){
			System.out.print("---");
		}
		System.out.println(headDirectory.getName());
		if(headDirectory.subDirectories.size()>0){
			if(level!=0){
				System.out.print("|");
			}
			for(int spaceNo = 1 ; spaceNo <= (level)*3 ;spaceNo++){
				System.out.print(" ");
			}
			System.out.println("|");
			for(Directory subDirectory : headDirectory.subDirectories){
				printTree(subDirectory, level+1);
			}
		}
	}
}
