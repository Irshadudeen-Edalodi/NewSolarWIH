package com.irshadrh;

import java.util.HashMap;
import java.util.Random;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

public class GetElectricStatusWIH implements WorkItemHandler {

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {

		//HttpsClientSolar hcs =new HttpsClientSolar();
		String electricAppId = (String) workItem.getParameter("electricAppId");
		String requestId = (String) workItem.getParameter("requestId");
		System.out.println("Getting electric permit status for electricAppId :" + electricAppId + " and requestId" + requestId);
		String response = null;
		try {
			//response = hcs.sendGetElectricStatusRequest();
			
			
			
		
			
			if(electricAppId.equals("000000"))
				response = "Rejected" ;
			else if(electricAppId.equals("111111"))
				response = "Pending" ;
			else 
				response="Approved";
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashMap<String,Object> results = new HashMap<String, Object>();
		results.put("electricStatus", response);
		manager.completeWorkItem(workItem.getId(), results);
		
	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub
		
	}

}
