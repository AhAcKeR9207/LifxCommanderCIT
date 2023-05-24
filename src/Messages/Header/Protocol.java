package src.Messages.Header;

import src.LifxCommander.CommonMethods;

public class Protocol {
	long reserved1;
	int type;
	int reserved2;
	
	public Protocol() {
		reserved1 = 0;
		type = 0;
		reserved2 = 0;
	}
	
	public Protocol(long reserved1, int type, int reserved2) {
		this.reserved1 = reserved1;
		this.type = type;
		this.reserved2 = reserved2;
	}
	
	public Protocol(int type) {
		reserved1 = 0;
		this.type = type;
		reserved2 = 0;
	}
	
	public Protocol(Protocol protocol) {
		reserved1 = protocol.reserved1;
		type = protocol.type;
		reserved2 = protocol.reserved2;
	}
	
	public long getReserved1() {
		return reserved1;
	}
	
	public void setReserved1(long reserved1) {
		this.reserved1 = reserved1;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public byte[] getByteArray() {
		byte[] byteArray = new byte[12];
		
		byte[] reserved1Bytes = new byte[8];
		String reserved1BinStr = String.format("%64s", Long.toBinaryString(reserved1)).replace(' ', '0');
		reserved1Bytes = CommonMethods.convertBinaryStringToLittleEndianByteArray(reserved1BinStr);
		for (int i=0; i<8; i++) {
			byteArray[i] = reserved1Bytes[i];
		}
		
		byte[] typeBytes = new byte[2];
		String typeBinStr = String.format("%16s", Integer.toBinaryString(type)).replace(' ', '0');
		typeBytes = CommonMethods.convertBinaryStringToLittleEndianByteArray(typeBinStr);
		byteArray[8] = typeBytes[0];
		byteArray[9] = typeBytes[1];
		
		byte[] reserved2Bytes = new byte[2];
		String reserved2BinStr = String.format("%16s", Integer.toBinaryString(reserved2)).replace(' ', '0');
		reserved2Bytes = CommonMethods.convertBinaryStringToLittleEndianByteArray(reserved2BinStr);
		byteArray[10] = reserved2Bytes[0];
		byteArray[11] = reserved2Bytes[1];
		
		return byteArray;
	}
}