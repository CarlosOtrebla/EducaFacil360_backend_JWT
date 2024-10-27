package com.otrebla.educa_facil_360.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data // Gera os getters, setters, toString, equals e hashCode
public class PageResponseDTO<T> {
    private Long totalElements;
    private Integer totalPages;
    private Integer size;
    private List<T> content;
    
    public PageResponseDTO(Page<T> page) {
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.size = page.getSize();
        this.content = page.getContent();
    }
    
    public Boolean isEmpty() {
        return this.content.isEmpty();
    }
}
