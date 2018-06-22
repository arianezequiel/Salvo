package com.accenture.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Entity
public class Player
{
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;

    private String userName;

    public Player () {}

    public void setuserName(String userName)
    {
        this.userName = userName;
    }

    public String getuserName()
    {
        return userName;
    }

    public Player(String user)
    {
        this.userName=user;
    }

    @OneToMany(mappedBy="players", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers;

    public void addGamePlayer (GamePlayer players)
    {
        players.setPlayers(this);
        players.getPlayers();
    }

    @JsonIgnore


    public List<Game> getPlayers()
    {
        return gamePlayers.stream().map(sub -> sub.getGames()).collect(toList());
    }

}
