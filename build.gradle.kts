// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.androidApplication) version Plugins.Versions.androidApplication apply false
    id(Plugins.kotlinAndroid) version Plugins.Versions.kotlinAndroid apply false
    id(Plugins.daggerHilt) version Plugins.Versions.daggerHilt apply false
    id(Plugins.ksp) version Plugins.Versions.ksp apply false
}