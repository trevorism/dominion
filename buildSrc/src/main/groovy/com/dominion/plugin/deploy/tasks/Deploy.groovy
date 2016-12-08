package com.dominion.plugin.deploy.tasks

import com.dominion.plugin.deploy.ftp.FtpCredentials
import com.dominion.plugin.deploy.ftp.FtpUploader
import org.gradle.api.internal.ConventionTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by trevor.brooks on 11/14/2016.
 */
class Deploy extends ConventionTask {

    String location

    @TaskAction
    void deploy() {
        FtpCredentials credentials = new FtpCredentials()
        uploadFilesByFtp(credentials)
    }

    void uploadFilesByFtp(FtpCredentials credentials) {
        if(!location)
            location = "trev"
        FtpUploader.uploadFilesByFtp(project, location, credentials)
    }


}
