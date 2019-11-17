package cn.dlj1.blog.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "tag")
public class Tag extends IdEntity {

    @Column(unique = true)
    private String title;

//    @OrderBy("id asc")
//    @ManyToMany(mappedBy = "tags")
//    @JsonIgnoreProperties({"tags"})
//    private List<Article> articles;
}


