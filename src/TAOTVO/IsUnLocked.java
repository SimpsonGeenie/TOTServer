package TAOTVO;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class IsUnLocked {

	public static BufferedImage resizeImage(BufferedImage image, int width, int height) {
		  
		  float w = new Float(width) ;
		  float h = new Float(height) ;
		  
		  if ( w <= 0 && h <= 0 ) {
		   w = image.getWidth();
		   h = image.getHeight();
		  } else if ( w <= 0 ) {
		   w = image.getWidth() * ( h / image.getHeight() ); 
		  } else if ( h <= 0 ) {
		   h = image.getHeight() * ( w / image.getWidth() ); 
		  }
		  
		  int wi = (int) w;
		  int he = (int) h;
		  
		  BufferedImage resizedImage = new BufferedImage(wi,he,BufferedImage.TYPE_INT_RGB);
		 
		  resizedImage.getGraphics().drawImage(
		    image.getScaledInstance(wi,he,Image.SCALE_AREA_AVERAGING),0,0,wi,he,null);
		 
		  return resizedImage;
		 }
	
	public int IsUnLocked(String file, String filetemp){
		
			
//			TrapAO tao = null;
//			TrapVO tvo=null;
//			try {
//				tao.selecttrap(file);
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			tvo.getPictureurl();
			
			BufferedImage pictureurlori = loadImage(file); 
			System.out.println("get img1 ok img addr : "+file);
			BufferedImage pictureurlunl = loadImage(filetemp);
			System.out.println("get img2 ok img addr : "+filetemp);
			
			int w = pictureurlori.getWidth(null); 
			int h = pictureurlori.getHeight(null); 
			
			Double totalresult1=0.0;
			Double totalresult2=0.0;
			
			Boolean isUnlockTrue=false;
			BufferedImage pictureurlunltemp=resizeImage(pictureurlunl, w, h);			
			System.out.println("resize img ok");
			int w1 = pictureurlunltemp.getWidth(null); 
			int h1 = pictureurlunltemp.getHeight(null);
			
					int[] result = new int[w * h];
					int[] result1 = new int[w1 * h1];
					int[] result2 = new int[w * h];
					result = pictureurlori.getRGB(0, 0, w, h, result, 0, w);
					result1 = pictureurlunltemp.getRGB(0, 0, w1, h1, result1, 0, w1);
					result2 = pictureurlori.getRGB(0, 0, w, h, result, 0, w);
					try {
						int count = 0;					
						Double reslt[]={0.0,0.0,0.0, 0.0};
						
						Double resultimg=0.0;
						Double totalresult=0.0;
						
						
						for(int i=0;i<w;i++){
							  for(int j=0;j<h;j++){								 
							  Color color=new Color(pictureurlori.getRGB(i, j));
							  Color color1=new Color(pictureurlunltemp.getRGB(i, j));
							  int red = color.getRed();
							  int green = color.getGreen();
							  int blue = color.getBlue();
							  int alpha = color.getAlpha();
							  int []imgcol={red,green,blue};
							  //, alpha
							  int red1 = color1.getRed();
							  int green1 = color1.getGreen();
							  int blue1 = color.getBlue();
							  int alpha1 = color1.getAlpha();
							  int []imgcol1={red1,green1,blue1};
							  //, alpha1
							  int count01 = 0;
							  Double avg=0.0;							  
							  for(int k=0;k<imgcol.length;k++){
									if(imgcol[k]>imgcol1[k]){										
										reslt[k]=((double)imgcol1[k]/(double)imgcol[k]);										
									}else if(imgcol[k]==imgcol1[k]){										
										reslt[k]=1.0;										
									}else if(imgcol[k]<imgcol1[k]){	
										reslt[k]=((double)imgcol[k]/(double)imgcol1[k]);
								}
									count01++;
									avg+=reslt[k];
									resultimg=(avg/count01);
							}
							  count++;
							  totalresult+=resultimg;
							  totalresult1=(totalresult/count);
							  }
						  } System.out.println("unlock? "+totalresult1*100+"% 같음");
						 						  
					} catch (Exception e) {
						
					}
					int finalresult=Integer.parseInt(String.valueOf(Math.round(totalresult1*100)));
					
					return finalresult;
					
	}
	public static BufferedImage loadImage(String url) { 
		BufferedImage image = null; 
		try { 
			image = ImageIO.read(new File(url)); 
		} catch (IOException e) {
			e.printStackTrace(); 
		} return image; 
	}	
	
}
