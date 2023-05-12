package src.Messages.Device;

import src.DataTypes.Payload;

public class GetInfo extends Payload {
	int code = 34;
	
	public GetInfo() {}
	
	public int getCode() {
		return code;
	}
}