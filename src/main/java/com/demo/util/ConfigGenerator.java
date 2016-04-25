package com.demo.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public abstract class ConfigGenerator {

	public static void main(String[] args) throws IOException {
		Properties p = new Properties();
		// 从classpath中读取vm文件
		p.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		Velocity.init(p);
		
		VelocityContext context = new VelocityContext();
		
		// 读取出有顺序的keys
		Properties op = new OrderedProperties();
		op.load(new FileReader(new File("src/main/resources/config.properties")));
		
        context.put("map", genMap(op.keySet()));
        
        Template template = Velocity.getTemplate("vm/config.vm");
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        
        FileWriter fw = new FileWriter(new File("src/main/java/com/demo/core/Config.java"));
		fw.write(writer.toString());
		fw.flush();
		fw.close();
	}
	
	public static Map<String, String> genMap(Set<Object> set) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (Object key : set) {
			map.put(genKey((String) key), (String) key);
		}
		return map;
	}

	public static String genKey(String key) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			int iv = (int) c;
			// 46为.
			if (iv == 46) {
				sb.append("_");
				// 字母a-z
			} else if (iv >= 97 && iv <= 122) {
				sb.append(Character.toUpperCase(c));
			} else if (iv >= 65 && iv <= 90) {
				sb.append("_").append(c);
			}
		}
		return sb.toString();
	}
}
