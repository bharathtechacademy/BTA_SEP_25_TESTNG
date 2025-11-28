package com.creatio.crm.framework.db.commons;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.creatio.crm.framework.utilities.DBUtil;

public class DBCommons {
	
	/**
	 * This class will contain common methods to read the data from the database.
	 */
	
	//Convert raw data collected from the database into a List<Map<String,String>>  format.
		public static List<Map<String, String>> getData(String query) throws SQLException {
			//Create an empty List of Map to store the data.
			List<Map<String,String>> data = new ArrayList<Map<String,String>>();
			
			//Get the raw data from database in the form of ResultSet
			ResultSet rs = DBUtil.executeQuery(query);
			
			//Convert the ResultSet data into List<Map<String,String>> format.
			while(rs.next()) { //if there is data present in the ResultSet and move the cursor to next row.
				Map<String,String> row = new HashMap<String,String>();
				
				for(int c=1; c<=rs.getMetaData().getColumnCount();c++) {
					String columnName = rs.getMetaData().getColumnName(c);
					String columnValue = rs.getString(c);
					row.put(columnName, columnValue);
				}
				
				//add the row into the data list
				data.add(row);
			}
			
			//return the data
			return data;
		}

}
