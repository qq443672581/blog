package cn.dlj1.blog.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import java.util.List;

@Getter
@Setter
@Entity(name = "tag")
public class Tag extends IdEntity {

    private String title;

    @OrderBy("id asc")
    @ManyToMany(mappedBy = "tags")
    @JsonIgnoreProperties({"tags"})
    private List<Article> articles;
}


