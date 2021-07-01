package block.blockapp.controller;

import block.blockapp.model.Blog;
import block.blockapp.model.Title;
import block.blockapp.service.IBlogService;
import block.blockapp.service.ITitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/restBlog")
@RestController
@CrossOrigin
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ITitleService titleService;

//    @ModelAttribute("titles")
//    public Page<Title> showTitles(Pageable pageable){
//        return titleService.findAll(pageable);
//    }

    @GetMapping(value = {"/","/list"})
    public ResponseEntity<Page<Blog>> getListBlog(@PageableDefault(size = 2) Pageable pageable){
        Page<Blog> blogList = blogService.findAll(pageable);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
     @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Optional<Blog>> getDetailBlog(@PathVariable Integer id){
        Optional<Blog> blog = blogService.findById(id);
        if (blog==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
         return new ResponseEntity<>(blog,HttpStatus.OK);
     }

     @GetMapping(value = "/findByTitle")
    public ResponseEntity<Page<Blog>> getBlogByTitle(@PageableDefault(size = 2)Pageable pageable,
                                                     @RequestParam Optional<String> key){
         String keyValue="";
         if (key.isPresent()){
             keyValue = key.get();
         }
         Page<Blog> blogs=blogService.findAllByTitle(pageable,keyValue);
         if (blogs.isEmpty()){
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }
         return new ResponseEntity<>(blogs,HttpStatus.OK);
     }
}
