package com.gill.generics;

public class ServiceWriter extends AbstractEntityWriter<SDService> {
	@Override
	public void writeOut(SDService service) {
		super.writeOut(service);
		System.out.println("ServiceWriter: Service Type: " + service.getServiceType());
	}

	

	
	
}
