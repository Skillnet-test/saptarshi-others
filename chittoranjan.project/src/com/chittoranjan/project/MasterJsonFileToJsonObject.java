package com.infrastructure.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * <h1>MasterJsonFileToJsonObject</h1>
 * Reads input from Master Json File and 
 * Convert to JsonObjet
 * @author Chittaranjan Ray
 *
 */
public class MasterJsonFileToJsonObject {
	private static final Logger LOGGER = Logger.getLogger( MasterJsonFileToJsonObject.class.getName() );
	private  final String  MASTERJSON_FILE = "D:\\Records\\dev.endpoints.json";
	
	/**
	 * @return the mASTERJSON_FILE
	 */
	public String getMASTERJSON_FILE() {
		return MASTERJSON_FILE;
	}
	
/**
 * Read Master Json File
 * Convert Master Json File to JSONObject 
 * @return JSONObject
 * @throws FileNotFoundException
 */
	public JSONObject convrtMasterJsonFileToJsonObject (){
	/**
	 * 	Read input from MasterJson File 
	 */
		LOGGER.info("Enter convrtMasterJsonFileToJsonObject ()");
		LOGGER.info("Reading File from MasterJson File");
		
		String mJsonFile = this.getMASTERJSON_FILE();
		String mJsonFileString = null;
		
		try {
			BufferedReader mJsonBufRd = new BufferedReader(new FileReader(mJsonFile));
			StringBuilder buffer = new StringBuilder();
			
			String currentLine = null;
	    	 while ((currentLine = mJsonBufRd.readLine()) != null) { 
	    		 buffer.append(currentLine);
	    		 
	    		 mJsonFileString = buffer.toString();
	    		
	    	 }
	    	 
	    	 LOGGER.info(mJsonFileString);
	    	 mJsonBufRd.close();
	
		} catch (IOException e) {
			LOGGER.info("MasterJson File not found ");
			LOGGER.log( Level.SEVERE, e.toString(), e );
			e.printStackTrace();
		}
	/**
	 *  Convert Master Json String to JsonObect 	
	 */
		JSONObject mJsonObject = new JSONObject();
		try {
			mJsonObject = new JSONObject(mJsonFileString);
	//		JSONArray mJsonArray = mJsonObject.getJSONArray("endpoints");
	//		LOGGER.info("Master JsonObject : ");
	//		LOGGER.info(mJsonObject.toString(mJsonArray.length()));
			
		} catch (JSONException e) {
			LOGGER.info("Master JsonObject does not created ");
			LOGGER.log( Level.SEVERE, e.toString(), e );
			e.printStackTrace();
		}
		LOGGER.info("exit convrtMasterJsonFileToJsonObject ()");
		return mJsonObject;
		
		
	}
	
}
