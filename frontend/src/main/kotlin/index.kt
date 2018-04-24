import components.webPage
import kotlin.browser.document
import react.dom.div
import react.dom.render

fun main(args: Array<String>) {
    render(document.getElementById("root")) {
        div {
            webPage()
        }
    }
}