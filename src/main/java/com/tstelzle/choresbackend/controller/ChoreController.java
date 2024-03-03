package com.tstelzle.choresbackend.controller;

import com.tstelzle.choresbackend.entity.Chore;
import com.tstelzle.choresbackend.service.ChoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChoreController {

    private ChoreService choreService;

    @Autowired
    public ChoreController(ChoreService choreService) {
        this.choreService = choreService;
    }

    @GetMapping("/api/chore")
    public ResponseEntity<?> getChores() {
        return new ResponseEntity<>(choreService.getChores(), HttpStatus.OK);
    }

    @DeleteMapping("/api/chore")
    public ResponseEntity<Boolean> Delete(@RequestParam long id) {
        choreService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/api/chore")
    public ResponseEntity<Boolean> Add(@RequestBody Chore chore) {
        choreService.add(chore);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/api/chore")
    public ResponseEntity<Boolean> Update(@RequestBody Chore chore, @RequestParam long id) {
        return new ResponseEntity<>(choreService.update(chore, id), HttpStatus.OK);
    }
}
