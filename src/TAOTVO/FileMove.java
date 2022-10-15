package TAOTVO;

import java.io.File;

public class FileMove {

	public String FileMove(String beforepath, String pictureurl, String afterFilePath) {

		FileMove fileMove = new FileMove();

		String folderName = "upload";// 폴더 생성할 이름
		String fileName =pictureurl;
		String beforeFilePath = beforepath; // 옮길 대상
		String result = fileMove.moveFile(folderName, fileName, beforeFilePath, afterFilePath);
        if(result!=null){
            System.out.println("SUCCESS: "+result);
        }else{
            System.out.println("FAIL");
        }
        //fileDelete(beforeFilePath);

		return result;
	}

	public String moveFile(String folderName, String fileName, String beforeFilePath, String afterFilePath) {

		
		String path = afterFilePath + "/" + folderName;
		String filePath = path+"/"+fileName;

		File dir = new File(path);

		if (!dir.exists()) { // 폴더 없으면 폴더 생성
			dir.mkdirs();
		}

		try {

			File file = new File(beforeFilePath);

			if (file.renameTo(new File(filePath))) { // 파일 이동
				return filePath; // 성공시 성공 파일 경로 return
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void fileDelete(String deleteFileName) {
		File file = new File(deleteFileName);

		if (file.exists()) {
			file.delete();
		}
	}

}