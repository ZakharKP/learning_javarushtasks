package com.javarush.bigtask.task31.task3110;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	private Path rootPath;
	private List<Path> fileList;

	public FileManager(Path rootPath) throws IOException {
		this.rootPath = rootPath;
		this.fileList = new ArrayList<>();
		collectFileList(rootPath);
	}

	public List<Path> getFileList() {
		return fileList;
	}

	private void collectFileList(Path path) throws IOException {
		// Add only files
		if (Files.isRegularFile(path)) {
			Path relativePath = rootPath.relativize(path);
			fileList.add(relativePath);
		}

		// Add directory contents
		if (Files.isDirectory(path)) {
			// Recursively iterate through the contents of the directory
			// In order not to write code for calling close on DirectoryStream, wrap the
			// call to newDirectoryStream in try-with-resources
			try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
				for (Path file : directoryStream) {
					collectFileList(file);
				}
			}
		}
	}
}
