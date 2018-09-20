package com.infrastructure.util;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.apache.http.conn.util.InetAddressUtils;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class ValidateCsvFile {
	private static final Logger LOGGER = Logger.getLogger( ValidateCsvFile.class.getName() );
	private  final String  INPUT_RECORD_CSV_FILE = "D:\\Records\\InputCsvRecords.csv";
	private  final String  VALID_RECORD_CSV_FILE = "D:\\Records\\ValidCsvRecords.csv";
	/**
	 * @return the iNPUT_RECORD_CSV_FILE
	 */
	public String getINPUT_RECORD_CSV_FILE() {
		return INPUT_RECORD_CSV_FILE;
	}
	/**
	 * @return the vALID_RECORD_CSV_FILE
	 */
	public String getVALID_RECORD_CSV_FILE() {
		return VALID_RECORD_CSV_FILE;
	}
	
	/**
	 * Read Input from Csv File
	 * validate Csv File
	 * discarded invalid Records ( missing entries and invalid ip address )
	 */
	public void getValidRecordsCsv (){
		try {
			/**
			 * Read input from Csv File
			 */
				LOGGER.info("Enter getValidRecordsCsv ()");
				String inputCsvFilename = this.getINPUT_RECORD_CSV_FILE();
				String validRecordCsvFile = this.getVALID_RECORD_CSV_FILE();
						
				String[] row = null;
				List<String[]> validRecords = new ArrayList<String[]>();
				List<String[]> discardedRecords = new ArrayList<String[]>();
				
				String[] header = { "endpointName", "segmentName", "customer", "adminAddr", "vmUuid", "releaseTrain", "policyName", "desiredChefBootstrap" };
				discardedRecords.add(header);
				
				/**
				 * Validate Csv File
				 */
				boolean flag ;
				boolean ipFlag = false;
				CSVReader csvReader = new CSVReader(new FileReader(inputCsvFilename));
				for (int indexRow = 0;(row = csvReader.readNext()) != null; indexRow++)   {
					flag = true;
					/**
					 * Validate missing entries
					 */
					for (String arr : row){
						if ( arr.equals(null) || arr.isEmpty()){
							flag = false;
							break;	
						}
					}
					/**
					 * Validate IP address
					 */
					for (String arr1 : row){	
						if (arr1.matches("^\\d+\\.\\d+\\.\\d+\\.\\d+$")) {
							String ip = arr1;
							ipFlag = InetAddressUtils.isIPv4Address(ip);
							break;
						}

					}
						
					if (flag == true && ipFlag == true)
						validRecords.add(row);
					if ( flag == false || ipFlag == false )
						discardedRecords.add(row);
				}		
				
				LOGGER.info("Valid Record :");
				for (String[] arr : validRecords) {
					LOGGER.info(Arrays.toString(arr));
			    }
				
				LOGGER.info("Invalid Record :");
			    for (String[] arr : discardedRecords) {
			    	LOGGER.info(Arrays.toString(arr));
				}
				
				csvReader.close();
				
				/**
				 * Write Validate CSV File
				 */
				CSVWriter writer = new CSVWriter(new FileWriter(validRecordCsvFile));
				writer.writeNext(header);
				writer.writeAll(validRecords);

				writer.close();
				
				LOGGER.info("Exit getValidRecordsCsv ()");
				
		} catch (IOException e){
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
