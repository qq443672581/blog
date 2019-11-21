package cn.dlj1.blog.core.repository;

import cn.dlj1.blog.core.entity.Comment;
import cn.dlj1.blog.core.entity.User;
import cn.dlj1.blog.core.repository.ext.ExtJpaRepository;

/**
 *
 */
public interface CommentRepository extends ExtJpaRepository<Comment, Long> {

}
