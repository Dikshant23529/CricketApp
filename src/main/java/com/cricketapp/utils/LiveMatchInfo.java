package com.cricketapp.utils;

import java.time.LocalDate;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricketapp.entities.UpcommingMatches;
import com.cricketapp.repositories.UpcommingMatchesRepo;

@Service
public class LiveMatchInfo {

    @Autowired
    private UpcommingMatchesRepo upcommingMatchesRepo;

    public static final String url = "https://www.cricbuzz.com/cricket-match/live-scores/upcoming-matches";

    public void live_match_info() {

        try {
            Connection connection = Jsoup.connect(url);
            Document document = connection.get();
            Elements match_Element = document.select("div.cb-mtch-lst.cb-col.cb-col-100.cb-tms-itm");

            for (Element matchElement : match_Element) {
                String matchTitle = matchElement.select("h3.cb-lv-scr-mtch-hdr a").text();
                String matchType = matchElement.select("span.text-gray").first().text();
                String matchDate = LocalDate.now().toString();
                String matchTime = matchElement.select("span.ng-binding").text();
                String matchVenue = matchElement.select("div.text-gray").last().text();
                String matchUrl = "https://www.cricbuzz.com"
                        + matchElement.select("h3.cb-lv-scr-mtch-hdr a").attr("href");

                UpcommingMatches upcommingMatches = new UpcommingMatches();

                upcommingMatches.setMatchTime(matchTime);
                upcommingMatches.setMatchVenue(matchVenue);
                upcommingMatches.setMatchType(matchType);
                upcommingMatches.setMatchTitle(matchTitle);
                upcommingMatches.setMatchDate(matchDate);
                upcommingMatches.setMatchUrl(matchUrl);
                upcommingMatches.setStatus(true);

                upcommingMatchesRepo.save(upcommingMatches);

            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
