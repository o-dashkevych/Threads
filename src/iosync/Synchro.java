package iosync;


import java.io.FileWriter;
import java.io.IOException;

public class Synchro {
    private FileWriter fileWriter;

    public Synchro(String file) throws IOException {
        fileWriter = new FileWriter(file, true);
    }

    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void writing(String str, int i) {
        try {
            System.out.print(str + i);
            fileWriter.append(str + i);
            Thread.sleep((long) (Math.random() * 50));
            System.out.print("->" + i + " ");
            fileWriter.append("->" + i + " ");
        } catch (IOException e) {
            System.err.print("ошибка файла");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.print("ошибка потока");
            e.printStackTrace();
        }
    }
}
/*

public class Writing {
	private RandomAccessFile fileWriter;
	private File file;

	public Writing(String path) {
		this.file = new File(path);
	}

	public synchronized void write(String text) throws FileNotFoundException {
		if (file == null) throw new FileNotFoundException("File wasn't found.");
		try {
			System.out.println(text);
			fileWriter = new RandomAccessFile(file,"rw");
			fileWriter.writeUTF(System.lineSeparator());
			fileWriter.writeUTF(text);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public void closeOut(){
		try {
			if(fileWriter != null)
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
*/
