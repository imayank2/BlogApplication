package com.blogApplication.service.service;

import com.blogApplication.model.model.Blog;
import com.blogApplication.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public Page<Blog> getAllBlogs(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Long id, Blog blogDetails) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        blog.setTitle(blogDetails.getTitle());
        blog.setContent(blogDetails.getContent());
        blog.setAuthor(blogDetails.getAuthor());

        return blogRepository.save(blog);
    }
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
