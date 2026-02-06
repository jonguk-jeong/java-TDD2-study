import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtilTest {
    @Test
    @DisplayName("TestUtil.genScanner()")
    void t1() {
        Scanner scanner = TestUtil.genScanner("""
                등록
                현재를 사랑하라.
                작자미상
                """);

        String cmd = scanner.nextLine();
        String content = scanner.nextLine();
        String author = scanner.nextLine();

        assertThat(cmd).isEqualTo("등록");
        assertThat(content).isEqualTo("현재를 사랑하라.");
        assertThat(author).isEqualTo("작자미상");
    }

    @Test
    @DisplayName("TestUtil.setOutByteArray()")
    void t2() throws Exception{
        // byteArrayOutputStream 여기에 내 모든 입력 쌓임
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutByteArray(); // 출력을 내가 잘 돌려서 받아 올 수 있나 테스트

        System.out.println("1 / 이순신 / 나의 죽음을 적에게 알리지 마라");

        String rst = byteArrayOutputStream.toString();

        // 모니터로 확인하고 싶은 시점
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

        System.out.println("출력 결과 : " + rst);

        assertThat(rst).contains("1 / 이순신 / 나의 죽음을 적에게 알리지 마라");

        //assertThat(rst).contains("안녕하세요"); // isEqualTo는 정확히 일치해야함 너무 엄격. 그래서 contains로 바꿈

    }
}
