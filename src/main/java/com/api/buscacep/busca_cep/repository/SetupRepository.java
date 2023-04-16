package com.api.buscacep.busca_cep.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.api.buscacep.busca_cep.model.Endereco;

@Repository
public class SetupRepository {

    @Value("${setup.base.url}")
    private String url;

    public List<Endereco> getListaEnderecos() throws IOException{

    ArrayList<Endereco> listEnderecos = new ArrayList<>();
        String result = "";
        
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(new HttpGet(this.url));
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);

            // HttpClient client = HttpClient.newHttpClient();
            // HttpRequest request = HttpRequest.newBuilder()
            //                                 .GET()
            //                                 .uri(URI.create(this.url))
            //                                 .build();

            // HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            // HttpEntity entity = response.get;
            // result = EntityUtils.toString(entity);
            
            
        } catch (Exception e) {}

        String[] resultSplit = result.split("\n"); 

        for (String linha : resultSplit) {
            String[] linhaSplit = linha.split(",");
            var endereco = new Endereco(
                linhaSplit[0],
                linhaSplit[1],
                linhaSplit[2],
                StringUtils.leftPad(linhaSplit[3], 8, "0"),
                linhaSplit.length > 4 ? linhaSplit[4]: null
                );

            listEnderecos.add(endereco);

        }

        return listEnderecos;
    }
}
