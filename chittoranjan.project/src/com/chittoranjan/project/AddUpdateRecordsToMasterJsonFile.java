package com.chittoranjan.project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddUpdateRecordsToMasterJsonFile {
	
	private static final Logger LOGGER = Logger.getLogger( AddUpdateRecordsToMasterJsonFile.class.getName() );
	private  final String  MASTERJSON_FILE = "D:\\Records\\dev.endpoints.json";
	/**
	 * @return the mASTERJSON_FILE
	 */
	public String getMASTERJSON_FILE() {
		return MASTERJSON_FILE;
	}
	
	/**
	 * 
	 * @param mJsonObject
	 * @param addRcrdEntry
	 */
	
	public void addRecordsToMasterJsonFile(JSONObject mJsonObject, JSONObject addRcrdEntry){
		try {
			
			/**
			 *  New Individual Record Entry to add in Master Json File
			 */
			LOGGER.info("New Individual Record has been arrived ");		
			LOGGER.info("New Record :");		
			LOGGER.info(addRcrdEntry.toString(0));
			
			String addUpdateKey = addRcrdEntry.getString("endpointName").toString();
			
			/**
			 * Checking attribute of endpointName value for new Record
			 */
			if(addUpdateKey.isEmpty() || addUpdateKey.equals(null)){
				try {
					throw new Exception("not a valid Record");
				} catch (Exception e) {
					LOGGER.info("endpointName is missing for this add Records");
					e.printStackTrace();
				}
			}
			
			/**
			 *  Checking endpointName value with existing Master Json Record
			 */
			JSONArray mJsonArray = mJsonObject.getJSONArray("endpoints");
			boolean flag = false;
			LOGGER.info("List of endpointName key in MasterJson File = ");
			for(int index = 0; index < mJsonArray.length(); index++  ) {
				
				String endPtkey = mJsonArray.getJSONObject(index).getString("endpointName").toString() ;
				LOGGER.info(endPtkey );
				
				if (endPtkey.equals(addUpdateKey)) {
					LOGGER.info("endpointName is already exist in MasterJson File = " + addUpdateKey);
					flag = true;
					break;
				}			
			}
			
			if ( flag == false ){
				
				/**
				 *  Checking attribute value for New Record
				 */
				LOGGER.info("Checking attributes value for New Record ");
				
				String addSgmntName = addRcrdEntry.getString("segmentName").toString();
				String addCstmr 	= addRcrdEntry.getString("customer").toString();
				String addAdmnAddr 	= addRcrdEntry.getString("adminAddr").toString();
				String addvmUuid 	= addRcrdEntry.getString("vmUuid").toString();
				String addRlsTrain 	= addRcrdEntry.getString("releaseTrain").toString();
				String addplcyName	= addRcrdEntry.getString("policyName").toString();
				boolean addchfBtstrap  = addRcrdEntry.getBoolean("desiredChefBootstrap");
				
				JSONObject addRcrdToMstrJsonFile = new JSONObject();
				
				addRcrdToMstrJsonFile.put("endpointName", 	addUpdateKey);
				addRcrdToMstrJsonFile.put("segmentName", 	addSgmntName);
				addRcrdToMstrJsonFile.put("customer", 		addCstmr);
				addRcrdToMstrJsonFile.put("hostname", 		addUpdateKey);
				addRcrdToMstrJsonFile.put("nodename", 		addUpdateKey);
				addRcrdToMstrJsonFile.put("adminAddr", 		addAdmnAddr);
				addRcrdToMstrJsonFile.put("vmUuid",  		addvmUuid );
				addRcrdToMstrJsonFile.put("releaseTrain", 	addRlsTrain);
				addRcrdToMstrJsonFile.put("policyName", addplcyName);
				addRcrdToMstrJsonFile.put("desiredChefBootstrap", addchfBtstrap);
				addRcrdToMstrJsonFile.put("tags", new JSONArray());
				
				LOGGER.info(addRcrdToMstrJsonFile.toString(0));
				LOGGER.info("Add individiual Record to Master JsonObject ");
				mJsonArray.put(addRcrdToMstrJsonFile);
				
				/**
				 * Write  Master Json file.
				 */
				LOGGER.info("Write back to Master Json File ");
				String mJsonFile = this.getMASTERJSON_FILE();
				FileWriter file = new FileWriter(mJsonFile);
				file.write(mJsonObject.toString());

				file.close();
			}
			
			
					
		}catch (JSONException | IOException e){
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, "an exception was thrown", e);
		}
	}
	
	public void updateRecordsToMasterJsonFile (JSONObject mJsonObject, JSONObject UpdtRcrdEntry){
		try {
			
			/**
			 * New Individual Record Entry for update in Master Json File
			 */
			LOGGER.info("Update Record has been arrived ");
			
			LOGGER.info("Update Record :");
			LOGGER.info(UpdtRcrdEntry.toString(0));
			
			/**
			 * Checking endpointName value for new update Record
			 */
			String addUpdateKey = UpdtRcrdEntry.getString("endpointName").toString();
			if(addUpdateKey.isEmpty() || addUpdateKey.equals(null)){
				try {
					throw new Exception("not a valid Record");
				} catch (Exception e) {
					LOGGER.info("endpointName is missing for this update Records");
					e.printStackTrace();
				}
			}
			
			JSONArray mJsonArray = mJsonObject.getJSONArray("endpoints");
			LOGGER.info("List of endpointName key in MasterJson File = ");
			boolean flag = false;
			int index = 0;
			
			for(int i = 0; index < mJsonArray.length(); i++,index++  ) {
				
				String endPtkey = mJsonArray.getJSONObject(i).getString("endpointName").toString() ;
				LOGGER.info(endPtkey );
				
				if (endPtkey.equals(addUpdateKey)) {
					LOGGER.info("endpointName key  exist in Master Json Object = " + addUpdateKey);
					flag = true;
					break;
				}			
			}
			
			if ( flag == true ){
				
				/**
				 *  Checking attributes value of new update Record
				 */
				LOGGER.info("Checking attributes value of new update Record ");
				
				String sgmntName 	= UpdtRcrdEntry.getString("segmentName").toString();
				String cstmr 		= UpdtRcrdEntry.getString("customer").toString();
				String admnAddr 	= UpdtRcrdEntry.getString("adminAddr").toString();
				String vmUuid 		= UpdtRcrdEntry.getString("vmUuid").toString();
				String rlsTrain 	= UpdtRcrdEntry.getString("releaseTrain").toString();
				String plcyName     = UpdtRcrdEntry.getString("policyName").toString();
				boolean chfBtstrap  = UpdtRcrdEntry.getBoolean("desiredChefBootstrap");
				
				JSONObject UpdtRcrdToMstrJsonFile = new JSONObject();
				
				UpdtRcrdToMstrJsonFile.put("endpointName", addUpdateKey);
				UpdtRcrdToMstrJsonFile.put("segmentName", sgmntName);
				UpdtRcrdToMstrJsonFile.put("customer", cstmr);
				UpdtRcrdToMstrJsonFile.put("hostname", addUpdateKey);
				UpdtRcrdToMstrJsonFile.put("nodename", addUpdateKey);
				UpdtRcrdToMstrJsonFile.put("adminAddr", admnAddr);
				UpdtRcrdToMstrJsonFile.put("vmUuid", vmUuid);
				UpdtRcrdToMstrJsonFile.put("releaseTrain", rlsTrain);
				UpdtRcrdToMstrJsonFile.put("policyName", plcyName);
				UpdtRcrdToMstrJsonFile.put("desiredChefBootstrap", chfBtstrap);
				UpdtRcrdToMstrJsonFile.put("tags", new JSONArray());
				LOGGER.info("Update individiual Record to MasterJson File ");
				LOGGER.info(UpdtRcrdToMstrJsonFile.toString(0));
				mJsonArray.put(index,UpdtRcrdToMstrJsonFile);
				
				/**
				 * Write  Master Json file.
				 */
				LOGGER.info("Write  MasterJson File ");
				String mJsonFile = this.getMASTERJSON_FILE();
				FileWriter file = new FileWriter(mJsonFile);
				file.write(mJsonObject.toString());
			//	LOGGER.info(mJsonObject.toString(mJsonArray.length()));
				file.close();	
				return;
			}
			
			
			
		}catch (JSONException | IOException e){
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, "an exception was thrown", e);
		}
		
	}

}
