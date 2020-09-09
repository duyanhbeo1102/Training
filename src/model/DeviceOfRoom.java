package model;

public class DeviceOfRoom extends BaseModel{
	private int dorID;
	private Device device;
	private Room room;
	private int dorQuantity;
	private int dorStatus;
	private String dorNote;
	public DeviceOfRoom() {
		super();
	}
	public DeviceOfRoom(int dorID, Device device, Room room, int dorQuantity, int dorStatus, String dorNote) {
		super();
		this.dorID = dorID;
		this.device = device;
		this.room = room;
		this.dorQuantity = dorQuantity;
		this.dorStatus = dorStatus;
		this.dorNote = dorNote;
	}
	public int getDorID() {
		return dorID;
	}
	public void setDorID(int dorID) {
		this.dorID = dorID;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public int getDorQuantity() {
		return dorQuantity;
	}
	public void setDorQuantity(int dorQuantity) {
		this.dorQuantity = dorQuantity;
	}
	public int getDorStatus() {
		return dorStatus;
	}
	public void setDorStatus(int dorStatus) {
		this.dorStatus = dorStatus;
	}
	public String getDorNote() {
		return dorNote;
	}
	public void setDorNote(String dorNote) {
		this.dorNote = dorNote;
	}
	@Override
	public String toString() {
		return "DeviceOfRoom [dorID=" + dorID + ", device=" + device + ", room=" + room + ", dorQuantity=" + dorQuantity
				+ ", dorStatus=" + dorStatus + ", dorNote=" + dorNote + "]";
	}
	
}
