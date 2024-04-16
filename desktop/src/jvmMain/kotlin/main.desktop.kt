import setup.setupThemedNavigation
import javax.swing.SwingUtilities
import javax.swing.JFrame

fun main() = SwingUtilities.invokeLater {
    PlatformSDK.init(
        configuration = PlatformConfiguration()
    )

    JFrame().setupThemedNavigation()
}