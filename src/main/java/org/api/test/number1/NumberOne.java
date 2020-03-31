package org.api.test.number1;

public class NumberOne {

    public byte[] split(long val){
        byte[] b = new byte[4];
        b[0] = (byte) (val & 0xFF);
        b[1] = (byte) ((val >> 8) & 0xFF);
        b[2] = (byte) ((val >> 16) & 0xFF);
        b[3] = (byte) ((val >> 24) & 0xFF);
        return b;
    }

}
