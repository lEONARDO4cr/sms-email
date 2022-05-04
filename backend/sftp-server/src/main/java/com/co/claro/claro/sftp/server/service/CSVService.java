package com.co.claro.claro.sftp.server.service;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

@Service
public class CSVService {

	private static final Logger log = LoggerFactory.getLogger(CSVService.class);

	public void createfile(String remotePath, String localPath, String fileName) throws IOException {

		log.info("remotePath: {}", remotePath);
		log.info("localPath: {}", localPath);
		log.info("fileName: {}", fileName);

		String file = fileName + ".csv";
		log.info("file: {}", file);

		String localFile = localPath + File.separator + fileName + ".csv";
		log.info("localFile: {}", localFile);

		SSHClient sshClient = setupSshj();
		SFTPClient sftpClient = sshClient.newSFTPClient();

		sftpClient.put(localFile, remotePath + file);

		sftpClient.close();

	}

	public Boolean validateExistFile(String filePath, String fileName) {

		String file = filePath + File.separator + fileName + ".csv";

		log.info("file: {}", file);

		File tempFile = new File(file);
		return tempFile.exists();

	}

	private SSHClient setupSshj() throws IOException {
		SSHClient client = new SSHClient();
		client.addHostKeyVerifier(new PromiscuousVerifier());
		client.connect("172.22.94.69");// 172.22.94.69
		client.authPassword("GOSTURA", "C0lomb1@");
		if (client.isConnected()) {
			log.info("Conectado...........");
		}
		return client;
	}

}
