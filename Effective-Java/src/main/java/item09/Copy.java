package item09;

import java.io.*;

public class Copy {
    private static final int BUFFER_SIZE = 8 * 1024;

    static String copy_1(String src) throws IOException {
        InputStream in = new ByteArrayInputStream(src.getBytes());
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
                return out.toString();
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    static String copy_2(String src) throws IOException {
        try (InputStream in = new ByteArrayInputStream(src.getBytes());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
            return out.toString();
        }
    }
}