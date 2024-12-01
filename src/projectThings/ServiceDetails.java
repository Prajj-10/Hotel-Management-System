package projectThings;

public class ServiceDetails {
	//declaring	
	int ServiceID;
	String ServiceName;
	String ServiceType;
	int Price;
	
	//default constructor
	public ServiceDetails() {
		
		this.ServiceID = 0;
		this.ServiceName = "";
		this.ServiceType = "";
		this.Price = 0;
		
		
	}
	
	
	//parameterized constructor
	public ServiceDetails(int serviceID, String serviceName, String serviceType, int price) {
		super();
		ServiceID = serviceID;
		ServiceName = serviceName;
		ServiceType = serviceType;
		Price = price;
	}
	
	//copy constructor
	public ServiceDetails(ServiceDetails sDetails) {
		
		ServiceID = sDetails.ServiceID;
		ServiceName = sDetails.ServiceName;
		ServiceType = sDetails.ServiceType;
		Price = sDetails.Price;
	}


	//getters and setters
	public int getServiceID() {
		return ServiceID;
	}



	public void setServiceID(int serviceID) {
		ServiceID = serviceID;
	}



	public String getServiceName() {
		return ServiceName;
	}



	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}



	public String getServiceType() {
		return ServiceType;
	}



	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}



	public int getPrice() {
		return Price;
	}



	public void setPrice(int price) {
		Price = price;
	}



	@Override
	public String toString() {
		return "ServiceDetails [ServiceID=" + ServiceID + ", ServiceName=" + ServiceName + ", ServiceType="
				+ ServiceType + ", Price=" + Price + ", getServiceID()=" + getServiceID() + ", getServiceName()="
				+ getServiceName() + ", getServiceType()=" + getServiceType() + ", getPrice()=" + getPrice()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}
