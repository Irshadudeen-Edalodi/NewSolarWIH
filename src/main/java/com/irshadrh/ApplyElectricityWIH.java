package com.irshadrh;

import java.util.HashMap;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;



public class ApplyElectricityWIH implements WorkItemHandler {

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		//PermitRequest permitRequest = (PermitRequest) workItem.getParameter("permitRequest");
		//HttpsClientSolar hcs =new HttpsClientSolar();

		String name = (String) workItem.getParameter("name");
		String requestId = (String) workItem.getParameter("requestId");
		String electricAppId=null;
		try {
			//electricAppId = hcs.sendPostElectricPermitRequest();
			System.out.println("Received elctrucuty permit request with name " + name + " and requestId" + requestId);
			if(name.equals("john"))
				electricAppId="000000";
			else if(name.equals("george"))
				electricAppId="111111";
			else
				electricAppId= "EID"+String.valueOf(Math.random() * 1000000 +1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sending response with electricAppId: " + electricAppId + " name : " + name);
		HashMap<String,Object> results = new HashMap<String, Object>();
		results.put("electricAppId", electricAppId);
		manager.completeWorkItem(workItem.getId(), results);
	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub
		
	}

}
