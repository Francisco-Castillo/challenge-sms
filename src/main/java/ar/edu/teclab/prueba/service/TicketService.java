/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.teclab.prueba.service;

import ar.edu.teclab.prueba.dto.Comment;
import ar.edu.teclab.prueba.dto.Comments;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author fcastillo
 */
@Service
public class TicketService {

    private final static String URI = "https://teclab1593636133.zendesk.com/api/v2/tickets/";
    private final static String PATH = "/comments";

    RestTemplate restTemplate = new RestTemplate();

    public List<Comment> getTicketComments(int ticketId) {
        //String authStr = credencial.getUsername().concat(":").concat(credencial.getPassword());
        String authStr = "username:password";
        String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);

        // create request
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<Comments> response = null;

        try {
            response = restTemplate.exchange(URI + "/" + ticketId + PATH, HttpMethod.GET, request, Comments.class);
        } catch (HttpStatusCodeException e) {
            throw e;
        }

        List<Comment> lstComments = response.getBody().getComments();

        return lstComments;
    }

}
