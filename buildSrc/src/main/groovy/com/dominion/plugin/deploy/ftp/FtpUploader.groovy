package com.dominion.plugin.deploy.ftp

import org.apache.commons.net.PrintCommandListener
import org.apache.commons.net.ftp.FTP
import org.apache.commons.net.ftp.FTPClient
import org.apache.commons.net.ftp.FTPClientConfig
import org.apache.commons.net.ftp.FTPSClient
import org.gradle.api.GradleException
import org.gradle.api.Project

/**
 * Created by trevor.brooks on 11/21/2016.
 */
class FtpUploader {

    static void uploadFilesByFtp(Project project, String location, FtpCredentials credentials) {
        FTP client = new FTPSClient("SSL")
        client.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)))

        FTPClientConfig config = new FTPClientConfig()
        client.configure(config)

        client.connect(credentials.url)
        client.enterLocalPassiveMode()


        def loginSuccess = client.login(credentials.username, credentials.password)
        if (!loginSuccess)
            throw new GradleException("Unable to login to ftp site.\nFtp url: ${credentials.url}\nFtp username: ${credentials.username}")

        client.setFileType(FTP.BINARY_FILE_TYPE)
        client.makeDirectory(location)
        project.file("${project.buildDir}/${project.name}").listFiles().each {
            uploadFile(client, it, location, "")
        }
    }

    static void uploadFile(FTPClient client, File file, String location, String path) {
        if (file.isDirectory()) {
            client.makeDirectory("${location}/${path}$file.name")
            for (File localFile : file.listFiles()) {
                uploadFile(client, localFile, location, path + "${file.name}/")
            }
        } else {
            println "Uploading ${file} to ${location}/${path}${file.name}"
            client.storeFile("${location}/${path}${file.name}", new FileInputStream(file))
        }
    }
}
