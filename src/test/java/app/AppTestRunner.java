package app;

import com.back.App;
import com.back.global.AppConfig;
import com.back.global.AppContext;
import test.TestUtil;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {
    public static String run(String input) {
        Scanner sc = TestUtil.genScanner(input + "\n종료"); // scanner를 받아오기

        ByteArrayOutputStream outputStream = TestUtil.setOutByteArray();    // 프로그램 돌린게 여기에 쌓임

        AppConfig.setTestMode();
        AppContext.init(sc, false);
        new App().run();

        try {
            TestUtil.clearSetOutToByteArray(outputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // app.AppTest

        return outputStream.toString();
    }
}
