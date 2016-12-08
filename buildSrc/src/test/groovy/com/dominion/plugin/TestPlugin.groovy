package com.dominion.plugin

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class TestPlugin {
    @Test
    void testBuild(){
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply 'dominion.deploy'


        assert project.tasks.build
        assert project.tasks.deploy
    }
}