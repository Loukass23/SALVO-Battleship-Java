package com.codeoftheweb.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GamePlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private Date createDate;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="game_id")
    private Game game;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="player_id")
    private Player player;

    public GamePlayer(){};
    public GamePlayer(Game game, Player player, Date date){
        this.game= game;
        this.player=player;
        this.createDate=date;
    }
    public void setGame(Game game){
        this.game = game;
    }
    public long getId(){return id;}
    public Date getCreateDate(){return createDate;}
    @JsonIgnore
    public Game getGame() {
        return game;
    }
    @JsonIgnore
    public Player getPlayer() {
        return player;
    }
}
