package com.dominion.plugin.base.tasks;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tbrooks
 */
class PreCompileTest {

    @Test
    void testPrecompile(){
        Project project = ProjectBuilder.builder().withName("foo").build()
        project.pluginManager.apply 'dominion.deploy'

        assert project.tasks.preCompile
    }
}