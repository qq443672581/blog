package cn.dlj1.blog.core.api;

import cn.dlj1.blog.core.api.query.PageQuery;
import cn.dlj1.blog.core.api.vo.PageVO;
import cn.dlj1.blog.core.entity.Tag;
import cn.dlj1.blog.core.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
* 标签
*
* @auth fivewords(443672581@qq.com)
* @date 2019/11/16 11:30
*/
@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public PageVO<Tag> list(PageQuery query) {
        Page<Tag> page = tagRepository.findAll(query.toPageable());
        return PageVO.of(page);
    }

    @GetMapping("/{id}")
    public Tag detail(@PathVariable("id") Long id) {
        Tag tag = tagRepository.getOne(id);
        return tag;
    }

    @PostMapping
    public Long insert(@RequestBody Tag tag) {
        Tag save = tagRepository.save(tag);
        return save.getId();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Tag tag) {
        tagRepository.dynamicUpdate(id, tag);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        tagRepository.deleteById(id);
    }

}
