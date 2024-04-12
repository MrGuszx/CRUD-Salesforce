package service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import dao.Dao;
import model.Usuario;

public class ViaCepService {
	
	public void InserirEndereco(Usuario u) {  
        String query = String.format("INSERT INTO tb_usuario(cep,uf,localidade) VALUES('%s','%s','%s')",u.getCep(), u.getUf(), u.getLocalidade());
        Dao.InsertUpdateDeleteCommand(query);
    }
	
	public Usuario getEndereco(String cep) throws ClientProtocolException, IOException {
	       
        Usuario endereco = null;
       
        HttpGet request = new HttpGet("https://viacep.com.br/ws/"+cep+"/json/");
       
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
               
                CloseableHttpResponse response = httpClient.execute(request)) {
           
            HttpEntity entity = response.getEntity();
           
            if(entity != null) {
               
                String result = EntityUtils.toString(entity);
               
                Gson gson = new Gson();
               
                endereco = gson.fromJson(result, Usuario.class);
            }
        }
       
        return endereco;
    }

}
