package fr.andrew.universite.universite_front.matiere.repository.impl;

import fr.andrew.universite.universite_front.matiere.domain.Matiere;
import fr.andrew.universite.universite_front.matiere.repository.IMatiereRepository;
import fr.andrew.universite.universite_front.utils.repository.url;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class MatiereRepositoryImpl implements IMatiereRepository {

    private RestTemplate restTemplate = new RestTemplate();
    private String urlMatieres = url.urlF.getUrl() + "matieres/";


    @Override
    public List<Matiere> findAll() {
        return restTemplate.exchange(urlMatieres, HttpMethod.GET, null, new ParameterizedTypeReference<List<Matiere>>() {
        }).getBody();
    }

    @Override
    public Matiere getOne(Integer id) {
        return restTemplate.getForObject(urlMatieres+id, Matiere.class);
    }

    @Override
    public Matiere add(Matiere matiere) {
        return restTemplate.postForObject(urlMatieres, matiere, Matiere.class);
    }

    @Override
    public Void update(Matiere matiere, Integer id) {
        restTemplate.put(urlMatieres+id, matiere, Matiere.class);
        return null;
    }

    @Override
    public Void delete(Integer id) {
        restTemplate.delete(urlMatieres+id);
        return null;
    }
}
