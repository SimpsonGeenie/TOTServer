package TriporTrap;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.prism.Image;

import TAOTVO.*;


@WebServlet("/trapunlock.do")
public class trapunlock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public trapunlock() {
        super();       
    }

    public static BufferedImage loadImage(String url) { 
		BufferedImage image = null; 
		try { 
			image = ImageIO.read(new File(url)); 
		} catch (IOException e) {
			e.printStackTrace(); 
		} return image; 
	}	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		try {
		//String saveFolder = "E:/tot";
				String saveFolder = "C:/tot";
				String encType = "utf-8";
				int sizelimit = 20 * 1024 * 1024;
				System.out.println("Saved folder : "+saveFolder );
				
				MultipartRequest multi = new MultipartRequest(request, saveFolder, sizelimit, encType,new DefaultFileRenamePolicy());
				String key, value;
				Enumeration<String> enumer = multi.getParameterNames();
				File filetocompare;
				TrapVO tvo=new TrapVO();
				
			    while (enumer.hasMoreElements()) {
			        key = enumer.nextElement();
			        value = multi.getParameter(key);
			        switch(key){
			        case "addre":
			        	tvo.setAddre(value);
			        	break;
			        case "latitude":
			        	tvo.setLatitude(Double.parseDouble(value));
			        	break;
			        case "longitude":
			        	tvo.setLongitude(Double.parseDouble(value));
			        	break;
			        case "pictureurl":
			        	tvo.setUnlockpictureurl(value);			        	
			        case "trappicAccount":
			        	tvo.setTrappicaccount(Integer.parseInt(value));
			        	break;
			        case "unlockerAccount":
			        	String unlockacc=value;
			        	tvo.setUnlockeraccount(Integer.parseInt(unlockacc));
			        	break;			        	
			        case "selectedpictureurl":
			        	tvo.setSelectedpictureurl(value);
			        }
			        
			        System.out.println(key + " : " + value);
			    }
			    System.out.println("Check ran : "+tvo.getTrappicaccount());
			    File file;
			    
			    enumer = multi.getFileNames();
			    while (enumer.hasMoreElements()) {
			    key = enumer.nextElement();
			        file = multi.getFile(key);
			        System.out.println(key + " : " + file.getName());
			    }
				String pictureurl = multi.getFilesystemName("pictureurl");
				
				String forcomparepictureurl ="http://mustory.ivyro.net/tot/"+ tvo.getSelectedpictureurl();
				
				File file1 =multi.getFile("pictureurl");		
				String path=file1.getPath();
				
				tvo.setUnlockpictureurl(pictureurl);			
				if (pictureurl == null) {
					pictureurl = multi.getParameter("noimg");
					System.out.println("There's no img");
				} 
				URL url = new URL(forcomparepictureurl);
				BufferedImage img = ImageIO.read(url);
		        filetocompare=new File("C:/tot/filetocomparetrap.jpg");
		        
		        if(filetocompare.exists()){
		        	filetocompare.delete();
		        }
		        ImageIO.write(img, "jpg", filetocompare);
		        
		        String path1=filetocompare.getAbsolutePath();
				
				IsUnLocked istrapunlock=new IsUnLocked();
				int unlockedq=istrapunlock.IsUnLocked(path, path1);
				
				System.out.println("pic's : unlock percent >" + unlockedq);
	
				TrapAO tao = TrapAO.getInstance();
				tvo.setIsunlocked(unlockedq);
				if(unlockedq>75){
					
					tao.ftpupload(file1);
					tao.trapunlock(tvo);	
					
				}else{
					System.out.println("언락되지 않음");
					tvo.setIsunlocked(unlockedq);
				}
		        } catch (IOException ex) {
		         ex.printStackTrace();
		        } catch (Exception e) {
					e.printStackTrace();
		        }				
	}		
}
