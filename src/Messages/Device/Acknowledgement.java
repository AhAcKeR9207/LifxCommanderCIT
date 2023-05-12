package src.Messages.Device;

import src.DataTypes.Payload;

public class Acknowledgement extends Payload {
	int code = 45;
	
	public Acknowledgement() {}
	
	public int getCode() {
		return code;
	}
}