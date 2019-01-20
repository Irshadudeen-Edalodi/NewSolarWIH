package com.irshadrh;

import java.util.HashMap;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;



public class ApplyStructuralWIH implements WorkItemHandler {

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		//PermitRequest permitRequest = (PermitRequest) workItem.getParameter("permitRequest");
		Integer area =  (Integer) workItem.getParameter("area");
		String requestId = (String) workItem.getParameter("requestId");
		System.out.println("Received structural permit Request with area: " + area + " and requestId" + requestId);
		
		//HttpsClientSolar hcs =new HttpsClientSolar();
		String structuralAppId = null;
		try {
			//structuralAppId = hcs.sendPostStructuralPermitRequest();
			if(area<100)
				structuralAppId ="000000";
			else if (area >= 100 && area<200)
				structuralAppId = "111111";
			else
				structuralAppId= "SID"+String.valueOf(Math.random() * 1000000 +1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashMap<String,Object> results = new HashMap<String, Object>();
		results.put("structuralAppId", structuralAppId);
		manager.completeWorkItem(workItem.getId(), results);
		
	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub
		
	}

}
