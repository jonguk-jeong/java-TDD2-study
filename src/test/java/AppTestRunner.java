import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {
    public static String run(String input) {
        Scanner sc = TestUtil.genScanner(input + "\n종료"); // scanner를 받아오기

        ByteArrayOutputStream outputStream = TestUtil.setOutByteArray();    // 프로그램 돌린게 여기에 쌓임
        new App(sc).run();                                                    // AppTest

        return outputStream.toString();
    }
}
