package ork.sevenstates.apng.filter;

import java.nio.ByteBuffer;

public class None extends AbstractFilter {
	static final byte INDEX = 0;

	@Override
	public void encodeRow(ByteBuffer in, int srcOffset, ByteBuffer out, int len, int destOffset) {
		out.put(destOffset++, INDEX);
		int bpl = getWidth() * getBpp();
		ByteBuffer tmp = in.duplicate();
		tmp.position(srcOffset).limit(srcOffset + bpl);
		out.position(destOffset);
		out.put(tmp);
	}

}
