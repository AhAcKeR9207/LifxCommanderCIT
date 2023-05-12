package src.Messages.Device;

import src.DataTypes.Payload;

public class GetWifiFirmware extends Payload {
	int code = 18;
	
	public GetWifiFirmware() {}
	
	public int getCode() {
		return code;
	}
}