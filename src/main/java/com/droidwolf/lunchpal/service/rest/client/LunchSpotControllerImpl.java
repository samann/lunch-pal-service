package com.droidwolf.lunchpal.service.rest.client;

import com.droidwolf.lunchpal.service.domain.LunchSpot;
import com.droidwolf.lunchpal.service.protocol.LunchSpotDto;
import com.droidwolf.lunchpal.service.protocol.VoteDto;
import com.droidwolf.lunchpal.service.rest.api.LunchSpotController;
import com.droidwolf.lunchpal.service.rest.service.LunchSpotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/lunchspots", produces = APPLICATION_JSON_VALUE)
public class LunchSpotControllerImpl implements LunchSpotController {
    private final LunchSpotService lunchSpotService;

    public LunchSpotControllerImpl(LunchSpotService lunchSpotService) {
        this.lunchSpotService = lunchSpotService;
    }

    @Override
    @GetMapping(path = "/{lunchSpotId}")
    public List<LunchSpot> getAllLunchSpotsInGroup(@PathVariable("lunchSpotId") UUID groupId) {
        return lunchSpotService.getAllLunchSpotsForGroup(groupId);
    }

    @Override
    @PutMapping(path = "/{lunchSpotId}", consumes = APPLICATION_JSON_VALUE)
    public LunchSpot voteForLunchSpot(@PathVariable("lunchSpotId") UUID lunchSpotId, @RequestBody VoteDto vote) {
        return lunchSpotService.voteForLunchSpot(lunchSpotId, vote.getUserId());
    }

    @Override
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public LunchSpot createLunchSpot(@RequestBody LunchSpotDto lunchSpotDto) {
        return lunchSpotService.create(lunchSpotDto);
    }
}
