package com.irshadrh;

import java.util.HashMap;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

public class GetStructuralStatusWIH implements WorkItemHandler {

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub
		//HttpsClientSolar hcs =new HttpsClientSolar();
		String structuralAppId = (String) workItem.getParameter("structuralAppId");
		String requestId = (String) workItem.getParameter("requestId");
		System.out.println("Getting structural permit status for structuralAppId :" + structuralAppId+ " and requestId" + requestId);
		
		String response = null;
		try {
			//response = hcs.sendGetStructuralStatusRequest();
			if(structuralAppId.equals("000000"))
				response = "Rejected" ;
			else if(structuralAppId.equals("111111"))
				response = "Pending" ;
			else 
				response="Approved";
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashMap<String,Object> results = new HashMap<String, Object>();
		results.put("structuralStatus", response);
		manager.completeWorkItem(workItem.getId(), results);
	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub
		
	}

}
