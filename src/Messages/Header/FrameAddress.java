package src.Messages.Header;

import src.LifxCommander.CommonMethods;

public class FrameAddress {
	public long target;
	public long reserved1;
	public int reserved2;
	public boolean ack_required;
	public boolean res_required;
	public int sequence;
	
	public FrameAddress() {
		target = 0;
		reserved1 = 0;
		reserved2 = 0;
		ack_required = false;
		res_required = false;
		sequence = 0;
	}
	
	public byte[] getByteArray() {
		byte[] byteArray = new byte[16];
		
		byte[] targetBytes = new byte[8];
		String targetBinStr = String.format("%64s", Long.toBinaryString(target)).replace(' ', '0');
		targetBytes = CommonMethods.convertBinaryStringToLittleEndianByteArray(targetBinStr);
		for(int i = 0; i < 8; i++) byteArray[i] = targetBytes[i];
		
		byte[] reserved1Bytes = new byte[6];
		String reserved1BinStr = String.format("%48s", Long.toBinaryString(reserved1)).replace(' ', '0');
		reserved1Bytes = CommonMethods.convertBinaryStringToLittleEndianByteArray(reserved1BinStr);
		for(int i = 8; i < 14; i++) byteArray[i] = reserved1Bytes[i-8];
		
		byte[] dataByte = new byte[1];
		String reserved2BinStr = String.format("%6s", Integer.toBinaryString(reserved2)).replace(' ', '0');
		String ackRequiredBinStr = ack_required ? "1" : "0";
		String resRequiredBinStr = res_required ? "1" : "0";
		String dataBinStr = reserved2BinStr + ackRequiredBinStr + resRequiredBinStr;
		dataByte = CommonMethods.convertBinaryStringToLittleEndianByteArray(dataBinStr);
		byteArray[14] = dataByte[0];
		
		byte[] sequenceByte = new byte[1];
		String sequenceBinStr = String.format("%8s", Integer.toBinaryString(sequence)).replace(' ', '0');
		sequenceByte = CommonMethods.convertBinaryStringToLittleEndianByteArray(sequenceBinStr);
		byteArray[15] = sequenceByte[0];
		
		return byteArray;
	}
}