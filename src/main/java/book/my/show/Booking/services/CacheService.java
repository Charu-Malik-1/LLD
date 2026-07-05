package book.my.show.Booking.services;

import org.springframework.stereotype.Service;

@Service
public interface CacheService {
    public void set(String key,Object value);

    public Object get(String key);

    public void delete(String key);

    public void getAllKeysAndValues();
    void deleteAll();
}
