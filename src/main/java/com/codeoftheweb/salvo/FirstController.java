package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FirstController {

    @Autowired
    private GameRepository repo;

    @RequestMapping("/games")
    public List<Map> getAll() {
        List<Map> allGames = new ArrayList<>();
       repo.findAll().forEach( oneGame -> {
           allGames.add(makeGameDTO(oneGame));
               }
       );
        return allGames;
}
private Map<String, Object> makeGameDTO(Game game) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
       dto.put("id", game.getGameId());
        dto.put("date", game.getGameDate());
        dto.put("gamePlayer", game.getGamePlayers().stream().map(gameplayer->
            gameplayer.getPlayer()
        ));
    return dto;
    }

}