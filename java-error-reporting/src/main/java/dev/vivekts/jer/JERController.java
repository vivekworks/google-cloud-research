package dev.vivekts.jer;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.logging.Logger;

@RestController
@RequestMapping("/jer")
public class JERController {

    private static final Logger LOGGER = Logger.getLogger(JERController.class.getName());


    @GetMapping("/{value}")
    public Mono<ResponseEntity<String>> check(@PathVariable int value) throws Exception {
        if (value % 2 == 0) {
            return Mono.just(ResponseEntity.ok("Everything's alright!!!"));
        } else {
            try (Logging logging = LoggingOptions.getDefaultInstance().getService()) {
                String textPayload = "Reporting error because of value " + value;
                LogEntry entry =
                        LogEntry.newBuilder(Payload.StringPayload.of(textPayload))
                                .setSeverity(Severity.ERROR)
                                .setLogName(LOGGER.getName())
                                .setResource(MonitoredResource.newBuilder("global").build())
                                .build();
                logging.write(Collections.singleton(entry));
            }
            return Mono.just(ResponseEntity.ok("Reporting Error!!!"));
        }
    }
}
