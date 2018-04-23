buildscript {
    val kotlin_version: String = parent!!.properties["kotlin_version"] as String

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

apply{
    plugin('kotlin-platform-common')
}

repositories {
    mavenCentral()
    jcenter()
}

val kotlin_version: String = parent!!.properties["kotlin_version"] as String
dependencies {
    "compile"("org.jetbrains.kotlin:kotlin-stdlib-common:$kotlin_version")
}