package com.example.cinemahe.utils;

import com.example.cinemahe.data.CaheTicketRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static java.time.LocalDateTime.now;

@Service
public class CaheTicketRequestCache
{
    private final Map<UUID, CaheTicketRequest> cache = new HashMap<>();

    @Scheduled(fixedDelay = 100_000)
    public void removeStale()
    {
        for (Map.Entry<UUID, CaheTicketRequest> uuidCaheTicketRequestEntry : cache.entrySet())
        {
            if (uuidCaheTicketRequestEntry.getValue().getCreationDate().isBefore(now().minusDays(1)))
            {
                cache.remove(uuidCaheTicketRequestEntry.getKey());
            }
        }
    }

    public void add(final CaheTicketRequest request)
    {
        cache.put(request.getUuid(), request);
    }

    public void remove(final CaheTicketRequest request)
    {
        cache.remove(request.getUuid());
    }

    public CaheTicketRequest returnAndRemove(final UUID uuid)
    {
        final CaheTicketRequest caheTicketRequest = cache.get(uuid);
        cache.remove(uuid);

        return caheTicketRequest;
    }
}
