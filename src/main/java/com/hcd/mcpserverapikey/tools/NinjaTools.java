package com.hcd.mcpserverapikey.tools;

import com.hcd.mcpserverapikey.service.NinjaService;
import com.hcd.mcpserverapikey.service.NinjaService.NinjaStrengths;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

@Component
public class NinjaTools {

    private final NinjaService ninjaService;

    public NinjaTools(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @McpTool(name = "get-ninja-character-strengths",
            description = "Provides the strength of the Ninja character with the indicated name")
    public NinjaStrengths ninjaStrengths(@McpToolParam(description = "The Ninja character name") String name) {
        return ninjaService.strengthsByName(name);
    }
}
