package kr.co.fastcampus.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RestaurantRepositoryImplTest {

    @Test
    public void save() {
        RestaurantRepository repository = new RestaurantRepositoryImpl();
        int oldCount = repository.findAll().size();

        Restaurant restaurant = new Restaurant("BeRyong", "Busan");
        repository.save(restaurant);
        int newCount = repository.findAll().size();

        assertThat(restaurant.getId(), is(1234L));
        assertThat(oldCount + 1, is(newCount));
    }
}