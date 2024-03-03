package com.tstelzle.choresbackend.service;

import com.tstelzle.choresbackend.entity.Chore;
import com.tstelzle.choresbackend.repository.ChoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ChoreService {

    private ChoreRepository choreRepository;

    @Autowired
    public ChoreService(ChoreRepository choreRepository) {
        this.choreRepository = choreRepository;
    }

    public List<Chore> getChores() {
        return choreRepository.findAll();
    }

    public boolean add(Chore chore) {
        choreRepository.save(chore);
        return true;
    }

    public boolean delete(long id) {
        choreRepository.deleteById(id);
        return true;
    }

    public boolean update(Chore chore, long id) {
        Optional<Chore> choreOptional = choreRepository.findById(id);
        if (choreOptional.isPresent()) {
            Chore choreGet = choreOptional.get();
            choreGet.setName(chore.getName());
            choreGet.setCurrentInterval(chore.getCurrentInterval());
            choreGet.setInterval(chore.getInterval());
            choreRepository.save(choreGet);
            return true;
        } else {
            return false;
        }
    }

    public void decreaseCurrentIntervalForEveryChore() {
        List<Chore> chores = choreRepository.findAll();

        for (Chore chore : chores) {
            int currentInterval = chore.getCurrentInterval();
            if (currentInterval > 0 ) {
                chore.setCurrentInterval(currentInterval - 1);
                choreRepository.save(chore);
            }
        }
    }
}
