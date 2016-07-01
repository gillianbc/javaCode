package com.gill.generics;

public class ServiceDemo {

	public static void main(String[] args) {
		SDService service = new SDService();
		service.setServiceType("Home care");
		ServiceWriter genWriter = new ServiceWriter();
		genWriter.writeOut(service);
		
		System.out.println("==============");
		
		StagingService stag = new StagingService();
		stag.setServiceType("Car Valeting");
		stag.setStageName("Harry the Valet Man");
		StagingWriter stagWriter = new StagingWriter();
		
		stagWriter.writeOut(stag);
		

	}

}
