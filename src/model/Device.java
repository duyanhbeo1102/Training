package model;

public class Device  extends BaseModel{
	private int deviceID;
	private String deviceName;
	private int deviceStatus;
	public Device() {
		super();
	}
	public Device(int deviceID, String deviceName, int deviceStatus) {
		super();
		this.deviceID = deviceID;
		this.deviceName = deviceName;
		this.deviceStatus = deviceStatus;
	}
	public int getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public int getDeviceStatus() {
		return deviceStatus;
	}
	public void setDeviceStatus(int deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	@Override
	public String toString() {
		return "Device [deviceID=" + deviceID + ", deviceName=" + deviceName + ", deviceStatus=" + deviceStatus + "]";
	}
	
}
