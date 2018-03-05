package com.droidwolf.lunchpal.service.rest.service;

import com.droidwolf.lunchpal.service.dao.GetDao;
import com.droidwolf.lunchpal.service.dao.GetUpdateDeleteDao;
import com.droidwolf.lunchpal.service.domain.LunchSpot;
import com.droidwolf.lunchpal.service.domain.User;
import com.droidwolf.lunchpal.service.protocol.LunchSpotDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class LunchSpotService {
    private final GetUpdateDeleteDao<UUID, LunchSpot> lunchSpotDao;
    private final GetDao<UUID, User> getUserDao;

    public LunchSpotService(GetUpdateDeleteDao<UUID, LunchSpot> lunchSpotGetUpdateDeleteDao, GetDao<UUID, User> getUserDao) {
        this.lunchSpotDao = lunchSpotGetUpdateDeleteDao;
        this.getUserDao = getUserDao;
    }

    public List<LunchSpot> getAllLunchSpotsForGroup(UUID groupId) {
        return lunchSpotDao.getAll()
                .stream()
                .filter(lunchSpot -> lunchSpot.getGroupId().equals(groupId))
                .collect(toList());
    }

    public LunchSpot create(LunchSpotDto lunchSpotDto) {
        LunchSpot lunchSpot = new LunchSpot(lunchSpotDto);
        lunchSpotDao.save(lunchSpot.getId(), lunchSpot);
        return lunchSpot;
    }

    public LunchSpot voteForLunchSpot(UUID lunchSpotId, UUID userId) {
        User user = getUserDao.get(userId);

        if (user == null) {
            return null;
        }

        LunchSpot lunchSpot = lunchSpotDao.get(lunchSpotId);

        if (lunchSpot == null) {
            return null;
        }

        lunchSpot.getRating().incScore(user);

        lunchSpotDao.save(lunchSpotId, lunchSpot);

        return lunchSpot;
    }


}
