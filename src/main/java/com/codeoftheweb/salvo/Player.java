package com.codeoftheweb.salvo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String userName;
    private String passWord;
    @OneToMany(mappedBy="player", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers = new HashSet<>();

    public Player() {}
    public Player(String userName, String passWord){
        this.userName= userName;
        this.passWord= passWord;
    }

    public void addGamePlayer(GamePlayer gameplayer) {
        gamePlayers.add(gameplayer);
    }
    public Set<GamePlayer> getGamePlayers(){
        return this.gamePlayers;
    }
    /*public List<Game> getGames() {
        return gamePlayers.stream().map(sub -> sub.getGame()).collect(Collectors.toList());
    }*/

    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return passWord;
    }
    public  String getPlayer(){
        return userName;
    }
    public long getId(){
        return id;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPassword(String passWord){
        this.passWord =passWord;
    }

}
