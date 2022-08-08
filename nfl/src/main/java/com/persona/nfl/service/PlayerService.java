package com.persona.nfl.service;

import com.persona.nfl.model.Player;
import com.persona.nfl.repository.PlayerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements IPlayerService {

    @Autowired
    private PlayerRepository playRepository;

    @Override
    public List<Player> getPlayer() {
        List<Player> playerList = playRepository.findAll();
        return playerList;
    }

    @Override
    public void savePlayer(Player play) {
        playRepository.save(play);

    }

    @Override
    public void deletePlayer(Long id) {
        playRepository.deleteById(id);
    }

    @Override
    public Player findPlayer(Long id) {
        Player play = playRepository.findById(id).orElse(null);
        return play;
    }
}
