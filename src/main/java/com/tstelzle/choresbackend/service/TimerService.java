package com.tstelzle.choresbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TimerService {

    private ChoreService choreService;

    @Autowired
    public TimerService(ChoreService choreService) {
        this.choreService = choreService;
    }

    @Scheduled(
            cron = "0 1 * * *", zone = "Europe/Paris"
    )
    public void run() {
        choreService.decreaseCurrentIntervalForEveryChore();
    }
}
