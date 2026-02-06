import java.util.Scanner;

public class App {

    private Scanner scanner;
    public App(Scanner scanner) {
        this.scanner = scanner; // 일단은 테스트 케이스 돌리기 위한 용도로 만듬
        // this.scanner = new Scanner(System.in);  이거는 실제 입력을 해야만 함
    }

    public void run() {
        System.out.println("== 명언 앱 ==");
    }
}
