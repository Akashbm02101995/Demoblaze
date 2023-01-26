package com.demoblaze.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileLibrary {
String path="./TestData/testdata.properties";

public String getDatafromProperties(String key) throws IOException {
	FileInputStream fl= new FileInputStream(path);
	Properties prop=new Properties();
	prop.load(fl);
	return prop.getProperty(key);
}
}
