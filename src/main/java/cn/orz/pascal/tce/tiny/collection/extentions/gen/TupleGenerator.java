/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.tce.tiny.collection.extentions.gen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 *
 * @author koduki
 */
public class TupleGenerator {

    public static void main(String[] args) throws IOException {
        Velocity.init();
        VelocityContext context = new VelocityContext();

        context.put("qot", "\"");
        context.put("xs", IntStream.range(2, 22).boxed().collect(Collectors.toList()));

        try (Writer writer = new FileWriter(new File("target/Tuple.java"))) {
//        try (Writer writer = new StringWriter()) {

            Template tmplate = Velocity.getTemplate("src/main/resources/tuple.vm");
            tmplate.merge(context, writer);
            System.out.println(writer.toString());
        }

    }
}
