package ovh.vicart.splashfx

import javafx.embed.swing.SwingFXUtils
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.image.ImageView
import javafx.scene.image.WritableImage
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage
import javafx.stage.StageStyle
import java.awt.Color
import java.awt.Image
import java.awt.image.BufferedImage

class SplashFX {

    var background: WritableImage? = null

    private val stage = Stage(StageStyle.UNDECORATED)

    private constructor(image: Image) {
        val img: BufferedImage = if(image is BufferedImage) {
            image as BufferedImage
        }
        else {
            val bfi = BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB)
            val graphics = bfi.createGraphics()
            graphics.drawImage(image, 0, 0, null)
            graphics.dispose()
            bfi
        }
        background = SwingFXUtils.toFXImage(img, null)
        constructSceneWithBackground()
    }

    private constructor() {
        val bfi = BufferedImage(600, 400, BufferedImage.TYPE_INT_ARGB)
        val graphics = bfi.createGraphics()
        graphics.paint = Color(76, 31, 166)
        graphics.fillRect(0, 0, bfi.width, bfi.height)
        graphics.dispose()
        background = SwingFXUtils.toFXImage(bfi, null)
        constructSceneWithBackground()
    }

    private constructor(root: Parent) {
        constructStage(Scene(root))
    }

    private fun constructSceneWithBackground() {
        val anchor = AnchorPane()
        val image = ImageView(background)
        anchor.children.add(image)
        constructStage(Scene(anchor))
    }

    private fun constructStage(scene: Scene) {
        stage.scene = scene
        stage.centerOnScreen()
        stage.isResizable = false
    }

    fun show() {
        stage.show()
    }

    fun dismiss() {
        stage.close()
    }

    companion object {
        fun newSplashScreen() = SplashFX()
        fun newSplashScreen(background: Image) = SplashFX(background)
        fun newSplashScreen(background: BufferedImage) = SplashFX(background)
        fun newSplashScreen(root: Parent) = SplashFX(root)
    }
}