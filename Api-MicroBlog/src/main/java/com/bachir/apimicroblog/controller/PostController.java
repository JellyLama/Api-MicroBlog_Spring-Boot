/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bachir.apimicroblog.controller;

import com.bachir.apimicroblog.domain.Post;
import com.bachir.apimicroblog.service.PostService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Bachir_Karim
 */
@RestController
@RequestMapping("/posts")
public class PostController
{
    @Autowired
    PostService postService;
    
    @ApiOperation(value = "returns all the posts")
    @RequestMapping(method = RequestMethod.GET)
    public List<Post> getPosts()
    {
        return postService.getAllPosts();
    }
    
    @ApiOperation(value = "returns a post by an id")
    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Post getPostById(@ApiParam@PathVariable("id") Long postId)
    {
        return postService.getPostById(postId);
    }
    
    @ApiOperation(value = "adds a post in the database")
    @RequestMapping(method = RequestMethod.POST)
    public void addPost(@ApiParam@RequestBody Post post)
    {
        postService.insertPost(post);
    }
    
    @ApiOperation(value = "deletes a post by an id")
    @RequestMapping(method = RequestMethod.DELETE,value = "/deletepost/{id}")
    public void deletePostById(@ApiParam@PathVariable("id") Long postId)
    {
        postService.deletePostById(postId);
    }
    
}
