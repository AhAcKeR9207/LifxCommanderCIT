package src.Messages.Light;

import src.DataTypes.Payload;

public class GetPower_Light extends Payload{
	int code = 116;
	
	public GetPower_Light() {}
	
	public int getCode() {
		return code;
	}
}