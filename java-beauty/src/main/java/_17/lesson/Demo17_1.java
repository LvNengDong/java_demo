package _17.lesson;

/**
 * @Author lnd
 * @Description
 * @Date 2024/6/5 16:18
 */
public class Demo17_1 {

    /*受检异常*/
    public static class LowLevelException extends Exception {
        public LowLevelException() {
            super();
        }

        public LowLevelException(String msg, Throwable cause) {
            super(msg, cause);
        }

        public LowLevelException(String msg) {
            super(msg);
        }

        public LowLevelException(Throwable cause) {
            super(cause);
        }
    }

    /*受检异常*/
    public static class MidLevelException extends Exception {
        public MidLevelException() {
            super();
        }

        public MidLevelException(String msg, Throwable cause) {
            super(msg, cause);
        }

        public MidLevelException(String msg) {
            super(msg);
        }

        public MidLevelException(Throwable cause) {
            super(cause);
        }
    }

    /*不受检异常*/
    public static class HighLevelException extends RuntimeException {
        public HighLevelException() {
            super();
        }

        public HighLevelException(String msg, Throwable cause) {
            super(msg, cause);
        }

        public HighLevelException(String msg) {
            super(msg);
        }

        public HighLevelException(Throwable cause) {
            super(cause);
        }
    }

    public static void fa() throws LowLevelException {
        throw new LowLevelException("LowLevelException-msg");
    }

    public static void fb() throws LowLevelException {
        fa();
    }

    public static void fc() throws MidLevelException {
        try {
            fb();
        } catch (LowLevelException e) {
            throw new MidLevelException("MidLevelException-msg", e);
        }
    }

    public static void fd() {
        try {
            fc();
        } catch (MidLevelException e) {
            throw new HighLevelException("HighLevelException-msg", e);
        }
    }

    public static void fe() {
        fd();
    }

    public static void main(String[] args) {
        try {
            fe();
        } catch (HighLevelException e) {
            e.printStackTrace();
        }
    }
}
