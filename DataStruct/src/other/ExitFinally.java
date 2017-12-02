package other;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExitFinally {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos=null;
		try{
			fos=new FileOutputStream("");
			System.out.println("程序打开物理资源");
			System.exit(0);
		}finally{
			//使用finally块关闭资源
			if(fos!=null){
				try{
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			System.out.println("程序关闭了物流资源");
		}
	}
}
