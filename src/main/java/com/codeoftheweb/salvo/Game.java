package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private Date createDate;

    @OneToMany(mappedBy="game", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers = new HashSet<>();

    public void addGamePlayer(GamePlayer gameplayer) {
        gameplayer.setGame(this);
        gamePlayers.add(gameplayer);
    }

    public Set<GamePlayer> getGamePlayers(){
        return this.gamePlayers;
    }

    public Game() {};
    public Game(Date date){
        this.createDate= date;
    }
    public String getGameDate(){
        return createDate.toString();
    }
   /* public Date getDate(){
        return createDate;
    }*/

    public long getGameId(){
        return id;
    }
}
