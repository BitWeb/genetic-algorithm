package ee.bitweb.geneticalgorithm.util;

import java.nio.ByteBuffer;

/**
 * Created by tobre on 19/07/2017.
 */
public class BinaryUtil {

    public static byte[] convert(Double d) {
        byte[] output = new byte[8];
        Long lng = Double.doubleToLongBits(d);
        for (int i = 0; i < 8; i++) {
            output[i] = (byte)((lng >> ((7 - i) * 8)) & 0xff);
        }
        return output;
    }

    public static Double convert(byte[] b) {
        return ByteBuffer.wrap(b).getDouble();
    }
}
