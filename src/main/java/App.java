import java.util.Scanner;

public class App {

    private Scanner sc;
    private WiseSayingController wiseSayingController;
    private SystemController systemController;

    public App(Scanner sc) {
//        this.scanner = new Scanner(System.in);  이거는 실제 입력을 해야만 함
        this.sc = sc; // 일단은 테스트 케이스 돌리기 위한 용도로 만듬
        this.wiseSayingController = new WiseSayingController(sc);
        this.systemController = new SystemController();
    }

    public void run() {


        System.out.println("== 명언 앱 ==");

        while (true) {

            System.out.println("명령) ");
            String cmd = sc.nextLine();

            switch (cmd) {
                case "등록" -> wiseSayingController.actionAdd();
                case "목록" -> wiseSayingController.actionList();
                case "종료" -> {
                    systemController.actionExit();
                    return;
                }
            }
        }
    }
}