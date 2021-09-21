package ovh.vicart.splashfx.sample

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.image.WritableImage
import javafx.stage.Stage
import ovh.vicart.splashfx.SplashFX
import java.awt.image.BufferedImage
import java.net.URL
import javax.imageio.ImageIO

class SampleMain : Application() {

    override fun start(primaryStage: Stage) {
        primaryStage.title = "Main stage"
        primaryStage.scene = Scene(FXMLLoader().apply {
            location = javaClass.classLoader.getResource("mainstage.fxml")
        }.load())

        SplashFX.newSplashScreen(ImageIO.read(URL("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/250px-Image_created_with_a_mobile_phone.png"))).show()
    }
}

fun main() {
    Application.launch(SampleMain::class.java)
}