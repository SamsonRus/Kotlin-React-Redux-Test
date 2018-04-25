package components

import containers.carsList
import containers.details
import react.*
import react.dom.div
import react.dom.h2
import react.dom.h3
import react.dom.hr


class WebPage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div {
            h2{+"Cars"}
            carsList()
            hr {  }
            h3{+"Details"}
            details()
        }
    }
}

fun RBuilder.webPage() = child(WebPage::class) {}