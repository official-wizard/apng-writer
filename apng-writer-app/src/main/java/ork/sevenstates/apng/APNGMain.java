package ork.sevenstates.apng;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public final class APNGMain {

	final File folder;
	final String fileName;
	final int delay;

	public APNGMain(File folder, String fileName, int delay) {
		this.folder = folder;
		this.fileName = fileName;
		this.delay = delay;
	}

	public static void main(String[] args) throws IOException {
		if (args.length != 3) {
			System.err.println("Usage: java -jar apng-writer.jar <folder> <delay> <outputFile>");
		}

		File folder = new File(args[0]);
		String fileName = args[2];
		int delay = Integer.parseInt(args[1]);

		new APNGMain(folder,fileName,delay).doIt();
	}

	private String[] sortedFolder() {
		String[] list = folder.list();
		Arrays.sort(list);
		return list;
	}

	private APNGSeqWriter newWriter() throws IOException {
		return new APNGSeqWriter(fileName, 0);
	}

	private void writeImage(File file,APNGSeqWriter writer) throws IOException {
		writer.writeImage(ImageIO.read(file));
	}


	private void doIt() throws IOException {
		APNGSeqWriter writer = newWriter();
		String[] list = sortedFolder();
		for (int i = 0; i < list.length; i++) {
			writeImage(new File(folder, list[i]),writer);
		}

		writer.close();

	}

}
