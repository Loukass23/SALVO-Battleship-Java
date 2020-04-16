package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String type;

    @OneToMany(mappedBy="player", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers = new HashSet<>();

    @ElementCollection
    @Column(name="ShipLocation")
    private List<String> locations = new ArrayList<>();

    public Ship() {}
    public Ship(String type, List<String> locations){
        this.type= type;
        this.locations=locations;
    }
    public String getShiptype(){
        return type;
    }
    public long getId(){
        return id;
    }
    public Set<GamePlayer> getGamePlayers(){
        return this.gamePlayers;
    }
}
