package TAOTVO;

import java.io.File;

public class FileMove {

	public String FileMove(String beforepath, String pictureurl, String afterFilePath) {

		FileMove fileMove = new FileMove();

		String folderName = "upload";// ���� ������ �̸�
		String fileName =pictureurl;
		String beforeFilePath = beforepath; // �ű� ���
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

		if (!dir.exists()) { // ���� ������ ���� ����
			dir.mkdirs();
		}

		try {

			File file = new File(beforeFilePath);

			if (file.renameTo(new File(filePath))) { // ���� �̵�
				return filePath; // ������ ���� ���� ��� return
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