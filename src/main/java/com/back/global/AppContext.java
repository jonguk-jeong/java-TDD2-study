package com.back.global;

import com.back.WiseSaying.controller.WiseSayingController;
import com.back.WiseSaying.repository.WiseSayingFileRepository;
import com.back.WiseSaying.repository.WiseSayingMemRepository;
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
    public static WiseSayingMemRepository wiseSayingMemRepository;
    public static WiseSayingFileRepository wiseSayingFileRepository;
    public static WiseSayingRepository wiseSayingRepository;

    public static void init(Scanner _sc, boolean isFileMode) {
        AppContext.sc = _sc;
        AppContext.wiseSayingFileRepository = new WiseSayingFileRepository();
        AppContext.wiseSayingMemRepository = new WiseSayingMemRepository();
        AppContext.wiseSayingRepository = isFileMode ? AppContext.wiseSayingFileRepository : AppContext.wiseSayingMemRepository;
        AppContext.wiseSayingService = new WiseSayingService();
        AppContext.wiseSayingController = new WiseSayingController(sc);
        AppContext.systemController = new SystemController();
    }

    public static void init() {
        init(new Scanner(System.in), false);
    }
}
