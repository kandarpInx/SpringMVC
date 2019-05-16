package com.controller;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * PeekCall.java - This class reads data from a text file containing
 * call logs from a call center and processes the timestamps to find
 * out the maximum number of simultaneous calls during the entire
 * call log and the period during which they occurred.
 * 
 * @author Nishant Singh
 */
public class PeekCall {
	
	public static void main(String[] args) {
		ArrayList<Integer> startCallTimestampList = new ArrayList<>();
		ArrayList<Integer> endCallTimestampList = new ArrayList<>();
		
		try {
			
			// Fetch file and read the data into a List of String - START
			URL url = PeekCall.class.getResource("call_log.txt");
			File file = new File(url.getFile());
			List<String> callLogList = Files.lines(file.toPath()).map(log -> log.trim()).collect(Collectors.toList());
			// Fetch file and read the data into a List of String - END
			
			// Split each line into start time stamp and end timestamp - START
			for (int i = 0; i < callLogList.size(); i++) {
				String[] timestampArray = callLogList.get(i).toString().split(":");
				
				if (timestampArray != null && timestampArray.length > 0) {
					startCallTimestampList.add(Integer.parseInt(timestampArray[0]));
					endCallTimestampList.add(Integer.parseInt(timestampArray[1]));
				}
				
			}
			// Split each line into start timestamp and end timestamp - END
			
			// Find simultaneous call count for each record - START
			List<SimultaneousCallResult> simultaneousCallResultList = new ArrayList<>();
			
			for(int i=0; i < startCallTimestampList.size(); i++) {
				Integer maxTimeStamp = startCallTimestampList.get(startCallTimestampList.size() - (1+i));
				int countMax = 1;
				Integer minTimeStamp = 0;
				
				for(int j=0; j < endCallTimestampList.size(); j++) {
					Integer start = startCallTimestampList.get(j);
					Integer end = endCallTimestampList.get(j);
					if(end >= maxTimeStamp && start <= maxTimeStamp) {
						countMax++;
						if(minTimeStamp == 0 || minTimeStamp > end) {
							minTimeStamp = end;
						}
					}
				}
				
				// Add the information regarding number of simultaneous calls and their start and end timestamp in the list
				simultaneousCallResultList.add(new SimultaneousCallResult(countMax, maxTimeStamp, minTimeStamp));
			}
			// Find simultaneous call count for each record - END
			
			// Filter the list to find the one with maximum simultaneous call count
			int maxCallCount = simultaneousCallResultList.stream().map(SimultaneousCallResult::getSimultaneousCallCount).max(Integer::compareTo).get();
			Set<SimultaneousCallResult> maxSimultaneousCallList = simultaneousCallResultList.stream().filter(result -> result.getSimultaneousCallCount() == maxCallCount).collect(Collectors.toSet());
			
			// Print the result to console
			for(SimultaneousCallResult printSimultaneousCallResult : maxSimultaneousCallList) {
				System.out.println("The peak for this call log is " + printSimultaneousCallResult.getSimultaneousCallCount() + " simultaneous calls that occurred between "
						+ printSimultaneousCallResult.getSimultaneousStartTimestamp() + " and " + printSimultaneousCallResult.getSimultaneousEndTimestamp() + ".");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * 
 * This class is used to store the result of simultaneous calls
 * for a particular record
 * 
 * @author Nishant Singh
 */
class SimultaneousCallResult {
	private int simultaneousCallCount;
	private Integer simultaneousStartTimestamp;
	private Integer simultaneousEndTimestamp;
	
	public SimultaneousCallResult(int simultaneousCallCount, Integer simultaneousStartTimestamp, Integer simultaneousEndTimestamp) {
		super();
		this.simultaneousCallCount = simultaneousCallCount;
		this.simultaneousStartTimestamp = simultaneousStartTimestamp;
		this.simultaneousEndTimestamp = simultaneousEndTimestamp;
	}

	public int getSimultaneousCallCount() {
		return simultaneousCallCount;
	}

	public void setSimultaneousCallCount(int simultaneousCallCount) {
		this.simultaneousCallCount = simultaneousCallCount;
	}

	public Integer getSimultaneousStartTimestamp() {
		return simultaneousStartTimestamp;
	}

	public void setSimultaneousStartTimestamp(Integer simultaneousStartTimestamp) {
		this.simultaneousStartTimestamp = simultaneousStartTimestamp;
	}

	public Integer getSimultaneousEndTimestamp() {
		return simultaneousEndTimestamp;
	}

	public void setSimultaneousEndTimestamp(Integer simultaneousEndTimestamp) {
		this.simultaneousEndTimestamp = simultaneousEndTimestamp;
	}

	@Override
	public String toString() {
		return "SimultaneousCallResult [simultaneousCallCount=" + simultaneousCallCount
				+ ", simultaneousStartTimestamp=" + simultaneousStartTimestamp + ", simultaneousEndTimestamp="
				+ simultaneousEndTimestamp + "]";
	}
	
	@Override
	public int hashCode() {
		int hashCode = Long.valueOf((simultaneousCallCount * 31 + simultaneousCallCount) * 31 + simultaneousCallCount).hashCode();
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimultaneousCallResult other = (SimultaneousCallResult) obj;
		
		if(simultaneousCallCount == other.getSimultaneousCallCount() && simultaneousStartTimestamp.equals(other.getSimultaneousStartTimestamp()) && simultaneousEndTimestamp.equals(other.getSimultaneousEndTimestamp())) {
			return true;
		} else {
			return false;
		}
	}
	
}