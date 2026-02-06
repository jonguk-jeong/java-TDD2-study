import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;

    int lastId = 0;
    List<WiseSaying> wiseSayings = new ArrayList<>();

    public App(Scanner sc) {
        this.sc = sc; // 일단은 테스트 케이스 돌리기 위한 용도로 만듬
        // this.scanner = new Scanner(System.in);  이거는 실제 입력을 해야만 함
    }

    public void run() {


        System.out.println("== 명언 앱 ==");

        while(true) {

            System.out.println("명령) ");
            String cmd = sc.nextLine();

            switch (cmd) {
                case "등록" -> {
                    System.out.print("명언 : ");
                    String saying = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();

                    lastId++;

                    WiseSaying wiseSaying = new WiseSaying(lastId, saying, author);
                    wiseSayings.add(wiseSaying);

                    System.out.println("%d번 명언이 등록되었습니다.".formatted(lastId));
                }
                case "목록" -> {
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    wiseSayings
                            .reversed()
                            .stream()
                            .forEach(wiseSaying -> System.out.printf("%d / %s / %s%n",
                                    wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getSaying()));
                }
                case "종료" -> {
                    return;
                }
            }
        }
    }
}
