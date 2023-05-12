package src.Messages.Device;

import src.DataTypes.Payload;

public class GetLabel extends Payload {
	int code = 23;
	
	public GetLabel() {}
	
	public int getCode() {
		return code;
	}
}