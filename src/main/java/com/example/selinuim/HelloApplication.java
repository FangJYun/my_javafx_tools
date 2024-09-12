package com.example.selinuim;

import com.example.selinuim.fxmlview.HomeView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import de.felixroske.jfxsupport.SplashScreen;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @apiNote 主入口
 * @author admin
 */
@SpringBootApplication
public class HelloApplication extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        //加载动画
        SplashScreen splashScreen = new SplashScreen() {
            @Override
            public String getImagePath() {
                return "/images/javafx.png";
            }
        };
        launch(HelloApplication.class, HomeView.class, splashScreen, args);
    }

    @Override
    public void beforeInitialView(Stage stage, ConfigurableApplicationContext ctx) {
        stage.setTitle("fjy小工具");
        stage.setWidth(900);
        stage.setHeight(600);
//        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
//        stage.setScene(scene);

    }

}