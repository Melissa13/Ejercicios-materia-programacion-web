package recursos;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.*;
import spark.template.freemarker.FreeMarkerEngine;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class main {
    public static List<estudiante> usuarios = new ArrayList<>();


    public static void main(String[] args){

        new main().manejadorFremarker();



    }

    public void manejadorFremarker(){


       /* estudiante user1= new estudiante(1, "lala", "lola", "1234");
        estudiante user2= new estudiante(2, "lal2", "lola2", "12342");
        estudiante user3= new estudiante(3, "lal33", "lola3", "12343");
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);*/

        Configuration configuration= new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(
                main.class,"/templates/");
        FreeMarkerEngine motor= new FreeMarkerEngine(configuration);

        get("/", (request, response) -> {
            Map<String, Object> mapa = new HashMap<>();
            mapa.put("name","Melissa Lantigua - 2014-0805");
            return new ModelAndView(mapa, "home.ftl");
        }, motor);

        get("/lista", (request, response) -> {
            Map<String, Object> mapa = new HashMap<>();
            mapa.put("lista", usuarios);

            return new ModelAndView(mapa, "lista.ftl");
        }, motor);

        Spark.get("/nuevo", (request, response) -> {

            StringWriter writer = new StringWriter();

            try {
                Template formTemplate = configuration.getTemplate("form.ftl");

                formTemplate.process(null, writer);
            } catch (Exception e) {
                Spark.halt(500);
            }

            return writer;
        });

        Spark.post("/esto", (request, response) -> {
            StringWriter writer = new StringWriter();

            try {
                String number= request.queryParams("nombre") != null ? request.queryParams("nombre") : "0";
                int matricula = Integer.parseInt(request.queryParams("matricula"));
                String nombre =request.queryParams("nombre") != null ? request.queryParams("nombre") : "unknown";
                String apellido =request.queryParams("apellido") != null ? request.queryParams("apellido") : "unknown";
                String telefono =request.queryParams("telefono") != null ? request.queryParams("telefono") : "unknown";


                Template resultTemplate = configuration.getTemplate("result.ftl");

                Map<String, Object> map = new HashMap<>();
                estudiante user= new estudiante(matricula, nombre, apellido, telefono);
                usuarios.add(user);
                map.put("est",user);

                resultTemplate.process(map, writer);
            } catch (Exception e) {
                Spark.halt(500);
            }

            return writer;
        });

        get("/ruta/:matricula", (request, response)->{
            int matricula= Integer.parseInt(request.params("matricula"));
            Map<String, Object> mapa = new HashMap<>();
            mapa.put("mat", matricula);
            estudiante est=new estudiante(0,"desconocido","desconocido","desconocido");
            for(estudiante est2 : usuarios) {
                if(est2.getMatricula()==matricula) {
                    est=est2;
                }
            }
            mapa.put("est", est);
            return new ModelAndView(mapa, "esto.ftl");
        }, motor);

        /*get("/esto", (request, response) -> {
            Map<String, Object> mapa = new HashMap<>();

            String variableOculta = request.queryParams("variable_oculta");
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            String nombre =request.queryParams("nombre");
            String apellido =request.queryParams("apellido");
            String telefono =request.queryParams("telefono");
            System.out.println("La variable Oculta: "+variableOculta);

            estudiante user= new estudiante(matricula, nombre, apellido, telefono);
            mapa.put("estudent",user);
            //usuarios.add(user);
            //System.out.print(user);

            return new ModelAndView(mapa, "esto.ftl");
        }, motor);*/

        Spark.get("/editar/:matricula", (request, response) -> {

            StringWriter writer = new StringWriter();

            try {
                Template formTemplate = configuration.getTemplate("editar.ftl");

                int matricula= Integer.parseInt(request.params("matricula"));
                Map<String, Object> mapa = new HashMap<>();
                mapa.put("mat", matricula);

                formTemplate.process(mapa, writer);
            } catch (Exception e) {
                Spark.halt(500);
            }

            return writer;
        });

        Spark.post("/editado/:mat", (request, response) -> {
            StringWriter writer = new StringWriter();

            try {
                String number= request.queryParams("nombre") != null ? request.queryParams("nombre") : "0";
                int matricula = Integer.parseInt(request.queryParams("matricula"));
                String nombre =request.queryParams("nombre") != null ? request.queryParams("nombre") : "unknown";
                String apellido =request.queryParams("apellido") != null ? request.queryParams("apellido") : "unknown";
                String telefono =request.queryParams("telefono") != null ? request.queryParams("telefono") : "unknown";


                Template resultTemplate = configuration.getTemplate("datos.ftl");

                Map<String, Object> mapa = new HashMap<>();
                int mat= Integer.parseInt(request.params("mat"));
                estudiante est=new estudiante(0,"desconocido","desconocido","desconocido");
                for(estudiante est2 : usuarios) {
                    if(est2.getMatricula()==mat) {
                        est2.setMatricula(matricula);
                        est2.setNombre(nombre);
                        est2.setApellido(apellido);
                        est2.setTelefono(telefono);
                        est=est2;
                    }
                }
                mapa.put("est", est);
                //estudiante user= new estudiante(matricula, nombre, apellido, telefono);
                //usuarios.add(user);
                mapa.put("est",est);

                resultTemplate.process(mapa, writer);
            } catch (Exception e) {
                Spark.halt(500);
            }

            return writer;
        });

        get("/delet/:matricula", (request, response)->{
            int matricula= Integer.parseInt(request.params("matricula"));
            Map<String, Object> mapa = new HashMap<>();
            estudiante est=new estudiante(0,"desconocido","desconocido","desconocido");
            for(estudiante est2 : usuarios) {
                if(est2.getMatricula()==matricula) {
                    est=est2;
                }
            }
            usuarios.remove(est);
            return new ModelAndView(mapa, "delete.ftl");
        }, motor);

    }
}

