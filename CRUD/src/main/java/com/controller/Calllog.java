package com.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author
 *
 */
public class Calllog {

	public static void main(String[] args) {
		Calllog call = new Calllog();
		String x = call.readFile();
		System.out.println(x);
	}

	/**
	 * This method is used to read timestamps from file and add values to appropriate Lists
	 *  
	 * @return String as final output
	 */
	public String readFile()  {
		File file = new File("callLog.txt");
		String x = null;
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String data;
			List<Date> startTimeList = new ArrayList<Date>();
			List<Date> endTimeList = new ArrayList<Date>();

			//Validate for the file input is proper and store the data in list
			while ((data = bufferedReader.readLine()) != null) {
				String[] time = data.split(":");
				startTimeList.add(new Date(Integer.parseInt(time[0]) * 1000L));
				endTimeList.add(new Date(Integer.parseInt(time[1]) * 1000L));
			}
			x = compare(startTimeList,endTimeList);
			bufferedReader.close();
			
		} catch (IOException io) {
			System.out.println(io.getLocalizedMessage());
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return x;
	}
	
	
	/**
	 * This method is used to Compare timestamps and calculate maximum simultaneous calls
	 * 
	 * @param startTimeList is for starting time of timestamp of call log
	 * @param endTimeList is for end time of timestamp of call log
	 * @return String as final output
	 */
	public String compare(List<Date> startTimeList, List<Date> endTimeList)
	{
		Map<Date,List<Date>> calllog = new TreeMap<>();
		List<Date> match;
		int count =0;
		for (int i = 0; i < startTimeList.size();  i+=count) {
			count=0;
			match = new ArrayList<Date>();
			for (int j = i; j < startTimeList.size(); j++) {
				if(startTimeList.get(i).equals(startTimeList.get(j)))
				{
					if(calllog.get(startTimeList.get(i)) != null)
						match = calllog.get(startTimeList.get(i));
					count++;
					match.add(endTimeList.get(j));
				}
				else {
					if(endTimeList.get(i).after(startTimeList.get(j))) {
						if(endTimeList.get(j).before(endTimeList.get(i))) {
							if(calllog.get(startTimeList.get(i)) != null) {
								match = calllog.get(startTimeList.get(i));
							}
							match.add(endTimeList.get(j));
							Collections.sort(match);
						}
					}
				}
			}
			calllog.put(startTimeList.get(i),match);
		}
		
		List<Date> Max = calllog.get(Collections.max(calllog.entrySet(), (entry1, entry2) -> entry1.getValue().size() - entry2.getValue().size()).getKey());
		int size = Max.size();
		Date startDate = Collections.max(calllog.entrySet(), (entry1, entry2) -> entry1.getValue().size() - entry2.getValue().size()).getKey();
		return "The peak for this call log is "+size+" simultaneous calls, that occured between "+ startDate.getTime()/1000 +" and "+ Max.get(size-1).getTime() / 1000;
	}
	
}