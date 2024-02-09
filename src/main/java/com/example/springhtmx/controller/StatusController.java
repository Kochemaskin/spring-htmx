package com.example.springhtmx.controller;


import com.example.springhtmx.model.State;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class StateController {

    public static final int PAGE_LIMIT = 15;

    private static final List<State> statuses = List.of(
            new State(1, "@ElizaMaze", "Elizabeth Mason", "Explored the city streets 🏙️ #UrbanAdventures"),
            new State(2, "@RobinTrail", "Martin Robinson", "Trailblazing with Martin 🚵 #AdventureBuddies"),
            new State(3, "@DaringDave", "David Robertson", "Lost in a world of wonders 🌍 #ExplorerSpirit"),
            new State(4, "@CarrieCharm", "Carrie Miller", "Turned ordinary into extraordinary ✨ #CharmCrafting"),
            new State(5, "@EdenExplorer", "Eden Shaw", "Seeking hidden gems in the city 💎 #UrbanTreasureHunt"),
            new State(6, "@StellarAndrew", "Andrew Shaw", "Stargazing with Andrew 🌌 #NightSkyMagic"),
            new State(7, "@QuantumEthan", "Ethan Watson", "Quantum leaps of fun with Ethan ⚡ #DynamicDays"),
            new State(8, "@BlazeBruce", "Bruce Hunt", "Hunting for urban legends 🕵️ #CityMyths"),
            new State(9, "@SonicSimpson", "Daniel Simpson", "Sonic adventures with Bruce 🏎️ #SpeedsterLife"),
            new State(10, "@RossRiddle", "Ross Richardson", "Solved mysteries with Daniel 🔍 #SleuthingDays"),
            new State(11, "@FoxFable", "Alfie Fox", "Fox tales and urban trails 🦊 #FoxFables"),
            new State(12, "@YasmineVoyage", "Yasmine Kelly", "Voyaging with Yasmine ⛵ #WanderlustSoul"),
            new State(13, "@EvelynEnigma", "Evelyn Reynolds", "Enigmatic moments with Evelyn ❓ #MysteryUnveiled"),
            new State(14, "@KieranKnight", "Kieran Jones", "Knightly adventures with Kieran ⚔️ #ModernKnight"),
            new State(15, "@WardGreg", "Greg Ward", "Guardian of the Ward district 🏰 #WardGuard"),
            new State(16, "@UrbanAndrew", "Andrew Campbell", "Urban tales with Andrew 📖 #CityChronicles"),
            new State(17, "@DylanWanderer", "Dylan Mitchell", "Wandering with Dylan 🚶 #CityRoamer"),
            new State(18, "@WhiteErin", "Erin White", "Erin's white city adventures ☁️ #UrbanWhiteness"),
            new State(19, "@MooreVortex", "Greg Moore", "Vortex of experiences with Greg 🌀 #LifeInCircles"),
            new State(20, "@ClarkeLuminous", "Lucy Clarke", "Luminous moments with Lucy ✨ #CityRadiance"),
            new State(21, "@BellFinley", "Finley Bell", "Exploring the city on a bicycle 🚴 #CityExplorer"),
            new State(22, "@ImogenDreamer", "Imogen Lewis", "Dreaming of faraway places ✈️ #Wanderlust"),
            new State(23, "@JakeAdventures", "Jake Marshall", "Adventures in the urban jungle 🌆 #CityExplorer"),
            new State(24, "@AlexanderExplorer", "Alexander Baker", "Discovering hidden gems in the city 💎 #UrbanAdventures"),
            new State(25, "@TiffanyTravels", "Tiffany Holmes", "Traveling the world one city at a time 🌍 #GlobalNomad"),
            new State(26, "@ArchieAdventurer", "Archie Mason", "Being a modern-day adventurer ⚓ #ModernExplorer"),
            new State(27, "@DanielleDiscover", "Danielle Reid", "Discovering new places and faces 🗺️ #ExplorerLife"),
            new State(28, "@RubyWanderlust", "Ruby Patel", "Wandering with Ruby in the urban wilderness 🏙️ #CityWanderer"),
            new State(29, "@JustineJourney", "Justine Adams", "Embarking on a journey of self-discovery 🌟 #JourneyWithin"),
            new State(30, "@JuliaUrbanite", "Julia Robertson", "Embracing the urban lifestyle with Julia 🏙️ #Urbanite"),
            new State(31, "@DylanHiker", "Dylan Hill", "Hiking through city trails and skyscrapers 🏞️ #UrbanHiker"),
            new State(32, "@SelinaRoams", "Selina Roberts", "Roaming the city streets with Selina 🚶 #CityRoamer"),
            new State(33, "@JackCityscape", "Jack Ellis", "Capturing the cityscape through Jack's lens 📸 #CityscapePhotography"),
            new State(34, "@NatalieNomad", "Natalie Matthews", "Living the nomadic life with Natalie 🌍 #NomadicSpirit"),
            new State(35, "@BrandonUrban", "Brandon Holmes", "Urban adventures with Brandon 🏙️ #CityAdventures"),
            new State(36, "@VickyVoyager", "Vicky Moore", "Voyaging through the urban jungle 🚀 #UrbanVoyager"),
            new State(37, "@OliviaWanderer", "Olivia Wilson", "Wandering and wondering with Olivia 🌄 #WonderWander"),
            new State(38, "@AmyCityChic", "Amy Davis", "Embracing the chic side of the city with Amy 💄 #CityChic"),
            new State(39, "@JosephExplorer", "Joseph Hunt", "Exploring the city's secrets with Joseph 🔍 #UrbanDiscoveries"),
            new State(40, "@MartinAdventures", "Martin Baker", "Adventures abound with Martin ⛰️ #AdventurousSpirit")




            );
    @GetMapping("/feed")
    public String getFeed(Model model) {
        model.addAttribute("statuses", statuses.subList(0, PAGE_LIMIT));
        return "feed";
    }

    @GetMapping("/statuses")
    public String getStatuses(@RequestParam("page")Integer page, Model model) {
        if (page > 4) {
            model.addAttribute("statuses", Collections.<State>emptyList());
            model.addAttribute("link", "/statuses?page=5");
            return "statuses";
        }
        var to = page * PAGE_LIMIT;
        var from = to - PAGE_LIMIT;
        model.addAttribute("statuses", statuses.subList(from, to));
        model.addAttribute("link", "/statuses?page=" + (page + 1));
        return "statuses";
    }
}