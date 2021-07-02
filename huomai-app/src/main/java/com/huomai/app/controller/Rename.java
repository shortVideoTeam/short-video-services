package com.huomai.app.controller;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 项目重命名（项目名，包名）
 *
 * @author chenshufeng
 * @version 1.0
 * @date 2021/7/2 5:56 下午
 */
public class Rename {

	//老项目的模块文件名和包名
	public static final String old_str = "huomai";
	//替换为新的模块文件名和包名
	public static final String new_str = "doctor";
	//需要拷贝的模板项目
	public static final String template_project = "short-video-services";
	//模块
	public static final String old_module = "video-plat";
	public static final String new_module = "doctor-plat";
	public static final String new_project = "doctor-app";
	public static final String user_home = System.getenv("HOME");

	public static void main(String[] args) {
		try {
			//创建新项目路径
			String rmCommand = "rm -rf" + user_home + File.separator + new_module;
			Runtime.getRuntime().exec(rmCommand);
			System.out.println(rmCommand);
			Runtime.getRuntime().exec("mkdir -p " + user_home + File.separator + new_module + File.separator + new_project);
			System.out.println("cp 项目=================");
			//cp 模板项目为新项目
			String cpCommand = "cp -R " + user_home + File.separator + old_module + File.separator + template_project + " " + user_home + File.separator + new_module + File.separator + new_project;
			System.out.println(cpCommand);
			Runtime.getRuntime().exec(cpCommand);

			System.out.println("替换项目文件包名=================");
			Runtime.getRuntime().exec("cd " + user_home + File.separator + new_module + File.separator + new_project);

			//替换项目文件里面的包名和模块名称
			String sedCommand = "gsed -i \"s/" + old_str + "/" + new_str + "/g\" `grep " + old_str + " -rl " + user_home + File.separator + new_module + "`";
			System.out.println(sedCommand);
			Runtime.getRuntime().exec(sedCommand);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File[] files = FileUtil.ls(user_home + File.separator + new_module);
		//重命名新项目的所有项目名称
		System.out.println("重命名新项目的所有项目名称=================");
		allRename(files);
		try {
			Runtime.getRuntime().exec("rm -rf " + user_home + File.separator + new_module + File.separator + new_project + File.separator + template_project);
			Runtime.getRuntime().exec("rm -rf " + user_home + File.separator + new_module + File.separator + new_project + File.separator + "null");
			Runtime.getRuntime().exec("open " + user_home + File.separator + new_module + File.separator + new_project);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void allRename(File[] files) {
		Stream.of(files).forEach(file -> {
			if (file.isDirectory()) {
				allRename(file.listFiles());
			}
		});
		Arrays.stream(files).filter(file -> file.getName().contains(old_str)).collect(Collectors.toList()).forEach(file -> FileUtil.rename(file, file.getName().replace(old_str, new_str), true));
	}
}
