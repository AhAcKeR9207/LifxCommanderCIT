package src.DataTypes;

import java.awt.Color;

import src.Constants;

public class HSBK {
	public int hue;
	public int saturation;
	public int brightness;
	public int kelvin;
	
	public HSBK() {
		hue = 0;
		saturation = Constants.Levels.MAX;
		brightness = Constants.Levels.MAX;
		kelvin = Constants.Kelvin.MEDIUM;
	}
	
	public HSBK(int hue, int saturation, int brightness, int kelvin) {
		this.hue = hue;
		this.saturation = saturation;
		this.brightness = brightness;
		this.kelvin = kelvin;
	}

	public static HSBK RGBtoHSBK (Color rgb) {
		float[] hsb = Color.RGBtoHSB(rgb.getRed(), rgb.getGreen(), rgb.getBlue(), null);
  
		int hue = (int) (hsb[0] * 65535.0);
		int saturation = (int) (hsb[1] * 65535.0);
		int brightness = (int) (hsb[2] * 65535.0);
		int kelvin = 4000;
  
		HSBK hsbk = new HSBK(hue, saturation, brightness, kelvin);
		return hsbk;
	}
	
	public int getHue() {
		return hue;
	}
	
	public void setHue(int hue) {
		this.hue = hue;
	}
	
	public int getSaturation() {
		return saturation;
	}
	
	public void setSaturation(int saturation) {
		this.saturation = saturation;
	}
	
	public int getBrightness() {
		return brightness;
	}
	
	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}
	
	public int getKelvin() {
		return kelvin;
	}
	
	public void setKelvin(int kelvin) {
		this.kelvin = kelvin;
	}	
}