package com.infrastructure.util;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * <h1>CmsManagingSystemUtilApp</h1>
 * CmsManagingSystemUtil  is a  utility to provide the solutions to
 * add or update of Records to Master Json file(Which represents  the infrastructure systems )
 * 
 * @input 
 * Master Json File
 * CSV File
 * 
 * @usage
 * 
 * Read input from console
 * 
 * 0 for Add Individual Record From Console \n
 * 1 for Update Individual Record From Console \n
 *
 * 2 for Add Multiple Records From Input Csv File  \n 	
 * 3 for Update Multiple Records From Csv File \n  
 * 
 * other Integer value for Quit \n
 *
 *
 * 
 *@author Chittaranjan Ray
 *
 */

public class CmsManagingSystemUtilApp {
	private static final Logger LOGGER = Logger.getLogger(CmsManagingSystemUtilApp.class.getName());
	
	private static CmsManagingSystemUtil cmsUtil = new CmsManagingSystemUtil();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
// Read from console
		Scanner console = new Scanner(System.in);
      	Service(console);
      	LOGGER.info("Test is done");
      	console.close();
      	}
      	
  
						  
  /**
   *     	
   * @param console
   */

		
		public static void Service(Scanner console) {

	      	LOGGER.info("  Type 0 for Add Individual Record From Console \n 	Type 1 for Update Individual Record From Console \n	Type 2 for Add Multiple Records From Input Csv File  \n 	Type 3 for Update Multiple Records From Csv File \n  	Type 5 for Quit ");
	      	LOGGER.info("Please input for service ");
	      	
	      	boolean flag = console.hasNextInt();
	      	LOGGER.info("flag = " + flag);
	      	int input ;
	      		try {
	      			//Read from console for next Interger
				    while(console.hasNextInt()){
				      	LOGGER.info("  Type 0 for Add Individual Record From Console \n 	Type 1 for Update Individual Record From Console \n	Type 2 for Add Multiple Records From Input Csv File  \n 	Type 3 for Update Multiple Records From Csv File \n  	Type 5 for Quit ");
				      	LOGGER.info("Please input for service ");
				    	
				    	input = console.nextInt();
				        LOGGER.info("input = " + input);
					       switch(input){
					        case 0:
					        	//Add Individual Record From Console
					        		LOGGER.info("Add Individual Record From Console ");
					        		cmsUtil.addRecrodFromConsole();
					        		break;
					        	
					        case 1:
					        	//Update Individual Record From Console
					        		LOGGER.info("Update Individual Record From Console");
					        		cmsUtil.updateRecordFromConsole();
					        		break;
					        case 2:
					        	//Add Multiple Records From Input Csv File
					        		LOGGER.info("Add Multiple Records From Input Csv File");
					        		cmsUtil.addRecordsFromCsvFile();
					        		break;
					        case 3:
					        	//Update Multiple Records From Csv File
					              	LOGGER.info("Update Multiple Records From Csv File");
					              	cmsUtil.updateRecordsFromCsvFile();
					              	break;	            
					        default:
					        		LOGGER.info("No such choice");
					        		LOGGER.info("exit");
					        		System.exit(5);
		
					       }
				

				    }
	      		}catch (InputMismatchException e ){
	      			e.printStackTrace();
	      			LOGGER.info("an exception was thrown" + e);
	      		}

		}
}
		  


