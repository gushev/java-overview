package services;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public String getString(String ending) {
        return "This is some string with ending: " + ending;
    }

    public void throwsException() {
        throw new RuntimeException("All is well");
    }

    public String getStringAround(String beginning) {
        return beginning + " and some ending";
    }
}
