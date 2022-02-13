package dev.vivekts.jer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/jer")
@Slf4j
public class JERController {

    @GetMapping("/{value}")
    public Mono<ResponseEntity<String>> check(@PathVariable int value) {
        if (value % 2 == 0) {
            return Mono.just(ResponseEntity.ok("Everything's alright!!!"));
        } else {
            log.error("Reporting Error ", new IllegalArgumentException("Value " + value));
            return Mono.just(ResponseEntity.ok("Reporting Error!!!"));
        }
    }
}
