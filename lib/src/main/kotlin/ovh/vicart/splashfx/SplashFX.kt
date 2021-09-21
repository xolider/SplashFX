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

class SplashFX private constructor() {

    var background: WritableImage? = null

    private val stage = Stage(StageStyle.UNDECORATED)

    private constructor(image: Image) : this() {
        val img: BufferedImage = if(image is BufferedImage) {
            image
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

    private constructor(root: Parent) : this() {
        constructStage(Scene(root))
    }

    private constructor(background: WritableImage) : this() {
        this.background = background
        constructSceneWithBackground()
    }

    private fun constructSceneWithBackground() {
        val anchor = AnchorPane()
        val image = ImageView(background)
        anchor.children.add(image)
        anchor.prefWidth = background!!.width
        anchor.prefHeight = background!!.height
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
        fun newSplashScreen(background: WritableImage) = SplashFX(background)
        fun newSplashScreen(background: Image) = SplashFX(background)
        fun newSplashScreen(background: BufferedImage) = SplashFX(background)
        fun newSplashScreen(root: Parent) = SplashFX(root)
    }
}