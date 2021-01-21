
package ar.edu.teclab.prueba.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author Francisco Castillo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comments {

    @JsonProperty("comments")
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
