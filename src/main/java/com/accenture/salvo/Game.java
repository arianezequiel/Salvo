package com.accenture.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Entity
public class Game
{
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    Date getDate()
    {
        return date;
    }
    void setDate(Date date)
    {
        this.date = date;
    }

    Date date;

    public  Game (Date date)
    {
        this.date=date;
    }

    @OneToMany(mappedBy="games", fetch=FetchType.EAGER)
    Set<GamePlayer>  gamePlayers;

    public void addGamePlayer (GamePlayer games)
    {
        games.setGames(this);
        games.getGames();
    }
    @JsonIgnore

    public List<Player> getGames()
    {
        return gamePlayers.stream().map(sub -> sub.getPlayers()).collect(toList());
    }


}