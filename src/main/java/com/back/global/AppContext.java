package com.back.global;

import com.back.WiseSaying.controller.WiseSayingController;
import com.back.WiseSaying.repository.WiseSayingRepository;
import com.back.WiseSaying.service.WiseSayingService;
import com.back.system.controller.SystemController;

import java.util.Scanner;

// Scanner 이런 방식도 있음
public class AppContext {
    public static Scanner sc;
    public static SystemController systemController;
    public static WiseSayingController wiseSayingController;
    public static WiseSayingService wiseSayingService;
    public static WiseSayingRepository wiseSayingRepository;

    public static void init(Scanner _sc) {
        AppContext.sc = _sc;
        AppContext.wiseSayingRepository = new WiseSayingRepository();
        AppContext.wiseSayingService = new WiseSayingService();
        AppContext.wiseSayingController = new WiseSayingController(sc);
        AppContext.systemController = new SystemController();
    }

    public static void init() {
        init(new Scanner(System.in));
    }
}
