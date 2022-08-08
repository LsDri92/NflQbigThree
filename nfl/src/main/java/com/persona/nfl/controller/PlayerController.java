package com.persona.nfl.controller;
import com.persona.nfl.model.Player;
import com.persona.nfl.service.IPlayerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    
    @Autowired
    private IPlayerService interPlayer;
    
    @GetMapping ("/player/bring")
    public List<Player> getPlayer(){
        
        return interPlayer.getPlayer();
    }
    
    @PostMapping ("/player/create")
    public String createPlayer(@RequestBody Player play) {
        interPlayer.savePlayer(play);
        return "The player was succesfully created";
    }
    
    @DeleteMapping ("/player/delete/{id}")
    public String deletePlayer (@PathVariable Long id) {
        
        interPlayer.deletePlayer(id);
        
        return "The player was succesfully deleted";
    }
    
    @PutMapping ("/player/edit/{id}")
    public Player editPlayer (@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("apellido") String nuevoApellido,
                                @RequestParam ("edad") int nuevaEdad) {
        Player play = interPlayer.findPlayer(id);
        
        play.setApellido(nuevoApellido);
        play.setNombre(nuevoNombre);
        play.setEdad(nuevaEdad);
        
        interPlayer.savePlayer(play);
        
        return play;
    }
    
}