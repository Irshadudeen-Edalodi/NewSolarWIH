package com.irshadrh;

import java.util.HashMap;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;



public class RecindStructuralWIH implements WorkItemHandler {

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		//PermitRequest permitRequest = (PermitRequest) workItem.getParameter("permitRequest");
		
		//HttpsClientSolar hcs =new HttpsClientSolar();
		
		String structuralAppId = (String) workItem.getParameter("structuralAppId");
		String requestId = (String) workItem.getParameter("requestId");
		System.out.println("Recinding electric permit status for structuralAppId :" + structuralAppId);

		String structuralRecindStatus=null;
		try {
			//electricAppId = hcs.sendPostElectricPermitRequest();
			structuralRecindStatus="Recinded";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashMap<String,Object> results = new HashMap<String, Object>();
		results.put("structuralRecindStatus", structuralRecindStatus);
		manager.completeWorkItem(workItem.getId(), results);
	}

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub
		
	}

}
