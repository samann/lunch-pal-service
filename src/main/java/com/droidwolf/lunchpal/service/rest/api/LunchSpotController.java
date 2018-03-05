package com.droidwolf.lunchpal.service.rest.api;

import com.droidwolf.lunchpal.service.domain.LunchSpot;
import com.droidwolf.lunchpal.service.protocol.LunchSpotDto;
import com.droidwolf.lunchpal.service.protocol.VoteDto;

import java.util.List;
import java.util.UUID;

public interface LunchSpotController {
    List<LunchSpot> getAllLunchSpotsInGroup(UUID groupId);

    LunchSpot voteForLunchSpot(UUID lunchSpotId, VoteDto voteDto);

    LunchSpot createLunchSpot(LunchSpotDto lunchSpot);
}
