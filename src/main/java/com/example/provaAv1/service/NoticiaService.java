package com.example.provaAv1.service;

import com.example.provaAv1.model.NoticiaEntity;
import com.example.provaAv1.model.ReleaseEntity;
import com.example.provaAv1.repository.NoticiaRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;
    public String buscaNoticia() {
        String apiURL = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=noticia";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            String responseBody = responseEntity.getBody();
            NoticiaEntity noticiaEntity = new NoticiaEntity();

            noticiaEntity.setResponseBody(responseBody);
            noticiaRepository.save(noticiaEntity);
            return responseBody;
        }else{
            return "nao foi possivel buscar as noticias";
        }
    }

    public NoticiaEntity insereir(NoticiaEntity noticia) {
        return noticiaRepository.save(noticia);
    }

    public String buscaNoticiaRelease() {
        String apiURL = "https://servicodados.ibge.gov.br/api/v3/noticias";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            String responseBody = responseEntity.getBody();

            return responseBody;
        }else{
            return "nao foi possivel buscar as noticias e as releases";
        }
    }
}


//FAVOR DESCONSIDERAR, DEIXEI AQUI PARA REALIZAR UM NOVO PROJETO EM CASA

//JSONArray noticiasArray = new JSONArray(responseBody);

            /*for(int i = 0 ; i < noticiasArray.length() ; i++){
                JSONObject noticiaObj = noticiasArray.getJSONObject(i);
                String id = noticiaObj.getString("id");
                String tipo = noticiaObj.getString("tipo");
                String titulo = noticiaObj.getString("titulo");
                String introducao = noticiaObj.getString("introducao");
                String data_Publicacao = noticiaObj.getString("data_publicacao");
                String produto_id = noticiaObj.getString("produto_id");
                String produtos = noticiaObj.getString("produtos");
                String editoriais = noticiaObj.getString("editoriais");
                String imagens = noticiaObj.getString("imagens");

                NoticiaEntity noticiaEntity = new NoticiaEntity();
                noticiaEntity.setId(id);
                noticiaEntity.setTipo(tipo);
                noticiaEntity.setTitulo(titulo);
                noticiaEntity.setIntroducao(introducao);
                noticiaEntity.setData_Publicacao(data_Publicacao);
                noticiaEntity.setProduto_id(produto_id);
                noticiaEntity.setProdutos(produtos);
                noticiaEntity.setEditoriais(editoriais);
                noticiaEntity.setImagens(imagens);

                noticiaRepository.save(noticiaEntity);*/
//}