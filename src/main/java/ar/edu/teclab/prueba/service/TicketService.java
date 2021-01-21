package ar.edu.teclab.prueba.service;

//<editor-fold defaultstate="collapsed" desc="imports">
import ar.edu.teclab.prueba.dto.Comment;
import ar.edu.teclab.prueba.dto.Comments;
import java.util.Base64;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
//</editor-fold>

/**
 *
 * @author Francisco Castillo
 */
@Service
public class TicketService {

    //<editor-fold defaultstate="collapsed" desc="fields">
    private final static String URI = "https://teclab1593636133.zendesk.com/api/v2/tickets/";
    private final static String PATH = "/comments";
    
    RestTemplate restTemplate = new RestTemplate();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getTicketsComments(int ticketId)">
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
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URI + "/" + ticketId + PATH)
                    .queryParam("sort_order", "desc");

            response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, Comments.class);

        } catch (HttpStatusCodeException e) {
            throw e;
        }

        List<Comment> lstComments = response.getBody().getComments();

        return lstComments;
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="addComment(int id, String comment)">
    public String addComment(int id, String comment) {
        String authStr = "username:password";
        String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // create request
        HttpEntity request = new HttpEntity<>(comment, headers);

        String path = URI + "/" + id;

        ResponseEntity<String> response = restTemplate.exchange(path, HttpMethod.PUT, request, String.class);

        return response.getBody();
    }//</editor-fold>

}
