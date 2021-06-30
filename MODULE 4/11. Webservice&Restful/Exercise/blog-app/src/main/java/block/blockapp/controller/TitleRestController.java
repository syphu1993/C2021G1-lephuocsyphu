package block.blockapp.controller;

import block.blockapp.model.Title;
import block.blockapp.service.ITitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/restTitle")
@RestController
public class TitleRestController {
    @Autowired
    private ITitleService titleService;
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Title>> getListTitle(Pageable pageable){
        Page<Title> titles = titleService.findAll(pageable);
        if (titles.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(titles,HttpStatus.OK);
    }
}
