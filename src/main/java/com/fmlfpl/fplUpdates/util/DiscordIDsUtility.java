package com.fmlfpl.fplUpdates.util;
import java.util.HashMap;

public class DiscordIDsUtility {

    private static DiscordIDsUtility discordIDsUtility;
    //order: <key>fpl id, <value>discord id
    private HashMap<String, String> idMappings = new HashMap<String, String>();

    private DiscordIDsUtility(){
        //FMLFPL discord team names

        //Special
        this.idMappings.put("0", "AVERAGE");

        //Tier 1
        this.idMappings.put("55085", "@Lateriser12");
        this.idMappings.put("147364", "@thekünalmighty#4483");
        this.idMappings.put("2495", "@Dan R");
        this.idMappings.put("1078736", "@jimjims");
        this.idMappings.put("199288", "@Ricky Chubbs");
        this.idMappings.put("24362", "@RikkiTikkiTavi");
        this.idMappings.put("111896", "@Chuck Norwich");
        this.idMappings.put("109", "@Bennett");
        this.idMappings.put("151248", "@LukeFPL");
        this.idMappings.put("10779", "@Tío (Group 30)#7632 ");
        this.idMappings.put("114295", "@Aidan");
        this.idMappings.put("41603", "@eden");
        this.idMappings.put("394260", "@Sigurd");
        this.idMappings.put("30971", "@Mattseward");
        this.idMappings.put("56", "@Jono");
        this.idMappings.put("14133", "@Sebachoo");
        this.idMappings.put("139939", "@Camyeh");
        this.idMappings.put("6437", "@WaryPainter");
        this.idMappings.put("2242", "@Mars");

        //Tier 2
        this.idMappings.put("185655", "@SamVD");
        this.idMappings.put("125816", "@David");
        this.idMappings.put("524475", "@jonjon");
        this.idMappings.put("179118", "@upyourarsenal");
        this.idMappings.put("3692", "@Cerd");
        this.idMappings.put("63351", "@EricBisPresident");
        this.idMappings.put("214229", "@mike22b");
        this.idMappings.put("88104", "@Tribeca Tavern");
        this.idMappings.put("408554", "@balfski");
        this.idMappings.put("379021", "@Nashy");
        this.idMappings.put("43662", "@Aashir");
        this.idMappings.put("164352", "@Wiscker#2639");
        this.idMappings.put("38117", "@Allan St. Minimum");
        this.idMappings.put("39910", "@Paul M");
        this.idMappings.put("1137", "@Al");
        this.idMappings.put("105", "@Ryan Hemmings");
        this.idMappings.put("168323", "@jeffd");
        this.idMappings.put("7818", "@Henri");
        this.idMappings.put("3035", "@SoupsekJack");
        this.idMappings.put("7856", "@Jaca");

        //Tier 3
        this.idMappings.put("1892", "@Stewie");
        this.idMappings.put("677549", "@henners");
        this.idMappings.put("768", "@Rai");
        this.idMappings.put("108250", "@bradvibes");
        this.idMappings.put("10386", "@Alex (The Original)");
        this.idMappings.put("730446", "@poominator");
        this.idMappings.put("287952", "@desertbug");
        this.idMappings.put("19654", "@Joss");
        this.idMappings.put("285207", "@Bdan");
        this.idMappings.put("120822", "@James");
        this.idMappings.put("11664", "@Bodhi");
        this.idMappings.put("11143", "@PhenomenoN");
        this.idMappings.put("43572", "@Fearisor");
        this.idMappings.put("413", "@DoublyG");
        this.idMappings.put("373", "@Jeffrey");
        this.idMappings.put("139884", "@JENKO");
        this.idMappings.put("36361", "@Private KY");
        this.idMappings.put("7998", "@Roadmen");
        this.idMappings.put("135966", "@Canada Brad");
        this.idMappings.put("647340", "@Barik");

        //Tier 4
        this.idMappings.put("1203", "@Sheffy");
        this.idMappings.put("1664", "@Great Uncle Bulgaria");
        this.idMappings.put("265446", "@producer nate");
        this.idMappings.put("132568", "@serryjeinfeld#1296");
        this.idMappings.put("233819", "@PuckGremlin");
        this.idMappings.put("111556", "@ctyke");
        this.idMappings.put("3312", "@Scouse Brad");
        this.idMappings.put("9885", "@Baker");
        this.idMappings.put("722", "@Tim (Golanga's Knee)#3515");
        this.idMappings.put("297433", "@Quinn WP");
        this.idMappings.put("206", "@Gnar");
        this.idMappings.put("577137", "@jaywlkr");
        this.idMappings.put("522", "@Kuzco");
        this.idMappings.put("99715", "@Wolfgang Jones");
        this.idMappings.put("42749", "@Dad Lad");
        this.idMappings.put("1926237", "@DanteSly_");
        this.idMappings.put("18880", "@Luke_villa95");
        this.idMappings.put("59112", "@Sam serious");
        this.idMappings.put("510278", "@Al Rogers");
        this.idMappings.put("395066", "@Petrus de Jonge");

        //Tier 5
        this.idMappings.put("297900", "@liamnield");
        this.idMappings.put("85896", "@v ax");
        this.idMappings.put("14506", "@SK");
        this.idMappings.put("278521", "@frankenstein");
        this.idMappings.put("122940", "@Pengus");
        this.idMappings.put("2684", "@MattW");
        this.idMappings.put("136607", "@M-Bear");
        this.idMappings.put("6608", "@Simmple Mug");
        this.idMappings.put("670", "@RyeDale");
        this.idMappings.put("521894", "@Flem");
        this.idMappings.put("83724", "@espen");
        this.idMappings.put("2016", "@Faz");
        this.idMappings.put("292868", "@PMG");
        this.idMappings.put("189", "@A Really Good Guy");
        this.idMappings.put("2226", "@Fionn");
        this.idMappings.put("114074", "@vince");
        this.idMappings.put("96604", "@Dewitt");
        this.idMappings.put("386621", "@Neal");
        this.idMappings.put("45979", "@Scatterfold");
        this.idMappings.put("1533643", "@jackz");

        //Tier 6
        this.idMappings.put("709918", "@Emskilian");
        this.idMappings.put("763670", "@MattyO");
        this.idMappings.put("1390689", "@Dungacol");
        this.idMappings.put("233696", "@Drewsky27");
        this.idMappings.put("370768", "@Gingermou");
        this.idMappings.put("1470793", "@AussieRog");
        this.idMappings.put("133358", "@jack.gaynor");
        this.idMappings.put("28727", "@turrhall");
        this.idMappings.put("63977", "@MRTULES");
        this.idMappings.put("120022", "@alon");
        this.idMappings.put("309450", "@wherearemykeys");
        this.idMappings.put("228223", "@FrontwheelFenning");
        this.idMappings.put("753796", "@SBD023");
        this.idMappings.put("149850", "@BiggestDavide");
        //Six Tier 6 teams unaccounted for...

        //Tier 7
        this.idMappings.put("344442", "@Evan");
        this.idMappings.put("6915", "@DSilva's Jock Strap");
        this.idMappings.put("153920", "@monkman");
        this.idMappings.put("1649645", "@derekc");
        this.idMappings.put("784670", "@Camspan");
        this.idMappings.put("13578", "@Ozymandias");
        this.idMappings.put("1264", "@Matt");
        this.idMappings.put("90502", "@gordonboll");
        this.idMappings.put("159040", "@SB");
        this.idMappings.put("1856", "@TC");
        this.idMappings.put("2037161", "@Thom");
        this.idMappings.put("259159", "@Walshie");
        this.idMappings.put("186257", "@Miles#9504");
        this.idMappings.put("2343", "@Halfy");
        this.idMappings.put("509975", "@haime");
        this.idMappings.put("216442", "@S N Chill");
        this.idMappings.put("373638", "@Shaarson#9985");
        this.idMappings.put("276158", "@Jovan D");
        this.idMappings.put("18590", "@KevIRL");
        this.idMappings.put("96163", "@BedStuyBlake");

        //Tier 8
        this.idMappings.put("90914", "@Dalts");
        this.idMappings.put("2833", "@Jason");
        this.idMappings.put("391408", "@Peter_238");
        this.idMappings.put("210772", "@Beasley");
        this.idMappings.put("436834", "@QuiQonJim");
        this.idMappings.put("63026", "@Audun#9801");
        this.idMappings.put("3521", "@Jarde617");
        this.idMappings.put("17194", "@L Ron Cupboard");
        this.idMappings.put("211756", "@Brandon Moore");
        this.idMappings.put("74949", "@Hazza");
        this.idMappings.put("685501", "@Chester");
        this.idMappings.put("3920", "@JonnyD");
        this.idMappings.put("168012", "@chrisac11");
        this.idMappings.put("172291", "@Jorge Evs");
        this.idMappings.put("245220", "@guestjason");
        this.idMappings.put("276152", "@Jandyman");
        this.idMappings.put("1713", "@Vizhal007");
        this.idMappings.put("55728", "@pullup_and_kirttt");
        this.idMappings.put("191533", "@Jerry (#1272)");
        this.idMappings.put("137133", "@cfoley");

        //Tier 9
        this.idMappings.put("40946", "@Tom O#9146");
        this.idMappings.put("135898", "@Brycey");
        this.idMappings.put("398576", "@Joben");
        this.idMappings.put("345469", "@Midgame");
        this.idMappings.put("502596", "@MisterJD");
        this.idMappings.put("24717", "@HamFish");
        this.idMappings.put("155478", "@Krui (George)");
        this.idMappings.put("205473", "@Tyr1");
        this.idMappings.put("578942", "@Slim Charles");
        this.idMappings.put("200792", "@gbabinecz");
        this.idMappings.put("221077", "@Jonastry");
        this.idMappings.put("1528219", "@TheGreatWildGamu");
        this.idMappings.put("57509", "@Callum");
        this.idMappings.put("5230", "@pH__ #7812 (benerfe)");
        this.idMappings.put("4934", "@walsh");
        this.idMappings.put("185264", "@MaxLFGM");
        this.idMappings.put("127392", "@Gav");
        this.idMappings.put("10217", "@null");
        //Two teams unaccounted for in tier 9

        //Tier 10
        this.idMappings.put("33557", "@TB12PATSRULE");
        this.idMappings.put("2672", "@Graham");
        this.idMappings.put("89673", "@Bad Homberg - Delete team#5378 ");
        this.idMappings.put("379913", "@TJC");
        this.idMappings.put("103286", "@DreadFPL");
        this.idMappings.put("13431", "@Gylfi Pleasures");
        this.idMappings.put("5978", "@Aaron");
        this.idMappings.put("66390", "@Marianne");
        this.idMappings.put("893389", "@bling");
        this.idMappings.put("234793", "@ethridgenetz");
        this.idMappings.put("68188", "@Markaldinho_");
        this.idMappings.put("1257", "@Krisc");
        this.idMappings.put("2672", "@Alec Smalec");
        this.idMappings.put("3438", "@phatguerilla");
        this.idMappings.put("626424", "@Ryuller");
        this.idMappings.put("205214", "@Nickkkk");
        this.idMappings.put("12579", "@eggybread");
        this.idMappings.put("668841", "@billetico");
        //Two teams unaccounted for in tier 10

        //Tier 11
        this.idMappings.put("989352", "@ChinNation24");
        this.idMappings.put("171012", "@DarthAmol");
        this.idMappings.put("104267", "@Brad");
        this.idMappings.put("91618", "@hotcarrots#2410");
        this.idMappings.put("563254", "@Zach_");
        this.idMappings.put("603060", "@InSanÃ©");
        this.idMappings.put("197500", "@TonyL");
        this.idMappings.put("362620", "@fixda");
        this.idMappings.put("39683", "@kun");
        this.idMappings.put("134939", "@TomMartin#2385");
        this.idMappings.put("371149", "@mishka");
        this.idMappings.put("455106", "@Bob Loblaw");
        this.idMappings.put("56630", "@DrMisadventure");
        this.idMappings.put("17595", "@FIshyDishyGnollRoll");
        this.idMappings.put("344311", "@Decorus");
        this.idMappings.put("19926", "@Schick");
        this.idMappings.put("298650", "@DocTony");
        this.idMappings.put("817703", "@Kaneintheass");
        this.idMappings.put("2347320", "@PapaBless #5409");
    }

    public static DiscordIDsUtility getDiscordIDs(){
        if(discordIDsUtility == null){
            discordIDsUtility = new DiscordIDsUtility();
        }
        return discordIDsUtility;
    }

    public HashMap<String, String> getIdMappings() {
        return idMappings;
    }

    public void setIdMappings(HashMap<String, String> idMappings) {
        this.idMappings = idMappings;
    }

    public String getDiscordIDGivenFplID(int fplid){
        String idNotFound = "(UNKNOWN) FPL ID: " + fplid;

        if (this.getIdMappings().containsKey(Integer.toString(fplid))){
            return this.getIdMappings().get(Integer.toString(fplid));
        }
        else{
            return idNotFound;
        }
    }
}
