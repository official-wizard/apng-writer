package ork.sevenstates.apng.filter;

import java.nio.ByteBuffer;

public interface Filter {

	int getBpp();
	void setBpp(int newBpp);

	int getHeight();
	void setHeight(int newHeight);

	int getWidth();
	void setWidth(int newWidth);

	void close();

	void encode(ByteBuffer in, ByteBuffer out);
	void encodeRow(ByteBuffer in, int srcOffset, ByteBuffer out, int len, int destOffset);

}
