package other;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AutoClose {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Wolf w = new Wolf("灰太狼", 0);
		System.out.println("Wolf对象创建完成~");
		Wolf w2=null;
		try(
				ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(""));
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(""))
			){
			oos.writeObject(w);
			oos.flush();
			w2=(Wolf) ois.readObject();
		}
	}
}
