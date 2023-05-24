package src.DataTypes;

import src.Messages.Header.*;

public class Command {
	Frame frame;
	FrameAddress frameAddress;
	Protocol protocol;
	Payload payload;
	
	public Command(Payload payload){
		frame = new Frame();
		frameAddress = new FrameAddress();
		protocol = new Protocol();
		this.payload = payload;
		protocol.setType(payload.getCode());
		
		setSize();
	}
	
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
	public void setFrameAddress(FrameAddress frameAddress) {
		this.frameAddress = frameAddress;
	}
	
	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}
	
	public void setPayload(Payload payload) {
		this.payload = payload;
	}
	
	public void setSize() {
		int size;
		if(payload.getByteArray() != null) size = frame.getByteArray().length + frameAddress.getByteArray().length + protocol.getByteArray().length + payload.getByteArray().length;
		else size = frame.getByteArray().length + frameAddress.getByteArray().length + protocol.getByteArray().length;
		frame.setSize(size);
	}
	
	public byte[] getByteArray() {
		byte[] byteArray = new byte[frame.getSize()];
		int frameEnd = 8;
		int frameAddressEnd = 24;
		int protocolEnd = 36;
      
		for(int i = 0; i < frameEnd; i++) {
			byteArray[i] = frame.getByteArray()[i];
		}
		
		for(int i = frameEnd; i < frameAddressEnd; i++) {
			byteArray[i] = frameAddress.getByteArray()[i - frameEnd];
		}
		
		for(int i = frameAddressEnd; i < protocolEnd; i++) {
			byteArray[i] = protocol.getByteArray()[i - frameAddressEnd];
		}
		
		for(int i = protocolEnd; i < frame.getSize(); i++) {
			byteArray[i] = payload.getByteArray()[i - protocolEnd];
		}
      
		return byteArray;
	}
}