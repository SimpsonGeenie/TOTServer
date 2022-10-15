package TAOTVO;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class imgtest {
	
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
	
	public static void main(String[] args) throws IOException {
		 
		 Image img= new ImageIcon("d:\\2222.jpg").getImage();
		 System.out.println( img.getWidth(null) + "," +
				 img.getHeight(null));
		  
		  int width = img.getWidth( null ); 
		  int height = img.getHeight( null ); 
		  int[] pixels = new int[ width * height ];
		 
		  PixelGrabber grab = 
				    new PixelGrabber( img, 0, 0, width, height, pixels, 0, width );
				  try {
					grab.grabPixels();
					System.out.println("width : "+width+", height : "+height);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				  
			BufferedImage image = loadImage("d:\\IMG_1357.jpg"); 
			BufferedImage image1 = loadImage("d:\\IMG_1358.jpg");
			
			int w = image.getWidth(null); 
			int h = image.getHeight(null); 
				
			BufferedImage image12=resizeImage(image1, w, h);			
			
			
			int w1 = image12.getWidth(null); 
			int h1 = image12.getHeight(null);
			
					int[] result = new int[w * h];
					int[] result1 = new int[w1 * h1];
					int[] result2 = new int[w * h];
					result = image.getRGB(0, 0, w, h, result, 0, w);
					result1 = image12.getRGB(0, 0, w1, h1, result1, 0, w1);
					result2 = image.getRGB(0, 0, w, h, result, 0, w);
//					System.out.println("?��미�? 1 width : "+w+" / height"+h);
//					System.out.println("?��미�? 2 width : "+w1+" / height"+h1);
					
					try {
						int count = 0;					
						Double reslt[]={0.0,0.0,0.0, 0.0};
						
						Double resultimg=0.0;
						Double totalresult=0.0;
						Double totalresult1=0.0;
						Double totalresult2=0.0;
						
						for(int i=0;i<w;i++){
							  for(int j=0;j<h;j++){
								  //========RGB �? ?��?��======//
							  Color color=new Color(image.getRGB(i, j));
							  Color color1=new Color(image12.getRGB(i, j));
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
										//System.out.println(imgcol[k]+" / "+imgcol1[k]);
										reslt[k]=((double)imgcol1[k]/(double)imgcol[k]);
										//System.out.println(reslt[k]);
									}else if(imgcol[k]==imgcol1[k]){
										//System.out.println(imgcol[k]+" / "+imgcol1[k]);
										reslt[k]=1.0;
										//System.out.println(reslt[k]);
									}else if(imgcol[k]<imgcol1[k]){	
										//System.out.println(imgcol[k]+" / "+imgcol1[k]);
										reslt[k]=((double)imgcol[k]/(double)imgcol1[k]);
										//System.out.println(reslt[k]);
								}
									count01++;
									avg+=reslt[k];
									//System.out.println("avg�? : "+avg + " / RGBA 카운?�� "+count01);
									resultimg=(avg/count01);
									//System.out.println("?��미�? 배열 비교�?"+resultimg*100+"% 같음");
							}
							  count++;
							  totalresult+=resultimg;
							  totalresult1=(totalresult/count);
							  //System.out.println("�? ?��미�? 배열 비교�?"+totalresult1*100+"% 같음");
							
							  }
							 
							 
						  } System.out.println("진짜 �? ?��미�? 배열 비교�?"+totalresult1*100+"% 같음");
					} catch (Exception e) {
						// TODO: handle exception
					}
				  JFrame frame=new JFrame("test");
				  JFrame frame1=new JFrame("test");
				  frame.setLocation(width, height);
				  frame1.setLocation(width, height);
				  Dimension dim=new Dimension(width+50, height+50);
				  frame.setPreferredSize(dim);
				  frame1.setPreferredSize(dim);
				  JLabel label=new JLabel();
				  JLabel label1=new JLabel();
				  label.setOpaque(true);
				  label1.setOpaque(true);
				  ImageIcon icon = new ImageIcon(image);
				  ImageIcon icon1 = new ImageIcon(image1);
				  
				  label.setIcon(icon);
				  label1.setIcon(icon1);
				  frame.add(label);
				  frame1.add(label1);
				  frame.pack();
				  frame.setVisible(true);
				  frame1.pack();
				  frame1.setVisible(true);

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
