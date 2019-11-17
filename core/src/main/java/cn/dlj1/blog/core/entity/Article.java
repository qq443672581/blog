package cn.dlj1.blog.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Getter
@Setter
@Entity(name = "article")
public class Article extends DateEntity {

    private String title;

    private String memo;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String content;

    @OrderBy("id asc")
    @ManyToMany
    @JoinTable(name = "article_tag_rl",
            joinColumns = {@JoinColumn(name = "article_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "tag_id", nullable = false, updatable = false)})
    @JsonIgnoreProperties({"articles"})
    private List<Tag> tags;

    public void addTag(Tag tag) {
        if (null == tags) {
            tags = new ArrayList<>();
        }
        this.tags.add(tag);
    }

}
