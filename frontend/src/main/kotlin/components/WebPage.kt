package components

import containers.CarsList
import containers.Details
import containers.carsListConnector
import containers.detailsConnector
import react.*
import react.dom.div
import react.dom.h2
import react.dom.h3
import react.dom.hr
import redux.connectRedux

class WebPage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div {
            h2{+"Cars"}
            connectRedux<CarsList>(carsListConnector){}
            hr {  }
            h3{+"Details"}
            connectRedux<Details>(detailsConnector){}
            //details()
        }
    }
}

fun RBuilder.webPage() = child(WebPage::class) {}