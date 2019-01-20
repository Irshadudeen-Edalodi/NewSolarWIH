package com.irshadrh;

import java.util.HashMap;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;



public class RecindElectricalWIH implements WorkItemHandler {

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		//PermitRequest permitRequest = (PermitRequest) workItem.getParameter("permitRequest");
		String electricAppId = (String) workItem.getParameter("electricAppId");
		String requestId = (String) workItem.getParameter("requestId");
		System.out.println("Recinding electric permit status for electricAppId :" + electricAppId+ " and requestId" + requestId);
		
		//HttpsClientSolar hcs =new HttpsClientSolar();
		String electricRecindStatus=null;
		try {
			//electricAppId = hcs.sendPostElectricPermitRequest();
			electricRecindStatus="Recinded";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashMap<String,Object> results = new HashMap<String, Object>();
		results.put("electricRecindStatus", electricRecindStatus);
		manager.completeWorkItem(workItem.getId(), results);
	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub
		
	}

}
