package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;
    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("test").build();
        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);
    }

    @Test
    void updateBeer() {
        UUID uuid = UUID.randomUUID();
        BeerDto beerDto = BeerDto.builder().id(uuid).beerName("test").build();
        client.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCostumerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewCustomer() {

        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).build();
        URI uri = client.saveNewCustomer(customerDto);

        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {

        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).build();
        client.updateCustomer(UUID.randomUUID(),customerDto);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());

    }
}