# SplashFX

SplashFX is a Java/Kotlin library that consist of an only class and enables developers to create beautiful splash screens.

## Table of contents

1. [About the project](#about-the-project)
   * [Built with](#built-with)
2. [Getting started](#getting-started)
   * [Prerequisites](#prerequisites)
   * [Installation](#installation)
3. [Usage](#usage)
4. [Contributing](#contributing)

## About the project

### Built with

This section lists all libraries and tools used for building the project

* [JavaFX]()
  * modules:
    * Base
    * Controls
    * Graphics
* [Gradle]()
* [Kotlin]()

## Getting started

For using this project you will need at least Gradle and JavaFX plugin.

### Prerequisites

1. add Maven Central to your gradle repositories:

<pre><code>repositories {
    ...
    mavenCentral()
    ...
}
</code></pre>

2. add JavaFX plugin and modules:

<pre><code>plugins {
    ...
    id 'org.openjfx.javafxplugin' version '${javafxplugin_version}'
    ...
}

javafx {
    version = '${javafx_version}'
    modules = ['javafx.controls', 'javafx.swing', '...']
}
</code></pre>

### Installation

SplashFX is available at Maven Central. You just need to add it to your dependencies:

<pre><code>dependencies {
    ...
    implementation 'ovh.vicart.splashfx:splashfx:1.0.1'
    ...
}
</code></pre>

## Usage

You can find a sample in this project's files. Also, here is an example of how to use:

<pre><code>val bfi: BufferedImage = ...
val splash = SplashFX.newSplashScreen(bfi)

splash.show() //shows splash screen
splash.dismiss() //closes the splash screen
</code></pre>

## Contributing

You are free to fork this project and add some cool features. Once your features added, commit and push. Then, open a pull request