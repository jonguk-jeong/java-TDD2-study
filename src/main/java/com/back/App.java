package com.back;

import com.back.WiseSaying.controller.WiseSayingController;
import com.back.global.AppContext;
import com.back.system.controller.SystemController;

import java.util.Scanner;

public class App {

    private Scanner sc;
    private WiseSayingController wiseSayingController;
    private SystemController systemController;

    public App() {
//        this.scanner = new Scanner(System.in);  이거는 실제 입력을 해야만 함
        this.sc = AppContext.sc;
        wiseSayingController= AppContext.wiseSayingController;
        systemController = AppContext.systemController;
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