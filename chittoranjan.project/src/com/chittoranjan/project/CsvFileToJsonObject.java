package com.infrastructure.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * <h1>CsvFileToJsonObject</h1>
 * Reads input from CSV File,  
 * Convert CSV File to JsonObjet,
 * @author Chittaranjan Ray
 *
 */
public class CsvFileToJsonObject {
	
	private static final Logger LOGGER = Logger.getLogger( CsvFileToJsonObject.class.getName() );
	

	/**
	 * Read input from CSV File
	 * Convert CSV File to JSONObject
	 * @return JSONObject
	 * 
	 */
	
	public JSONArray convrtCsvFileToJsonObject (String inputCsv){
	
	/**
	 * 	Read input from CSV File 
	 */
		LOGGER.info("Enter convrtCsvFileToJsonObject ()");
		String inputCsvFile = inputCsv;
		String CSVFile = new String();
		
		try {
			FileInputStream inputStream = new FileInputStream(inputCsvFile);
			CSVFile = IOUtils.toString(inputStream);
		} catch (IOException e) {
			LOGGER.info("Input CSV File not found ");
			LOGGER.log( Level.SEVERE, e.toString(), e );
			e.printStackTrace();
		}
		
		/**
		 *  Convert CSV File to JsonObect 
		 */
		JSONArray array = null;
		try {
			array = CDL.toJSONArray(CSVFile);
		} catch (JSONException e) {
			LOGGER.log( Level.SEVERE, e.toString(), e );
			e.printStackTrace();
		}
		
	
		LOGGER.info("Exit convrtCsvFileToJsonObject ()");
		
			return array;

	
		
		
	}
	
}
