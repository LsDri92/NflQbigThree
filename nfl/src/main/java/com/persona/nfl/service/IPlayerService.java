
package com.persona.nfl.service;

import com.persona.nfl.model.Player;
import java.util.List;


public interface IPlayerService {
     public List<Player> getPlayer ();
    
    public void savePlayer (Player play);
    
    public void deletePlayer (Long id);
    
    public Player findPlayer (Long id);
}
