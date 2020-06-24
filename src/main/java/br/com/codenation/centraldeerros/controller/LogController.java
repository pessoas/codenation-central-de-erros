package br.com.codenation.centraldeerros.controller;

import br.com.codenation.centraldeerros.controller.advice.ResourceNotFoundException;
import br.com.codenation.centraldeerros.entity.Log;
import br.com.codenation.centraldeerros.entity.enums.Level;
import br.com.codenation.centraldeerros.projection.LogNoEventLog;
import br.com.codenation.centraldeerros.service.interfaces.LogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping
    @ApiOperation(value = "Persists a new log on database", response = Log.class)
    public ResponseEntity<Log> create(@Valid @RequestBody Log log) {

        return new ResponseEntity<>(this.logService.save(log), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Updates the eventNumber value", response = Log.class)
    public ResponseEntity<Log> update(@PathVariable("id") Long id, Long numberOfEvents) {

        return new ResponseEntity<>(this.logService.update(id, numberOfEvents), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletes a log based on id")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Log log = this.logService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Log not found for ID: \" + id"));
        this.logService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @ApiOperation(value = "Returns a list with all logs with no eventLog", response = LogNoEventLog.class)
    public ResponseEntity<List<LogNoEventLog>> findAll(Pageable pageable){
        return new ResponseEntity<>(this.logService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Returns a log based on id", response = Log.class)
    public ResponseEntity<Log> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.logService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found for ID: " + id)), HttpStatus.OK);
    }


    @GetMapping("/origin/{origin}")
    @ApiOperation(value = "Returns a list of logs based on origin with no eventLog", response = LogNoEventLog.class)
    public ResponseEntity<List<LogNoEventLog>> getByOrigin(@PathVariable("origin") String origin, Pageable pageable) {
        return new ResponseEntity<>(this.logService.findByOrigin(origin, pageable),HttpStatus.OK);
    }

    @GetMapping("/level/{level}")
    @ApiOperation(value = "Returns a list of logs based on level with no eventLog", response = LogNoEventLog.class)
    public ResponseEntity<List<LogNoEventLog>> getByLevel(@PathVariable("level") Level level, Pageable pageable) {
        return new ResponseEntity<>(this.logService.findByLevel(level, pageable), HttpStatus.OK);
    }

    @GetMapping("/description/{description}")
    @ApiOperation(value = "Returns a list of logs based on description with no eventLog", response = LogNoEventLog.class)
    public ResponseEntity<List<LogNoEventLog>> getByDescription(@PathVariable("description") String description,
                                                                Pageable pageable) {
        return new ResponseEntity<>(this.logService.findByDescription(description, pageable),HttpStatus.OK);
    }

    @GetMapping("/eventNumber/{eventNumber}")
    @ApiOperation(value = "Returns a list of logs based on eventNumber with no eventLog", response = LogNoEventLog.class)
    public ResponseEntity<List<LogNoEventLog>> getByEventNumber(@PathVariable("eventNumber") Long eventNumber,
                                                                Pageable pageable) {
        return new ResponseEntity<>(this.logService.findByEventNumber(eventNumber, pageable),HttpStatus.OK);
    }

    @GetMapping("/eventLog/{eventLog}")
    @ApiOperation(value = "Returns a list of logs based on eventLog with no eventLog", response = LogNoEventLog.class)
    public ResponseEntity<List<LogNoEventLog>> getByEventLog(String log, Pageable pageable) {
        return new ResponseEntity<>(this.logService.findByEventLog(log, pageable), HttpStatus.OK);
    }

    @GetMapping("/createdAt/{createdAt}")
    @ApiOperation(value = "Returns a list of logs based on createdAt with no eventLog", response = LogNoEventLog.class)
    public ResponseEntity<List<LogNoEventLog>> getByCreatedAt(@PathVariable("createdAt") String createdAt,
                                                              Pageable pageable) {

        return new ResponseEntity<>(this.logService.findByCreatedAt(createdAt, pageable), HttpStatus.OK);
    }

    @GetMapping("/updatedAt/{updatedAt}")
    @ApiOperation(value = "Returns a list of logs based on updatedAt with no eventLog", response = LogNoEventLog.class)
    public ResponseEntity<List<LogNoEventLog>> getByUpdatedAt(@PathVariable("updatedAt") String updatedAt,
                                                              Pageable pageable) {

        return new ResponseEntity<>(this.logService.findByUpdatedAt(updatedAt, pageable), HttpStatus.OK);
    }

}
