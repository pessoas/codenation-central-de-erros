package br.com.codenation.centraldeerros.controller;

import br.com.codenation.centraldeerros.entity.Log;
import br.com.codenation.centraldeerros.entity.enums.Level;
import br.com.codenation.centraldeerros.projection.LogNoEventLog;
import br.com.codenation.centraldeerros.service.interfaces.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping
    public ResponseEntity<Log> create(@RequestBody Log log) {

        return new ResponseEntity<>(this.logService.save(log), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Log> update(Long id) {

        return new ResponseEntity<>(this.logService.update(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LogNoEventLog>> findAll(Pageable pageable){
        return new ResponseEntity<>(this.logService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Log>> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.logService.findById(id), HttpStatus.OK);
    }


    @GetMapping("/origin/{origin}")
    public ResponseEntity<List<LogNoEventLog>> getByOrigin(@PathVariable("origin") String origin, Pageable pageable) {
        return new ResponseEntity<>(this.logService.findByOrigin(origin, pageable),HttpStatus.OK);
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<List<LogNoEventLog>> getByLevel(@PathVariable("level") Level level, Pageable pageable) {
        return new ResponseEntity<>(this.logService.findByLevel(level, pageable), HttpStatus.OK);
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<List<LogNoEventLog>> getByDescription(@PathVariable("description") String description,
                                                                Pageable pageable) {
        return new ResponseEntity<>(this.logService.findByDescription(description, pageable),HttpStatus.OK);
    }

    @GetMapping("/eventNumber/{eventNumber}")
    public ResponseEntity<List<LogNoEventLog>> getByEventNumber(@PathVariable("eventNumber") Long eventNumber,
                                                                Pageable pageable) {
        return new ResponseEntity<>(this.logService.findByEventNumber(eventNumber, pageable),HttpStatus.OK);
    }

    @GetMapping("/createdAt/{createdAt}")
    public ResponseEntity<List<LogNoEventLog>> getByCreatedAt(@PathVariable("createdAt") String createdAt,
                                                              Pageable pageable) {

        return new ResponseEntity<>(this.logService.findByCreatedAt(createdAt, pageable), HttpStatus.OK);
    }

    @GetMapping("/updatedAt/{updatedAt}")
    public ResponseEntity<List<LogNoEventLog>> getByUpdatedAt(@PathVariable("updatedAt") String updatedAt,
                                                              Pageable pageable) {

        return new ResponseEntity<>(this.logService.findByUpdatedAt(updatedAt, pageable), HttpStatus.OK);
    }

}