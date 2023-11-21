package com.spotify.javaspotifyapi.Controller;

import com.spotify.javaspotifyapi.Client.Album;
import com.spotify.javaspotifyapi.Client.AlbumSpotifyClient;
import com.spotify.javaspotifyapi.Client.AuthSpotifyClient;
import com.spotify.javaspotifyapi.Client.LoginRequest;
import org.apache.el.parser.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
public class AlbumController {


    private final AuthSpotifyClient authSpotifyClient;
    private final AlbumSpotifyClient albumSpotifyClient;

    public AlbumController(AuthSpotifyClient authSpotifyClient, AlbumSpotifyClient albumSpotifyClient) {
        this.authSpotifyClient = authSpotifyClient;
        this.albumSpotifyClient = albumSpotifyClient;
    }


    @GetMapping("/albums")
    public ResponseEntity<List<Album>> hello(){
        var request = new LoginRequest(
                "client_credentials",
                "e1b5ac545c4248b98e001ea057ec274c",
                "eb7c8728856d4657bbfd3ed6dbb006fa"
        );
        var token = authSpotifyClient.login(request).getAccessToken();
        var response = albumSpotifyClient.getReleases("Bearer "+ token);


        return ResponseEntity.ok(response.getAlbums().getItems());
    }

}
