package block.blockapp.service;

import block.blockapp.model.Title;
import block.blockapp.repository.ITitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TitleService implements ITitleService {
    @Autowired
    ITitleRepository titleRepository;
    @Override
    public Page<Title> findAll(Pageable pageable) {
        return titleRepository.findAll(pageable);
    }

    @Override
    public Optional<Title> findById(Integer id) {
        return titleRepository.findById(id);
    }

    @Override
    public void save(Title title) {
    titleRepository.save(title);
    }

    @Override
    public void remove(Integer id) {
    titleRepository.deleteById(id);
    }

    @Override
    public Page<Title> findAllByTitle(Pageable pageable, String key) {
        return null;
    }
}
