/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.teclab.prueba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fcastillo
 */

public class Comment {

    private Long id;
    private String type;
    private Long author_id;
    private String body;
    private String html_body;
    private String plain_body;
    @JsonProperty(value = "public")
    private boolean publico;
    private Object[] attachments;
    private Long audit_id;
    private Object via;
    private Date created_at;
    private Object metadata;

    public Comment() {
    }

    public Comment(Long id, String type, Long author_id, String body, String html_body, String plain_body, boolean publico, Object[] attachments, Long audit_id, Object via, Date created_at, Object metadata) {
        this.id = id;
        this.type = type;
        this.author_id = author_id;
        this.body = body;
        this.html_body = html_body;
        this.plain_body = plain_body;
        this.publico = publico;
        this.attachments = attachments;
        this.audit_id = audit_id;
        this.via = via;
        this.created_at = created_at;
        this.metadata = metadata;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHtml_body() {
        return html_body;
    }

    public void setHtml_body(String html_body) {
        this.html_body = html_body;
    }

    public String getPlain_body() {
        return plain_body;
    }

    public void setPlain_body(String plain_body) {
        this.plain_body = plain_body;
    }

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }

    public Object[] getAttachments() {
        return attachments;
    }

    public void setAttachments(Object[] attachments) {
        this.attachments = attachments;
    }

    public Long getAudit_id() {
        return audit_id;
    }

    public void setAudit_id(Long audit_id) {
        this.audit_id = audit_id;
    }

    public Object getVia() {
        return via;
    }

    public void setVia(Object via) {
        this.via = via;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }
   
    
}
