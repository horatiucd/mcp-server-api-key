package com.hcd.mcpserverapikey.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class NinjaService {

    public NinjaStrengths strengthsByName(String name) {
        return switch (name) {
            case "lloyd" -> new NinjaStrengths("Lloyd Garmadon – Green Ninja (Life)",
                    List.of("Leadership", "Adaptability", "Courage"));
            case "kai" -> new NinjaStrengths("Kai – Fire Ninja (Fire)",
                    List.of("Determination", "Fearlessness", "Loyalty"));
            case "jay" -> new NinjaStrengths("Jay Walker – Lightning Ninja (Lightning)",
                    List.of("Creativity", "Agility", "Humor"));
            case "cole" -> new NinjaStrengths("Cole – Earth Ninja (Earth)",
                    List.of("Balance", "Stability", "Resilience"));
            case "zane" -> new NinjaStrengths("Zane – Ice Ninja (Ice)",
                    List.of("Intelligence", "Compassion", "Generosity"));
            case "nya" -> new NinjaStrengths("Nya – Water Ninja (Water)",
                    List.of("Independence", "Adaptability", "Curiosity"));
            default -> new NinjaStrengths();
        };
    }

    public record NinjaStrengths(String name, List<String> strengths) {
        public NinjaStrengths() {
            this("Unknown", Collections.emptyList());
        }
    }
}
