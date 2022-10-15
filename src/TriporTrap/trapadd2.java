package TriporTrap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketAddress;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import TAOTVO.TrapAO;
import TAOTVO.TrapVO;
import UTIL.Action;

@WebServlet("/trapadd.do")
public class trapadd2 extends HttpServlet implements Action {
	private static final long serialVersionUID = 1L;
       
    public trapadd2() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		
		//String saveFolder = "E:/tot";
		String saveFolder = "C:/tot";
		String encType = "utf-8";
		int sizelimit = 20 * 1024 * 1024;
		System.out.println("Saved folder : "+saveFolder );
		
		MultipartRequest multi = new MultipartRequest(request, saveFolder, sizelimit, encType,new DefaultFileRenamePolicy());
		String key, value;
		Enumeration<String> enumer = multi.getParameterNames();
		
		TrapVO tvo=new TrapVO();
		
	    while (enumer.hasMoreElements()) {
	        key = enumer.nextElement();
	        value = multi.getParameter(key);
	        switch(key){
	        case "trapperAccount":
	        	tvo.setTrapperaccount(Integer.parseInt(value));
	        	break;
	        case "addre":
	        	tvo.setAddre(value);
	        	break;
	        case "latitude":
	        	tvo.setLatitude(Double.parseDouble(value));
	        	break;
	        case "longitude":
	        	tvo.setLongitude(Double.parseDouble(value));
	        	break;
	        case "xAxis":
	        	tvo.setxAxis(Double.parseDouble(value));
	        	break;
	        case "yAxis":
	        	tvo.setyAxis(Double.parseDouble(value));
	        	break;
	        case "zAxis":
	        	tvo.setzAxis(Double.parseDouble(value));
	        	break;
	        case "heading":
	        	tvo.setHeading(Double.parseDouble(value));
	        	break;
	        case "pitch":
	        	tvo.setPitch(Double.parseDouble(value));
	        	break;
	        case "roll":
	        	tvo.setRoll(Double.parseDouble(value));
	        	break;
	        case "imgwidth":
	        	tvo.setImgwidth(Integer.parseInt(value));
	        	break;
	        case "imgheight":
	        	tvo.setImgheight(Integer.parseInt(value));
	        	break;
	        case "pictureurl":
	        	tvo.setPictureurl(value);
	        }
	        
	        System.out.println(key + " : " + value);
	    }
	    System.out.println("Check ran : "+tvo.getRoll());
	    File file;
	    
	    enumer = multi.getFileNames();
	    while (enumer.hasMoreElements()) {
	    key = enumer.nextElement();
	        file = multi.getFile(key);
	        System.out.println(key + " : " + file.getName());
	    }
		String pictureurl = multi.getFilesystemName("pictureurl");
		
		File file1 =multi.getFile("pictureurl");		
		String path=file1.getPath();
		File uploadfile=new File(path);
		if (pictureurl == null) {
			pictureurl = multi.getParameter("noimg");
			System.out.println("There's no img");
		} 
				
		tvo.setPictureurl(pictureurl);
		tvo.setFile(file1);
		tvo.setPictureurlspath(path);
		
		System.out.println("pic's : pitch >"+tvo.getPitch());
		
		TrapAO tao=TrapAO.getInstance();
		try {
			tao.ftpupload(file1);
			tao.addtrap(tvo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
