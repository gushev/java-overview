import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.DemoService;

public class Main {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            DemoService service = context.getBean(DemoService.class);
            String result = service.getString("ENDING");
            System.out.println(result);

            System.out.println("--------------");

            try {
                service.throwsException();
            } catch (RuntimeException e) {
                System.out.println(e);
            }

            System.out.println("--------------");

            String aroundResult = service.getStringAround("Some beginning");
            System.out.println(aroundResult);
        }
    }
}
