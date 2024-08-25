package ork.sevenstates.apng;

public enum FCTLOpcode {
    NOTHING((byte) 0),
    CLEAR((byte) 1),
    REVERT((byte) 2);

    private final byte opcode;

    FCTLOpcode(byte opcode) {
        this.opcode = opcode;
    }

    public byte getOpcode() {
        return opcode;
    }
}