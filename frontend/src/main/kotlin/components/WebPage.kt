package components

import containers.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h2
import react.dom.h3
import react.dom.hr
import redux.connectRedux

class WebPage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div {
            h2 { +"Cars" }
            connectRedux<CarsList, CarsListRProps>(carsListConnector) {}
            hr { }
            h3 { +"Details" }
            connectRedux<Details, DetailsRProps>(detailsConnector) {}
        }
    }
}

fun RBuilder.webPage() = child(WebPage::class) {}