package com.infrastructure.util;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * <h1>CmsManagingSystemUtil</h1>
 * CmsManagingSystemUtil  is a  utility to provide the solutions to  
 * add or update of Records to Master Json file(Which represents  the infrastructure systems )
 * 
 * @author Chittaranjan Ray
 *
 */
public class CmsManagingSystemUtil {
	private static final Logger LOGGER = Logger.getLogger( CmsManagingSystemUtil.class.getName() );
	private  final String  INPUT_RECORD_CSV_FILE = "D:\\Records\\ValidCsvRecords.csv";
	private  final String  CONSOLE_CSV_FILE = "D:\\Records\\consoleRecord.csv";
	
	ConsoleInputToCsv cnslCsv = new ConsoleInputToCsv();
	CsvFileToJsonObject csvJson = new CsvFileToJsonObject();
	MasterJsonFileToJsonObject mJson = new MasterJsonFileToJsonObject();
	AddUpdateRecordsToMasterJsonFile addUpdRcds = new AddUpdateRecordsToMasterJsonFile();
	ValidateCsvFile validateCsv = new ValidateCsvFile();
	
	String consoleCsvFile = this.getCONSOLE_CSV_FILE();
	String inputCsvFilename = this.getINPUT_RECORD_CSV_FILE();
	

	/**
	 * @return the iNPUT_RECORD_CSV_FILE
	 */
	public String getINPUT_RECORD_CSV_FILE() {
		return INPUT_RECORD_CSV_FILE;
	}

	/**
	 * @return the cONSOLE_CSV_FILE
	 */
	public String getCONSOLE_CSV_FILE() {
		return CONSOLE_CSV_FILE;
	}	
	
	public void addRecrodFromConsole() {
	try {			
			//Input Record from console 
			cnslCsv.convConsoleInputToCsv();
		
			//collect  Master JsonObject from Master Json File
			JSONObject mJsonObject = mJson.convrtMasterJsonFileToJsonObject();
			
			//collect record JsonObject from CSV File 
			JSONArray endpoints = csvJson.convrtCsvFileToJsonObject(consoleCsvFile);
			LOGGER.info("JSONArray :");
			for(int index = 0; index < endpoints.length(); index++  ){	
				
				JSONObject endpointName = endpoints.getJSONObject(index);
				LOGGER.info(endpointName.toString(endpoints.length()));	
				addUpdRcds.addRecordsToMasterJsonFile(mJsonObject, endpointName);
			}	
					
			
		}catch (JSONException e) {
			LOGGER.log(Level.SEVERE, "an exception was thrown", e);
		e.printStackTrace();
		}

	}
	
	public void updateRecordFromConsole(){
		try {			
			//Input Record from console 
			cnslCsv.convConsoleInputToCsv();
		
			//collect  Master JsonObject from Master Json File
			JSONObject mJsonObject = mJson.convrtMasterJsonFileToJsonObject();
			
			//collect record JsonObject from CSV File 
			JSONArray endpoints = csvJson.convrtCsvFileToJsonObject(consoleCsvFile);
			LOGGER.info("JSONArray :");
			for(int index = 0; index < endpoints.length(); index++  ){	
				
				JSONObject endpointName = endpoints.getJSONObject(index);
				LOGGER.info(endpointName.toString(endpoints.length()));	
				addUpdRcds.updateRecordsToMasterJsonFile(mJsonObject, endpointName);
			}	
					
			
		}catch (JSONException e) {
			LOGGER.log(Level.SEVERE, "an exception was thrown", e);
		e.printStackTrace();
		}
	
	}
	
	public void addRecordsFromCsvFile(){
		try {			
			//Input Record from CSV File 
			validateCsv.getValidRecordsCsv();
		
			//collect  Master JsonObject from Master Json File
			JSONObject mJsonObject = mJson.convrtMasterJsonFileToJsonObject();
			
			//collect record JsonObject from CSV File 
			JSONArray endpoints = csvJson.convrtCsvFileToJsonObject(inputCsvFilename);
			LOGGER.info("JSONArray :");
			for(int index = 0; index < endpoints.length(); index++  ){	
				
				JSONObject endpointName = endpoints.getJSONObject(index);
				LOGGER.info(endpointName.toString(endpoints.length()));	
				addUpdRcds.addRecordsToMasterJsonFile(mJsonObject, endpointName);
			}	
					
			
		}catch (JSONException e) {
			LOGGER.log(Level.SEVERE, "an exception was thrown", e);
		e.printStackTrace();
		}
	
	}
		

	
	public void updateRecordsFromCsvFile(){
		try {			
			//Input Record from CSV File 
			validateCsv.getValidRecordsCsv();
		
			//collect  Master JsonObject from Master Json File
			JSONObject mJsonObject = mJson.convrtMasterJsonFileToJsonObject();
			
			//collect record JsonObject from CSV File 
			JSONArray endpoints = csvJson.convrtCsvFileToJsonObject(inputCsvFilename);
			LOGGER.info("JSONArray :");
			for(int index = 0; index < endpoints.length(); index++  ){	
				
				JSONObject endpointName = endpoints.getJSONObject(index);
				LOGGER.info(endpointName.toString(endpoints.length()));	
				addUpdRcds.updateRecordsToMasterJsonFile(mJsonObject, endpointName);
			}	
					
			
		}catch (JSONException e) {
			LOGGER.log(Level.SEVERE, "an exception was thrown", e);
		e.printStackTrace();
		}
		
		
	}	
	
}
