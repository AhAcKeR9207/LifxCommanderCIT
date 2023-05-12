package src.Messages.Device;

import src.DataTypes.Payload;

public class GetLocation extends Payload {
	int code = 48;
	
	public GetLocation() {}
	
	public int getCode() {
		return code;
	}
}