package com.accenture.salvo;

import com.accenture.salvo.Game;
import com.accenture.salvo.Player;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GamePlayer
{

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    public Player getPlayers() {
        return players;
    }

    public void setPlayers(Player players){
        this.players = players;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    private Player players;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game games;

    public GamePlayer() {
    }

    public Game getGames() {
        return games;
    }

    public void setGames(Game games) {
        this.games = games;
    }

    public GamePlayer(Game games, Player players) {
        this.games = games;
        this.players = players;
    }
}