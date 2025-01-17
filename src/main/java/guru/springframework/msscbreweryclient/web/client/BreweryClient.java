package guru.springframework.msscbreweryclient.web.client;


import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery",ignoreUnknownFields = false)
public class BreweryClient {

    private final String BEER_PATH_V2="/api/v2/beer";
    private final String CUSTOMER_PATH = "/api/v1/customer";
    private String apiHost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apiHost+BEER_PATH_V2+ "/" +uuid.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apiHost + BEER_PATH_V2  ,beerDto);
    }

    public void updateBeer(UUID uuid,BeerDto beerDto){
         restTemplate.put(apiHost + BEER_PATH_V2 + "/"+ uuid.toString(),beerDto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(apiHost + BEER_PATH_V2 + "/"+ uuid.toString());
    }



    public CustomerDto getCustomerById(UUID uuid){
        System.out.println(apiHost+CUSTOMER_PATH);

        return restTemplate.getForObject(apiHost+CUSTOMER_PATH+"/"+uuid.toString(),CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto){
        System.out.println(apiHost + CUSTOMER_PATH);
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH  ,customerDto);
    }

    public void updateCustomer(UUID uuid,CustomerDto customerDto){
        restTemplate.put(apiHost + CUSTOMER_PATH + "/"+ uuid.toString(),customerDto);
    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(apiHost + CUSTOMER_PATH + "/"+ uuid.toString());
    }

    public void setApiHost(String apiHost){
        this.apiHost = apiHost;
    }
}
