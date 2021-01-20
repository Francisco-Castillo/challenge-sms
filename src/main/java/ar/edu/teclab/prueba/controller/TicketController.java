/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.teclab.prueba.controller;

import ar.edu.teclab.prueba.config.Credencial;
import ar.edu.teclab.prueba.dto.Comment;
import ar.edu.teclab.prueba.dto.Comments;
import ar.edu.teclab.prueba.dto.Ticket;
import ar.edu.teclab.prueba.service.TicketService;
import ar.edu.teclab.prueba.utilidades.CommentsList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author fcastillo
 */
@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/{ticket_id}/comments")
    public ResponseEntity getComments(@PathVariable("ticket_id") int ticket_id) {
        try {

            List<Comment> ticketComments = ticketService.getTicketComments(ticket_id);

            return ResponseEntity.status(HttpStatus.OK).body(ticketComments);

        } catch (HttpStatusCodeException e) {
            return ResponseEntity.badRequest().body(e.getResponseBodyAsString());
        }

    }

    @PutMapping("/{ticket_id}")
    public ResponseEntity addComments(@PathVariable int ticket_id, @RequestBody String ticket) {
        String result = ticketService.addComment(ticket_id, ticket);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
