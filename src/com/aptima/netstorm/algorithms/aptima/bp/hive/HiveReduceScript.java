package com.aptima.netstorm.algorithms.aptima.bp.hive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.hadoop.hive.contrib.mr.GenericMR;
import org.apache.hadoop.hive.contrib.mr.Mapper;
import org.apache.hadoop.hive.contrib.mr.Reducer;

import com.aptima.netstorm.algorithms.aptima.bp.ConvertFromGraphSON;
import com.aptima.netstorm.algorithms.aptima.bp.ModelGraph;
import com.aptima.netstorm.algorithms.aptima.bp.network.AttributedModelGraph;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.util.io.graphson.GraphSONReader;

/**
 * Reduce script used to run pattern matching on a network stored in a Hive table.
 * 
 * @author ckapopoulos
 *
 */
public class HiveReduceScript {
	public static void main(String[] args) {
		HelpFormatter helpFormatter = new HelpFormatter();
		Options options = buildOptions();
		String mapperOption = null;
		String patternOption = null;
		AttributedModelGraph attributedModelGraph = null;
		
		try {
			CommandLineParser parser = new DefaultParser();			
			CommandLine commandLine = parser.parse(options, args);
			
			if (commandLine.hasOption("p")) {
				patternOption = commandLine.getOptionValue("p");
			} else {
				throw new ParseException(String.format("Argument '%s':[%s] not found!", "p", "pattern"));
			}
			
			if (commandLine.hasOption("m")) {
				mapperOption = commandLine.getOptionValue("m");
			} else {
				throw new ParseException(String.format("Argument '%s':[%s] not found!", "m", "mapper"));
			}
			
			// Does pattern file exist? Is it valid GraphSON?
			File filePattern = new File(patternOption);
			if (!filePattern.exists())
				throw new IllegalArgumentException(String.format("[%s] does not exist!", patternOption));
			else {
				Graph graph = new TinkerGraph();
				FileInputStream fileInputStream = new FileInputStream(filePattern);
				GraphSONReader.inputGraph(graph, fileInputStream);
				ConvertFromGraphSON convertFromGraphSON = new ConvertFromGraphSON();
				attributedModelGraph = convertFromGraphSON.convert(graph);
			}
			
			// Create mapper class and populate it with graph data.
			Class<?> mapperClass = Class.forName(mapperOption);
			Constructor<?> constructor = mapperClass.getConstructor();
		 	if (ModelGraph.class.isAssignableFrom(mapperClass)) {
		 		Object reducerInstance = constructor.newInstance();
		        Method method = mapperClass.getDeclaredMethod("input", AttributedModelGraph.class);
		        method.invoke(reducerInstance, attributedModelGraph);
		        // Run hive job
		 		new GenericMR().reduce(System.in, System.out, (Reducer) reducerInstance); //new BitcoinReducer(args)
		 	} else {
		 		throw new ParseException(String.format("Class: [%s] does not implement [%s]!", mapperOption, "ConvertFromGraphSON"));
		 	}
		 	
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			helpFormatter.printHelp( "HiveMapScript", options );			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			helpFormatter.printHelp( "HiveMapScript", options );
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
			helpFormatter.printHelp( "HiveMapScript", options );
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
			helpFormatter.printHelp( "HiveMapScript", options );
		} catch (InstantiationException e) {
			System.out.println(e.getMessage());
			helpFormatter.printHelp( "HiveMapScript", options );
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
			helpFormatter.printHelp( "HiveMapScript", options );
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			helpFormatter.printHelp( "HiveMapScript", options );
		} catch (InvocationTargetException e) {
			System.out.println(e.getMessage());
			helpFormatter.printHelp( "HiveMapScript", options );
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			helpFormatter.printHelp( "HiveMapScript", options );
		} catch (IOException e) {
			System.out.println(e.getMessage());
			helpFormatter.printHelp( "HiveMapScript", options );
		} catch (Exception e) {
			e.printStackTrace();							
		} 
	}

	private static Options buildOptions() {
		Options options = new Options();
	
		Option mapper = Option.builder("m")
				.required(true)
	            .hasArg()
	            .desc(  "mapper class to use" )
	            .longOpt("mapper")
	            .type(String.class)
	            .build();
	
		Option pattern = Option.builder("p")
				.required(true)
	            .hasArg()
	            .desc(  "pattern file to use" )
	            .longOpt("pattern")
	            .type(String.class)
	            .build();;
	
		options.addOption(mapper);
		options.addOption(pattern);
	
		return options;		
	}
}
