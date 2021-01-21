package ar.edu.teclab.prueba.controller;

//<editor-fold defaultstate="collapsed" desc="imports">
import ar.edu.teclab.prueba.dto.Comment;
import ar.edu.teclab.prueba.service.TicketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
//</editor-fold>

/**
 *
 * @author Francisco Castillo
 */
@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    //<editor-fold defaultstate="collapsed" desc="fields">
    @Autowired
    private TicketService ticketService;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getComments(int ticket_id)">
    @GetMapping("/{ticket_id}/comments")
    public ResponseEntity getComments(@PathVariable("ticket_id") int ticket_id) {
        try {

            List<Comment> ticketComments = ticketService.getTicketComments(ticket_id);

            return ResponseEntity.status(HttpStatus.OK).body(ticketComments);

        } catch (HttpStatusCodeException e) {
            return ResponseEntity.badRequest().body(e.getResponseBodyAsString());
        }

    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="addComments(int ticket_id, String ticket)">
    @PutMapping("/{ticket_id}")
    public ResponseEntity addComments(@PathVariable int ticket_id, @RequestBody String ticket) {
        String result = ticketService.addComment(ticket_id, ticket);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }//</editor-fold>

}
