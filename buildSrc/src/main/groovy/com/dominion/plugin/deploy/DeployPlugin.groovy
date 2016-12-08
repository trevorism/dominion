package com.dominion.plugin.deploy

import com.dominion.plugin.deploy.tasks.Deploy
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by trevor.brooks on 11/14/2016.
 */
class DeployPlugin implements Plugin<Project> {

    private static final String DEPLOY_GROUP = "deploy"

    @Override
    void apply(Project project) {
        project.apply plugin: 'dominion.build'

        project.task("deploy", type: Deploy) {
            dependsOn "build"
            description = "Uploads code to yahoo"
            group = DEPLOY_GROUP
        }

    }

}
