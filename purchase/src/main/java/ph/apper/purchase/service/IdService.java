package ph.apper.purchase.service;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class IdService {

    public static String generateCode(int size) {
        return RandomStringUtils.randomAlphanumeric(size);
    }

}