package com.stupidsquad.webapp.service;

import com.stupidsquad.webapp.config.StupidSquadConfig;
import com.stupidsquad.webapp.dto.EventsDTO;
import com.stupidsquad.webapp.dto.EventsInputDTO;
import com.stupidsquad.webapp.dto.RaidPlanDTO;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RaidHelperService {

    private final StupidSquadConfig webClient;

    @Value("${api.raidplan.uri}")
    private String raidPlanUrl;

    @Value("${api.events.uri}")
    private String eventsUrl;

    @Value("${api.serverid}")
    private String serverId;

    @Value("${api.apikey}")
    private String apiKey;

    @Autowired
    public RaidHelperService(StupidSquadConfig webClient) {
        this.webClient = webClient;
    }

    public RaidPlanDTO getRaidPlan(long eventId) {
        String uri = raidPlanUrl.replace("{eventid}", String.valueOf(eventId));
        return webClient.stupidSquandWebClient()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(RaidPlanDTO.class)
                .block();
    }

    public EventsDTO getEvents(EventsInputDTO input) {
        String uri = eventsUrl.replace("{serverid}", serverId);
        return webClient.stupidSquandWebClient()
                .get()
                .uri(uri)
                .header("Authorization", apiKey)
                .header("Page", input.getPage() == null ? "" : String.valueOf(input.getPage()))
                .header("ChannelFilter", input.getChannelFilter())
                .header("IncludeSignUps", input.getIncludeSignUps() == null ? "" : String.valueOf(input.getIncludeSignUps()))
                .header("StartTimeFilter", input.getStartTimeFilter() == null ? "" : String.valueOf(input.getStartTimeFilter()))
                .header("EndTimeFilter", input.getEndTimeFilter() == null ? "" : String.valueOf(input.getEndTimeFilter()))
                .retrieve()
                .bodyToMono(EventsDTO.class)
                .block();
    }
}
