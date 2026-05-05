package com.app;

import com.google.zxing.*;
import com.google.zxing.client.j2se.*;
import com.google.zxing.common.BitMatrix;
import java.nio.file.*;

public class QRUtil {
    public static void generate(String text, String path) throws Exception {
        BitMatrix matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, 200, 200);
        MatrixToImageWriter.writeToPath(matrix, "PNG", Paths.get(path));
    }
}
