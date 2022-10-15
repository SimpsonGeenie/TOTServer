package TAOTVO;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

public class TrapVO {

	int trappicaccount;
	int trapperaccount;
	String addre;
	Double latitude;
	Double longitude;
	Double xAxis;
	Double yAxis;
	Double zAxis;
	Double heading;
	Double pitch;
	Double roll;
	
	String pictureurl;
	String pictureurlspath;
	File orifile;
	boolean trapunlock;
	int isunlocked;
	
public int getIsunlocked() {
		return isunlocked;
	}
	public void setIsunlocked(int isunlocked) {
		this.isunlocked = isunlocked;
	}

String selectedpictureurl;
	
	public String getSelectedpictureurl() {
		return selectedpictureurl;
	}
	public void setSelectedpictureurl(String selectedpictureurl) {
		this.selectedpictureurl = selectedpictureurl;
	}
	
	String trapImageBase64;
	String trapImageBase;
	byte[] decodedBytes;
	
	int imgwidth;
	int imgheight;
	
	int unlockeraccount;
	String unlockpictureurl;
	String unlockpictureurlspath;
	File file;
	
	public String getPictureurlspath() {
		return pictureurlspath;
	}
	public void setPictureurlspath(String pictureurlspath) {
		this.pictureurlspath = pictureurlspath;
	}
	public File getOrifile() {
		return orifile;
	}
	public void setOrifile(File orifile) {
		this.orifile = orifile;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public int getTrappicaccount() {
		return trappicaccount;
	}
	public void setTrappicaccount(int trappicaccount) {
		this.trappicaccount = trappicaccount;
	}
	public int getTrapperaccount() {
		return trapperaccount;
	}
	public void setTrapperaccount(int trapperaccount) {
		this.trapperaccount = trapperaccount;
	}
	public String getAddre() {
		return addre;
	}
	public void setAddre(String addre) {
		this.addre = addre;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getxAxis() {
		return xAxis;
	}
	public void setxAxis(Double xAxis) {
		this.xAxis = xAxis;
	}
	public Double getyAxis() {
		return yAxis;
	}
	public void setyAxis(Double yAxis) {
		this.yAxis = yAxis;
	}
	public Double getzAxis() {
		return zAxis;
	}
	public void setzAxis(Double zAxis) {
		this.zAxis = zAxis;
	}
	public Double getHeading() {
		return heading;
	}
	public void setHeading(Double heading) {
		this.heading = heading;
	}
	public Double getPitch() {
		return pitch;
	}
	public void setPitch(Double pitch) {
		this.pitch = pitch;
	}
	public Double getRoll() {
		return roll;
	}
	public void setRoll(Double roll) {
		this.roll = roll;
	}
	public String getPictureurl() {
		return pictureurl;
	}
	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}
	public boolean getTrapunlock() {
		return trapunlock;
	}
	public void setTrapunlock(boolean trapunlock) {
		this.trapunlock = trapunlock;
	}
	public String getTrapImageBase64() {
		return trapImageBase64;
	}
	public void setTrapImageBase64(String trapImageBase64) {
		this.trapImageBase64 = trapImageBase64;
	}
	public String getTrapImageBase() {
		return trapImageBase;
	}
	public void setTrapImageBase(String trapImageBase) {
		this.trapImageBase = trapImageBase;
	}
	public byte[] getDecodedBytes() {
		return decodedBytes;
	}
	public void setDecodedBytes(byte[] decodedBytes) {
		this.decodedBytes = decodedBytes;
	}
	public int getImgwidth() {
		return imgwidth;
	}
	public void setImgwidth(int imgwidth) {
		this.imgwidth = imgwidth;
	}
	public int getImgheight() {
		return imgheight;
	}
	public void setImgheight(int imgheight) {
		this.imgheight = imgheight;
	}
	public int getUnlockeraccount() {
		return unlockeraccount;
	}
	public void setUnlockeraccount(int unlockeraccount) {
		this.unlockeraccount = unlockeraccount;
	}
	public String getUnlockpictureurl() {
		return unlockpictureurl;
	}
	public void setUnlockpictureurl(String unlockpictureurl) {
		this.unlockpictureurl = unlockpictureurl;
	}
	public String getUnlockpictureurlspath() {
		return unlockpictureurlspath;
	}
	public void setUnlockpictureurlspath(String unlockpictureurlspath) {
		this.unlockpictureurlspath = unlockpictureurlspath;
	}
	
}
