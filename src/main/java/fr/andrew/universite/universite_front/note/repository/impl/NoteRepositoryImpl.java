package fr.andrew.universite.universite_front.note.repository.impl;

import fr.andrew.universite.universite_front.matiere.domain.Matiere;
import fr.andrew.universite.universite_front.note.domain.Note;
import fr.andrew.universite.universite_front.note.repository.INoteRepository;
import fr.andrew.universite.universite_front.utils.repository.url;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class NoteRepositoryImpl implements INoteRepository {

    private RestTemplate restTemplate = new RestTemplate();
    private String urlNote = url.urlF.getUrl() + "notes/";

    @Override
    public List<Note> findAll() {
        return restTemplate.exchange(urlNote, HttpMethod.GET, null, new ParameterizedTypeReference<List<Note>>() {
        }).getBody();
    }

    @Override
    public Note add(Note note) {
        return restTemplate.postForObject(urlNote, note, Note.class);
    }
}
