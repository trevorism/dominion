package com.dominion.plugin.base

import com.dominion.plugin.base.tasks.PreCompile

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.BasePlugin

/**
 * Created by trevor.brooks on 11/12/2016.
 */
class BuildPlugin implements Plugin<Project> {

    void apply(Project project) {
        project.apply plugin: 'base'

        project.task('preCompile', type: PreCompile) {
            group = BasePlugin.BUILD_GROUP
            description = "Moves relevant code into $project.buildDir"
        }
    }
}