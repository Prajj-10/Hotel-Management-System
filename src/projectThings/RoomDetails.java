package projectThings;

public class RoomDetails {
	//declaring
	int roomNo;
	String type;
	String status;
	int cost;
	
	//default constructor
	public RoomDetails() {
		
		this.roomNo = 0;
		this.type = "";
		this.status = "";
		this.cost = 0;
	}
	
	//parameterized constructor
	public RoomDetails(int roomNo, String type, String status, int cost) {
		
		this.roomNo = roomNo;
		this.type = type;
		this.status = status;
		this.cost = cost;
	}
	
	//copy constructor
	public RoomDetails(RoomDetails rDetails) {
		
		this.roomNo = rDetails.roomNo;
		this.type = rDetails.type;
		this.status = rDetails.status;
		this.cost = rDetails.cost;
	}
	
	//getters and setters
	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "RoomDetails [roomNo=" + roomNo + ", type=" + type + ", status=" + status + ", cost=" + cost + "]";
	}
	
	
	
	
	
	
}
