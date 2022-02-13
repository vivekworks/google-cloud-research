package dev.vivekts.jer;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/jer")
public class JERController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JERController.class);


    @GetMapping("/{value}")
    public ResponseEntity<String> check(@PathVariable int value) throws Exception {
        if (value % 2 == 0) {
            return ResponseEntity.ok("Everything's alright!!!");
        } else {
            LOGGER.error("Reporting Error on JERController " + value);
            return ResponseEntity.ok("Reporting Error!!!");
        }
    }
}
