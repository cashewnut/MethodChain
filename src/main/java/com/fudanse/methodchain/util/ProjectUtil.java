package com.fudanse.methodchain.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectUtil {

	public static List<String> getPackageList(File file) {
		List<String> packages = null;
		List<File> javaFiles = getJavaFiles(file);
		packages = javaFiles.stream().map((f) -> FileUtil.openCU(f).getPackage().getName().getName())
				.collect(Collectors.toList());
		return packages;
	}

	public static List<String> getPackageList(String directory) {
		File file = new File(directory);
		return getPackageList(file);
	}

	public static List<File> getJavaFiles(File file) {
		List<File> javaFiles = new ArrayList<>();
		if (!file.exists())
			return null;
		if (!file.isDirectory())
			javaFiles.add(file);
		else {
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.isDirectory())
					javaFiles.addAll(getJavaFiles(f));
				else {
					if (f.getName().length() > 5 && f.getName().substring(f.getName().length() - 5).equals(".java")) {
						javaFiles.add(f);
					}
				}
			}
		}
		return javaFiles;
	}

}
