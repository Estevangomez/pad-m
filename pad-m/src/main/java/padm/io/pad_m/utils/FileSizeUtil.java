package padm.io.pad_m.utils;

public class FileSizeUtil {

    public static String formatFileSize(long sizeInBytes) {
        if (sizeInBytes < 1024) {
            return sizeInBytes + " B";
        } else if (sizeInBytes < 1024 * 1024) {
            return sizeInBytes / 1024 + " KB";
        } else if (sizeInBytes < 1024 * 1024 * 1024) {
            return sizeInBytes / (1024 * 1024) + " MB";
        } else {
            return sizeInBytes / (1024 * 1024 * 1024) + " GB";
        }
    }
}
