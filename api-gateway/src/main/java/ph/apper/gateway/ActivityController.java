package ph.apper.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ph.apper.gateway.payload.Activity;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("activity")
public class ActivityController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityController.class);
    private final RestTemplate restTemplate;
    private final App.GCashMiniProperties gCashMiniProperties;

    public ActivityController(RestTemplate restTemplate, App.GCashMiniProperties gCashMiniProperties) {
        this.restTemplate = restTemplate;
        this.gCashMiniProperties = gCashMiniProperties;
    }

    @GetMapping
    public ResponseEntity<List<Activity>> getAll() {
        ResponseEntity<Activity[]> response = restTemplate.getForEntity(gCashMiniProperties.getActivityUrl(), Activity[].class);
        if (response.getStatusCode().is2xxSuccessful()) {
            List<Activity> activities = Arrays.asList(response.getBody());
            return ResponseEntity.ok(activities);
        } else{
//            LOGGER.info(String.valueOf(response.getStatusCode()));
            LOGGER.info("Error: " +response.getStatusCode());
        }

        return ResponseEntity.status(response.getStatusCode()).build();
    }

}
