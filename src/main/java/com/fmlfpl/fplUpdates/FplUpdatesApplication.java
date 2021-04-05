package com.fmlfpl.fplUpdates;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fmlfpl.fplUpdates.mappings.Result;
import com.fmlfpl.fplUpdates.mappings.Standings;
import com.fmlfpl.fplUpdates.reports.LeagueReport;
import com.fmlfpl.fplUpdates.reports.LeagueStandingsReport;
import com.fmlfpl.fplUpdates.reports.MatchReport;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class FplUpdatesApplication {

	// For readability
	public static final String LINEBREAK = "==============================================================<br/>";
	public static final String DIVIDER = "-------------------------------------------<br/>";
	public static final String BREAK = " <br/>";

	// For building api url
	public final String URLbase = "https://fantasy.premierleague.com/api/leagues-h2h-matches/league/";
	public String URLpageParam = "/?page=";
	public String URLeventParam = "&event=";

	// Will hold the information in each league
	public List<Result> listResults;
	public List<Standings> listStandings;
	public LeagueReport leagueReport;
	public MatchReport matchReport;
	public LeagueStandingsReport leagueStandingsReport;
	public String pageContent;

	private void reset(){
		pageContent = "";
		leagueReport = new LeagueReport();
		leagueStandingsReport = new LeagueStandingsReport();
		matchReport = new MatchReport();
		listResults = new ArrayList<Result>();
		listStandings = new ArrayList<Standings>();
	}

	@RequestMapping("/league/{leagueID}/gw/{gameweekID}")
	@ResponseBody
	String createLeagueResponse(@PathVariable String leagueID, @PathVariable String gameweekID){
		reset(); //Otherwise the totals will be cumulative if someone reloads the page

		String rawSummary = fetchRawSummary(leagueID);
		populateSummary(rawSummary);

		//TODO - handle pagination, fine for now as leagues are capped at 20 teams
		String rawResults = fetchRawResults(leagueID, "1", gameweekID);
		populateResults(rawResults);

		createReports(listResults, listStandings);
		populatePageContent();

		return pageContent;
	}

	private String fetchRawResults(String league, String page, String gw){
		String endpoint = URLbase + league + URLpageParam + page + URLeventParam + gw;


		Document doc = null;
		try {
			Connection connection = Jsoup.connect(endpoint);
			//Theres a bug in the library where ignore content type needs to be set or an error is thrown
			doc = Jsoup.connect(endpoint).ignoreContentType(true).get();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Something went wrong fetching the json...");
		}

		//kludge, this is very brittle if the structure changes, dropping the metadata and just returning the json array
		return doc.body().toString().substring(doc.body().toString().indexOf("["), (doc.body().toString().indexOf("]}") + 1));
	}

	private String fetchRawSummary(String league){
		String endpointPrefix = "https://fantasy.premierleague.com/api/leagues-h2h/";
		String endpointSuffix = "/standings/?page_new_entries=1&page_standings=1";

		String endpoint = endpointPrefix + league + endpointSuffix;

		Document doc = null;
		try {
			doc = Jsoup.connect(endpoint).ignoreContentType(true).get();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Something went wrong fetching the json...");
		}

		//Leaguename is outside the json object, grabbing it from the metadata
		String leagueName = doc.body().toString();
		int startIndex = leagueName.indexOf("\"name\":\"");
		leagueName = leagueName.substring(startIndex + 8);
		leagueName = leagueName.substring(0, leagueName.indexOf("\""));
		leagueStandingsReport.LeagueName = leagueName;

		String completeResponse =  doc.body().toString();
		String truncatedToStandings = completeResponse.substring(completeResponse.indexOf("standings"));
		return truncatedToStandings.substring(truncatedToStandings.indexOf("[{"), truncatedToStandings.indexOf("}]") + 2);
	}

	private void populateResults(String rawResponse){
		ObjectMapper mapper = new ObjectMapper();
		try {
			listResults = mapper.readValue(rawResponse, new TypeReference<List<Result>>() {
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Something went wrong with the object mapper when reading hth match");
		}
	}

	private void populateSummary(String rawSummary){
		ObjectMapper mapper = new ObjectMapper();
		try {
			listStandings = mapper.readValue(rawSummary, new TypeReference<List<Standings>>() {
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Something went wrong with the object mapper when reading league summary data");
		}
	}

	private void createReports(List<Result> results, List<Standings> standings){
		for(Standings s : standings){
			leagueStandingsReport.process(s);
		}

		for (Result r : results){
			leagueReport.process(r.getEntry_1_points(), r.getEntry_1_name(), r.getEntry_2_points(), r.getEntry_2_player_name());
			matchReport.process(r);
		}
	}

	private void populatePageContent(){
		pageContent += leagueReport.printReport();
		pageContent += leagueStandingsReport.printReport();
		pageContent += matchReport.printReport();
	}

	public static void main(String[] args) {
		System.out.println(LINEBREAK);
		System.out.println("Starting Application...");
		System.out.println(LINEBREAK);
		SpringApplication.run(FplUpdatesApplication.class, args);
	}
}
