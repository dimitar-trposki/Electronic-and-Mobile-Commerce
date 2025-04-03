package mk.ukim.finki.emc.lv1a.service.application.impl;

import mk.ukim.finki.emc.lv1a.dto.CreateAuthorDto;
import mk.ukim.finki.emc.lv1a.dto.DisplayAuthorDto;
import mk.ukim.finki.emc.lv1a.service.application.AuthorApplicationService;
import mk.ukim.finki.emc.lv1a.service.domain.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorApplicationServiceImpl implements AuthorApplicationService {
    private final AuthorService authorService;

    public AuthorApplicationServiceImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public List<DisplayAuthorDto> findAll() {
        return DisplayAuthorDto.from(authorService.findAll());
    }

    @Override
    public Optional<DisplayAuthorDto> findById(Long id) {
        return authorService.findById(id).map(DisplayAuthorDto::from);
    }

    @Override
    public Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto authorDto) {
        return authorService.update(id, authorDto.toAuthor()).map(DisplayAuthorDto::from);
    }

    @Override
    public Optional<DisplayAuthorDto> save(CreateAuthorDto createAuthorDto) {
        return authorService.save(createAuthorDto.toAuthor()).map(DisplayAuthorDto::from);
    }

    @Override
    public void deleteById(Long id) {
        authorService.deleteById(id);
    }
}
