package co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.activity.DetalleNoticiaActivity;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.activity.NavigationActivity;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.util.AdaptadorDeNoticia;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.util.AdaptadorNoticiaDetalle;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.util.Utilidades;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.Activity.vo.Noticia;
import co.edu.uniquindio.android.electiva.practica_navegation_drawer.R;
/**
 *
 * @author : Arley Sneyder Rico B.
 * @author : Kevin Agudelo Gallego
 * @author : Juan Sebastian Ocampo
 * @version : 1.0
 *
 *
 * Fragmento que contiene  el layout que contiene las noticias de la universidad
 */
public class NoticiasFragment extends Fragment implements AdaptadorDeNoticia.OnClickAdaptadorDeNoticia {

    //@BindView(R.id.RecView)
    protected RecyclerView listadoDeNoticias;
    private Unbinder unbinder;
    private AdaptadorDeNoticia adaptador;
    private ArrayList<Noticia> noticias;
    private OnNoticiaSeleccionadaListener listener;
    int cont = 0;

    public NoticiasFragment() {
        // Required empty public constructor
    }

    /**
     * En este método creamos los elementos que van a tener las noticias
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.v("Msg", cont + "Actividad creada");
        cont++;
        super.onActivityCreated(savedInstanceState);
        // se crea el listado de noticias para mostarlas en el fragmento NoticiasFragment
        noticias = new ArrayList();
        noticias.add(new Noticia("Egresados aportan a la alta calidad en ingenieria elecrónica", "Con la visita de destacados ingenieros graduados del programa de Ingeniería electrónica de la Universidad del Quindío, en el marco de los procesos de Autoevaluación y el Proyecto Cultural promovidos desde el programa mencionado y la facultad de ingeniería, se realizó un ciclo conferencial y un minitaller  con los ingenieros Jaime Alberto Segura, PhD, investigador del Instituto Laue-Langevin (Institut Laue-Langevin o ILL), radicado en Grenoble Francia y Catalina Mejía, Msc, de la Universidad de Aschen, Alemania.La uniquindiana Catalina Mejía recibió el título con honores en Ingeniería Electrónica de la Universidad del Quindío en el año 2011. Su trabajo recibió mención laureada por la calidad de su investigación en el área de optimización para comunicaciones móviles de 4ta generación en la Universidad alemana RWTH Aachen durante el año 2009. En el año 2015 obtuvo magister en Ingeniería Electrónica, Tecnología de la Información e Ingeniería Computacional de la RWTH Aachen, con profundización en la ingeniería de comunicaciones.Desde el año 2010 hasta el 2013 la ingeniera Mejía trabajó como asistente de doctorado en la misma institución en las áreas de investigación relativas al desarrollo de algoritmos para el mejoramiento de tecnologías LTE y LTE-Advanced. Sus mayores intereses de investigación están basados en las metodologías, arquitecturas y algoritmos para la programación de protocolos de sistemas de comunicaciones móviles de última generación. A partir de abril y hasta finales del 2015 trabajó para la Mercedes-Benz en el estudio, validación y negociación de sistemas de Software y Hardware propuestos por diferentes proveedores para sus vehículos, en su casa matriz de la ciudad de Stuttgart en Alemania. Actualmente, está vinculada a proyectos de investigación con la universidad RWTH Aachen en el área de Redes inalámbricas de sensores (WSN). Al mismo tiempo, trabaja como intérprete en la moderación de negocios, una de sus grandes pasiones, para empresarios colombianos que incursionan en el mercado alemán a través de ProExport / ProColombia en Alemania. Los temas abordados por la Ingeniera Catalina Mejía, quien además se ha destacado en el ámbito artístico como intérprete de los ritmos colombianos y latinoamericanos, fueron, entre otros, los relacionados con su experiencia personal como ingeniera colombiana en Europa. En el área disciplinar expuso ante estudiantes de diversos semestres, los fundamentos de algoritmos para el proceso de identificación de sensores en redes inalámbricas de sensores para la exploración de ambientes inaccesibles, como la exploración de subsuelos, monitoreo de hábitats, detección de ataques químicos, entre otros, donde la adecuada reconstrucción de los datos adquiridos es indispensable. Reto de la formación internacional. Socialización de experiencias en Alemania. Por su parte, el Doctor Jaime Alberto Segura, también egresado del programa de Ingeneiría Electrónica, orientó un minicurso de Altas energías como invitado especial del Instituto Interdisciplinario de las Ciencias, dirigido a los estudiantes de distintos semestres del citado programa. El trabajo de pregrado el ingeniero Segura lo realizó en el Instituto Interdisciplinario de las Ciencias, Centro de Investigación UQ, y versó sobre la fabricación de materiales semiconductores. Realizó sus estudios de Maestría en Ciencias de los Materiales en el IIC UQ y el tema de su trabajo final siguió la línea de los semiconductores que forman puntos cuánticos embebidos en una matriz de material también semiconductor. En España culminó su doctorado en el Instituto de Ciencias de Materiales (ICMUV) de la Universidad de Valencia. Una vez obtuvo el título de doctor, aplicó para un posdoctorado en el ESRF (European Sychrotron Radiation Facility) lugar en el que trabajó con la doctora cubana Gema Martínez en la línea de rayos X.  El ESRF es un centro de investigación multinacional ubicado en Grenoble, Francia, donde existe un sincrotrón de electrones exclusivamente dedicado a la producción y utilización de la luz con fines científicos. Después de realizar un año de posdoctorado concursó para un cargo de investigador el cual le permitió estar contratado por tres años. Actualmente trabaja en el ILL (Instituto Laue-Langevin) en Grenoble (Instituto internacional de investigación, líder mundial en ciencias y técnicas de neutrones, situado también en Grenoble)  que posee la fuente de neutrones más intensa del mundo.  En este instituto realiza investigaciones sobre dispositivos electrónicos buscando soluciones para la industria de la microelectrónica. Las visitas e interacciones académicas de los egresados de alto nivel en los campos de las ciencias de ingeniería y la industria, con estudiantes de diversos semestres de Ingeneiría electrónica, son el resultado de una estrategia que busca conectar los contextos de aplicación del conocimiento con los de aprendizaje en las aulas, en pro de la formación de un ingeniero pertinente cuyo ejercicio obedezca a las demandas de la realidad local y global.", R.drawable.noticia1));
        noticias.add(new Noticia("Uniquindianos podrán cursar maestría en Inaoe, México", "A feliz término llegó la convocatoria realizada en la Universidad del Quindío por parte del Instituto Nacional de Astrofísica, Óptica y Electrónica (INAOE), ubicado en Puebla, México con el fin de seleccionar a los estudiantes que podrán cursar estudios avanzados en este importante instituto de alta ingeniería, en cumplimiento del convenio suscrito con el alma mater de los quindianos. La dinámica académica estuvo en manos de los doctores en Electrónica, María Teresa Sanz  Pascual y  Pedro Rosales Quintero, de nacionalidad española y mexicana respectivamente, quienes dieron a conocer los programas de maestría y doctorado que ofrece la institución a la que representan. La primera jornada, realizada el pasado 21 de abril, incluyó una charla informativa orientada por la doctora María Teresa Sanz, en la que se socializaron las áreas de trabajo y los objetivos del Instituto, aplicados a la preparación de investigadores y expertos en campos especializados, en la búsqueda de resolver problemáticas científicas y tecnológicas relacionadas con las diferentes disciplinas que allí se promueven. El INAOE tiene a disposición cinco coordinaciones académicas y una planta docente de diferentes países, compuesta por más de 100 profesores versados en diferentes líneas, quienes brindan a los estudiantes aprendizaje personalizado, en razón a que cada asesor tiene a su cargo cuatro alumnos como máximo, asegurando que la educación se efectúe de acuerdo con los parámetros establecidos. Durante la charla previa al examen se especificaron las condiciones mínimas para el desplazamiento a México, relacionadas con la experiencia en las diferentes áreas, documentación, estadía, alimentación y apoyo económico (beca del Conacyt), que constituyen los requerimientos básicos para el inicio del primer periodo, durante el cual se facilitará el acceso a los diferentes campos de conocimiento, con el fin de que puedan elegir el de sus preferencias. Respecto a la actividad del examen de admisión, este se realizó el día 22 de Abril en horas de la mañana. Las pruebas serán analizadas por los doctores encargados de la convocatoria y a mediados del presente año se darán a conocer los resultados, para que los estudiantes admitidos comiencen los trámites de movilidad. Con relación al convenio INAOE-UQ, Jorge Iván Marín, Phd, director del programa de Ingeniería electrónica, se mostró satisfecho de que se haya retomado el convenio académico, luego de dos años de no realizarse la convocatoria en la Uniquindio. Según él: “Esta opción fortalece el proceso de internacionalización para estudiantes y egresados, que están interesados en continuar sus estudios de posgrado en el INAOE, una institución a la que le preceden excelentes referencias por su alto nivel académico en las áreas técnica y científica. De hecho se tiene conocimiento de algunos estudiantes del programa de Ingeniería electrónica que han estudiado allí y de otros que en la actualidad están vinculados a los procesos educativos en maestría y en doctorado”. En referencia al posicionamiento internacional del Programa a través de los logros de los uniquindianos que se encuentran en el INAOE, indicó “Es supremamente importante y motivo de orgullo, porque gracias al buen comportamiento, dedicación, responsabilidad y compromiso, los egresados de Electrónica muestran sentido de pertenencia por el Programa y la Universidad del Quindío, logrando el sostenimiento del convenio, manteniendo las puertas abiertas para que otros estudiantes tengan también la posibilidad de hacer parte de dicha institución mexicana”. Haciendo alusión a los estudiantes que presentaron la prueba de admisión, Marín explicó que a partir de su desempeño se definirá quiénes tendrán el privilegio de acceder a esta  gran oportunidad.", R.drawable.noticia2));
        noticias.add(new Noticia("¡Voces uniquindianas engalanaron el Concurso Interno de la Canción!", "Un balance positivo dejó la participación de estudiantes de la Universidad del Quindío en la Sexta versión del Concurso Interno de la Canción. El  evento organizado por el área de Cultura de Bienestar Institucional,  contó con la vinculación de 36 estudiantes que buscaron  un cupo para representar al alma mater en el  Zonal de la Canción de ASCUN, el cual  se realizará en la ciudad de Ibagué el próximo 5 de mayo. Los cupos para el Zonal se entregaron al primer puesto de cada modalidad. En la modalidad de Solista Vocal Masculino el primer puesto fue para Johan Mauricio Trejos y el segundo lugar se lo llevó William Orjuela; en la categoría de Solista Vocal Femenino el primer puesto fue para Paula Andrea Uribe y el segundo lugar fue para Luisa Fernanda Jiménez; y la modalidad de Canción Inédita se otorgó a “Inspiración lunar”, canción interpretada por Juan Camilo Carmona quien estuvo acompañado en la guitarra por Oscar Aníbal González. Solista femenino y canción inédita En la modalidad femenina solista, resultó ganadora la interpretación de Paola Andrea Uribe Feria, estudiante de IV Semestre de Licenciatura en Biología y Educación Ambiental. “Me siento muy contenta de haber participado en este concurso y haber cumplido la meta de ganar.  Mi objetivo más que ganar es seguirme formando íntegramente”. Juan Camilo Carmona, estudiante de II Semestre del programa de Comunicación Social – Periodismo logró cautivar al jurado con la letra y acordes de su canción inédita: “inspiración lunar” una historia que nace de su caminar cotidiano: “caminando en una noche de luna llena, pienso en mi novia quien fue la inspiración porque llevamos un amor a distancia y es allí donde la luna es la mediadora de ese amor que nace de mí.  Estamos pensando en un proyecto nuevo con mi compañero Óscar González y otros amigos para presentarnos el próximo año.  Oscar González estudia VI semestre de Contaduría Pública y conoció a Juan Camilo hace pocas semanas: “Me presentó la canción y llegamos a un acuerdo de donde surgió mi acompañamiento musical”. Carlos Javier Díaz, director del Grupo Vocal instrumental de la Universidad del Quindío, expresó su complacencia con la realización del Concurso Interno de la Canción: “Hemos seleccionado nuestros representantes al zonal de la canción en la modalidad femenina y masculina. Calificamos aspectos técnicos como vocalización, afinación, ritmo. De igual manera se calificó la comunicación con el público, la expresión corporal y la puesta en escena. Hemos descubierto una cantidad de talentos y de intenciones artísticas entre los participantes, muchos de ellos en proceso de formación vocal. Carlos Enrique Cabrera Arismendi, director de Bienestar Universitario expresó como la mayor importancia de estas convocatorias es que “los estudiantes que nos representen en los eventos de Ascun o cualquiera otro a nivel nacional sean fruto de un proceso de selección serio, responsable y objetivo. Que responda a un ejercicio eliminatorio previo. De otro lado, esto nos permite conocer y reconocer cuál es el talento que tenemos al interior de la Universidad. Tenemos unos talentos incógnitos, es decir, no pertenecen a grupos representativos y esta es la oportunidad para que se pongan en escena y poderlos conocer”. Carlos Andrés García, coordinador de Cultura entregó su balance acerca de la convocatoria: “Tuvimos una participación de treinta y seis entre obras inéditas, solitas femeninos y solistas masculinos. El nivel de inscripción fue aceptable. Tenemos un balance muy positivo de esta versión del Concurso”. Agregó:  “Seleccionamos tres participantes al Zonal de Ascun que se desarrollará el 5 de mayo en Ibagué, uno en canción inédita y voz masculina y femenina como solistas”.El jurado calificador estuvo integrado por los maestros Carlos Javier Díaz, Julián Carmona y Mauricio Arroyave, todos vinculados con Bienestar Institucional de la Universidad del Quindío en el área de Música.", R.drawable.noticia3));
        noticias.add(new Noticia("Con participación la Universidad del Quindío enfrenta la Acreditación", "Con gran presencia activa y participante de directivos académicos, funcionarios administrativos de todas las dependencias, estudiantes, profesores y diferentes actores de la comunidad académica, acompañados por el señor rector José Fernando Echeverry Murillo y sus vicerrectores, así como por los integrantes de la Oficina de Gestión y Aseguramiento de la Calidad de la Universidad del Quindío, entre otros macroprocesos, se realizó la Jornada de Sensibilización para la Acreditación de Alta Calidad con el doctor Luis Enrique Silva Segura, quien orientó tres intensas jornadas de trabajo a nombre del Consejo Nacional de Acreditación, CNA, dirigiéndose a cada uno de los sectores universitarios con contenidos específicos, tomando siempre en cuenta sus perfiles, funciones y expectativas. Según el experto invitado la \"Autonomía universitaria responsable debe entenderse como la capacidad de construir con otros y para otros. Es nuestra habilidad para autogestionarnos reflexivamente. Por eso se deben conocer y practicar en profundidad y con convicción las directrices deontológicas (valores institucionales y disciplinares ejercidos en el entorno)  que identifican nuestra labor educativa, fundamentada en un proyecto de país”. En opinión del experto, “en Colombia la educación está fragmentada y por tanto debe reconstruirse conjuntamente, desde todos los flancos y niveles del sistema, hasta que podamos consolidarlo como un proceso continuo y pertinente\". Igualmente enfatizó en sus charlas, acerca de la necesidad de proyectar la universidad con responsabilidad social hacia el entorno, concibiendo lo local como un mundo que puede proponer y desarrollar iniciáticas de mejoramiento de la calidad de vida y formación integral para todos. “Debemos ser significativos en un contexto de formación en el que es preciso hacer visibles a los otros, seguros de que todo proceso educativo es cultural y debe ser construido desde una perspectiva socioantropológica local que permita la  promoción, transformación y permanencia de la cultura”, agregó el representante del CNA. Destacó el funcionario nacional, especialista en calidad educativa CNA, que la universalidad del proyecto universitario no significa importar modelos globales irreflexivamente sino en globalizar iniciativas locales que partan de un concepto igualmente localizado de innovación, que a su vez dialogue con las tendencias internacionales pero que conserve su originalidad, pertinencia y autonomía. “Hablo desde Armenia, un lugar en el mundo”, fue la expresión que utilizó para mostrar la capacidad que tiene la universidad comprometida con la calidad de ocupar el centro de la escena educativa con sus muy particulares resultados académicos e investigativos en todos los flancos. Destacó igualmente la madurez de la actual administración de la Universidad en cabeza del Ingeniero José Fernando Echeverry Murillo, al definir la presentación del informe final ante el CNA, cuando todas las condiciones estén dadas y no antes, a fin de construir un escenario seguro y confiable hacia la aceptación de la solicitud de Acreditación Institucional de Alta calidad. El rector de la Universidad del Quindío se mostró muy satisfecho por este valor agregado que se le da al proceso de aseguramiento de la calidad, dentro del cual se aspira a estar entregando el documento de autoevaluación con fines de Acreditación Institucional el próximo 2 de Diciembre, y destacó el apoyo de la comunidad universitaria a la jornada. Por su parte, el jefe de la Oficina de Gestión y Aseguramiento de la Calidad de la Universidad del Quindío, Gustavo Adolfo Rincón Botero, manifestó que se está trabajando con todos los estamentos para lograr el objetivo de la acreditación institucional, pues solo con la participación activa de cada uno de los uniquindianos se podrá alcanzar una meta que se verá reflejada en los múltiples procesos que definen el futuro del alma mater por excelencia de todos los quindianos.", R.drawable.noticia4));
        noticias.add(new Noticia("Un espacio académico desde la Física para la comunidad", "Todos los jueves el programa de Física de la Universidad del Quindío realiza un Seminario pensado como espacio de extensión académica en donde además de presentar objetivos específicos de esa área del conocimiento, se hace referencia a temas que ocupan la atención del mundo científico y son de importancia para nuestros académicos. Según el doctor en Física, Diego Arias Serna, gestor y encargado del seminario “se trata de una necesidad académica para profesores y estudiantes de nuestra alma máter, que se preocupan por estar actualizados, aunque hay que reconocer que hay bastante interés por parte de personas de fuera de la universidad, que se interesan por estos temas”. Y agrega que “también tocamos temáticas que reciben reconocimiento mundial o perduran como hechos científicos en el tiempo y se rememoran en fechas especiales”. En ese sentido, el jueves 14 de abril se llevó a cabo el seminario con el tema “Estructura electrónica de amino y dimetilamino - benzonitrila en medio de híbridos QM-MM” por el egresado y docente uniquindiano, y además estudiante de la Maestría en Ciencias de los Materiales,  Andrés Medina Herrera, quien valoró la importancia de estos espacios que promueven la divulgación del conocimiento y retroalimentación de conceptos apropiados por investigadores y expertos en este tipo de temas. El Seminario de Física continúa este jueves 21 de abril y su propósito académico se desarrollará a través de la exposición del tema “¿Estado superiónico, un sistema coherente? a cargo del profesor e investigador Hernando Hurtado Gallego, quien a partir de las 4:00 de la tarde abrirá otro importante capítulo en el desarrollo de esta iniciativa aportante a la investigación.  El experto desarrollará su disertación acerca del estado superiónico de algunos sistemas donde los iones se pueden desplazar con alta movilidad.", R.drawable.noticia5));
        //obtener la dirección del recyRecyclerView
        listadoDeNoticias = (RecyclerView) getView().findViewById(R.id.RecView);
        //añadir las noticias al adaptador
        adaptador = new AdaptadorDeNoticia(noticias,this);
        //obtener el adaptador para el RecyclerView

        listadoDeNoticias.setAdapter(adaptador);
        //mostar el RecyclerView
        listadoDeNoticias.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }



    /**
     * Este método infla el fragmento que vamos a utilizar
     * <p>
     * public View onCreateView(LayoutInflater inflater, ViewGroup container,
     * Bundle savedInstanceState) {
     * // Inflate the layout for this fragment
     * return inflater.inflate(R.layout.activity_peliculas_actuales, container, false);
     * }
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_noticias, container, false);
        //unbinder = ButterKnife.bind(this, view);
        return view;
    }

    /**
     * onCreate del fragmento NoticiasFragment
     * obtiene el lenguaje que se esta utiizando
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.v("Msg", cont + " on create");
        cont++;
        super.onCreate(savedInstanceState);
        Utilidades.obtenerLenguaje(getActivity());
        setHasOptionsMenu(true);
    }

    /**
     * es llamado cuando el fragmento es asociado con la actividad(recibe el contexto de la actividad como parámetro).
     **/
    @Override
    public void onAttach(Context context) {
        Log.v("Msg", cont + " on attach");
        cont++;
        super.onAttach(context);

        Activity activity;
        //DetalleNoticiaActivity
        if (context instanceof Activity) {
            activity = (Activity) context;

            try {
                listener = (OnNoticiaSeleccionadaListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnPeliculaSeleccionadaListener");
            }
        }

    }

    /**
     * Metodo utlizado identificar la pelicula seleccionada
     *
     * @param pos, la posicion presionada
     */
    @Override
    public void onClickPosition(int pos) {
        cont++;
        //listener.onNoticiaSeleccionada(pos);
        Intent intent = new Intent(getActivity(), DetalleNoticiaActivity.class);
        intent.putExtra("noticia", noticias.get(pos));
        startActivity(intent);

    }

    /**
     * la interface OnNoticiaSeleccionadaListener sirve para obtener la posicion de la noticia
     * seleccionada
     */
    public interface OnNoticiaSeleccionadaListener {
        void onNoticiaSeleccionada(int position);
    }

    /**
     * obtener las noticias añadidas
     * @return Noticias
     */
    public ArrayList<Noticia> getNoticias() {
        return noticias;
    }

    /**
     * agragar las noticias
     * @param noticias recibe las noticias que añadirán al fragmento
     */
     public void setNoticias(ArrayList<Noticia> noticias) {

        this.noticias = noticias;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       // unbinder.unbind();
    }
}
