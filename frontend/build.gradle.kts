
buildscript {
    val html_version: String = properties["html_version"] as String
    val kotlin_frontend_version: String = properties["kotlin_frontend_version"] as String
    val kotlin_react_version: String = properties["kotlin_react_version"] as String
    val kotlin_version: String = parent!!.properties["kotlin_version"] as String

    repositories {
        jcenter()
        maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("org.jetbrains.kotlin:kotlin-frontend-plugin:$kotlin_frontend_version")
    }
}

apply {
    plugin: 'kotlin2js'
    plugin: 'org.jetbrains.kotlin.frontend'
    plugin: 'kotlin-platform-js'
}

repositories {
    mavenLocal()
    jcenter()
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven { setUrl("https://kotlin.bintray.com/kotlin-js-wrappers") }
}

val kotlin_frontend_version: String = properties["kotlin_frontend_version"] as String
val html_version: String = properties["html_version"] as String
val kotlin_react_version: String = properties["kotlin_react_version"] as String
val kotlin_version: String = parent!!.properties["kotlin_version"] as String
dependencies {
    "compile"(kotlin("stdlib-js", kotlin_frontend_version))
    "compile"("org.jetbrains.kotlin:kotlin-stdlib-js:$kotlin_version")
    "compile"("org.jetbrains:kotlin-react:$kotlin_react_version")
    "compile"("org.jetbrains:kotlin-react-dom:$kotlin_react_version")
    "compile"("org.jetbrains.kotlinx:kotlinx-html-js:$html_version")

    expectedBy project(":common")
}

configure<KotlinFrontendExtension>{

    downloadNodeJsVersion = "latest"

    sourceMaps = true

    configure<NpmExtension> {
        dependency("style-loader")
        dependency("css-loader")
        dependency("url-loader")
        dependency("img-loader")

        dependency("react")
        dependency("react-dom")
        dependency("react-router")
        dependency("redux")
        dependency("react-redux")
        dependency("redux-thunk")
        dependency("redux-devtools-extension")
        dependency("jquery")
        dependency("react-markdown")

        devDependency("babel-loader")
        devDependency("babel-core")
    }


    bundle("webpack", delegateClosureOf<WebPackExtension> {
        publicPath = "/frontend/"
        port = 8088

        bundleName = "main"
        sourceMapEnabled = true
        contentPath = file('src/web')
    }
}

val compileKotlin2Js: Kotlin2JsCompile by tasks

compileKotlin2Js.kotlinOptions {
    metaInfo = true
    outputFile = "${project.buildDir.path}/js/${project.name}.js"
    sourceMap = true
    sourceMapEmbedSources = "always"
    moduleKind = "commonjs"
}

task("copyToBuild"){
    doLast{
        copy {
            exclude("**/*.kt")
            from("src/main/kotlin")
            into('build/js/client')
        }
    }
}