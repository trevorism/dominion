package com.dominion.plugin.base.tasks

import org.gradle.api.tasks.Copy

/**
 * Created by trevor.brooks on 11/12/2016.
 */
class PreCompile extends Copy {

    PreCompile() {
        from("${project.projectDir}/src")
        into("$project.buildDir/$project.name")
    }
}
