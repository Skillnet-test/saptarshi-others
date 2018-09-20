package com.infrastructure.util;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.conn.util.InetAddressUtils;


/**
 *<h1> CsvFileToJsonObject</h1>
 * Read Input from Console,
 * Convert to Csv File,
 * Write Csv File to respective location
 * @author Chittaranjan Ray
 *
 */
public class ConsoleInputToCsv {
	private static final Logger LOGGER = Logger.getLogger(ConsoleInputToCsv.class.getName());
	private  final String  CONSOLE_CSV_FILE = "D:\\Records\\consoleRecord.csv";

	/**
	 * @return the cONSOLE_CSV_FILE
	 */
	public String getCONSOLE_CSV_FILE() {
		return CONSOLE_CSV_FILE;
	}
	
	
	/**
	 * Read input from Console 
	 * Convert Console input  to CSV File
	 * Write it to File
	 *
	 */

	public void convConsoleInputToCsv (){	
		try {
			/**
			 * 		Read input from Console 
			 *  
			 */
				BufferedReader cosoleBufRd = null;
				cosoleBufRd = new BufferedReader(new InputStreamReader(System.in));
				StringBuilder buffer = new StringBuilder();
			
			/**
			 *  Convert input console to CSV format
			 */
				LOGGER.info("enter into convConsoleInputToCsv ()");
				LOGGER.info("Please provide Record details \n");
				String[] header = { "endpointName", "segmentName", "customer", "adminAddr", "vmUuid", "releaseTrain", "policyName", "desiredChefBootstrap" };
				int hdrLngth = header.length;
				String[] value = new String[hdrLngth] ;
				
			       for (int i = 0; i < hdrLngth; i++ ) {
			        	System.out.print(header[i] + ":");
						value[i] = cosoleBufRd.readLine();
		
			            if ((value[i] == null) || value[i].isEmpty()){
			            	LOGGER.info("missing entry for " + header[i] );
			            	LOGGER.info("Please put valid String ");
			            	i--;
			            }
			            
			            if (header[i] ==  "adminAddr"){
			            	boolean flag = InetAddressUtils.isIPv4Address(value[i]);			            	
			            	if (flag == false){
			            		LOGGER.info("Invalid Ip " + header[i] );
			            		LOGGER.info("Please put IP address ");
			            		i--;
			            	}
			            }
			            if (header[i] ==  "desiredChefBootstrap"){
			            	if (value[i].matches("true") || value[i].matches("false")){
			            		i++;
			            	}
			            	else {
			            		LOGGER.info("Please put value in boolean for  " + header[i] );
			            		i--;
			            	}
			            		
			            }
			            
			            
			       }
			       
			        for ( int j = 0; j < hdrLngth; j++){
			        	buffer.append(header[j]);
			        	if (j != hdrLngth - 1 ){
			        		buffer.append(",");
			        	}
			        }
			        
			        buffer.append('\n');
			        
			        for ( int k = 0; k < header.length; k++){
			        	buffer.append(value[k]);
			        	if (k != header.length - 1 ){
			        		buffer.append(",");
			        	}
			        }
			     	        
			    //    cosoleBufRd.close();
			        
			        LOGGER.info("Console input Record :");
			        LOGGER.info(buffer.toString());

			        
			       /**
			        *  Create CSV File and write to the File
			        */
			        LOGGER.info("Write CSV FIle ");
			        String csvFile = this.getCONSOLE_CSV_FILE();
			        FileWriter file = new FileWriter(csvFile);
			        PrintWriter pw = new PrintWriter(file);
			        pw.write(buffer.toString());
			        pw.close(); 
			        LOGGER.info("exit convConsoleInputToCsv ()");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "an exception was thrown", e);
			e.printStackTrace();
		}
		
	}



}

