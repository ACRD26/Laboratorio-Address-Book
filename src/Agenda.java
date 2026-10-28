import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;

public class Agenda {

    private Map<String, Contacto> contactos = new TreeMap<>();
    private Set<String> grupos = new TreeSet<>();
    private Map<String, Set<String>> contactosPorGrupo = new TreeMap<>();
    private List<Contacto> historial = new ArrayList<>();

    public void agregarContacto(Contacto contacto) {
        String nombre = contacto.getNombre();

        if (contactos.containsKey(nombre)) {
            System.out.println("El contacto ya existe");
        } else {
            contactos.put(nombre, contacto);
            historial.add(contacto);
            System.out.println("Contacto agregado");
        }
    }

    public Contacto buscarContacto(String nombre) {
        return contactos.get(nombre);
    }

    public boolean eliminarContacto(String nombre) {
        Contacto contacto = contactos.remove(nombre);

        if (contacto != null) {
            historial.remove(contacto);

            for (Set<String> nombres : contactosPorGrupo.values()) {
                nombres.remove(nombre);
            }

            System.out.println("Contacto eliminado");
            return true;
        }

        System.out.println("El contacto no existe");
        return false;
    }

    public void listarContactos() {
        System.out.println("Contactos");

        for (Contacto contacto : contactos.values()) {
            System.out.println(contacto);
        }
    }

    public void listarHistorial() {
        System.out.println("Historial");

        for (Contacto contacto : historial) {
            System.out.println(contacto);
        }
    }

    public void agregarGrupo(String nombreGrupo) {
        if (grupos.contains(nombreGrupo)) {
            System.out.println("El grupo ya existe");
        } else {
            grupos.add(nombreGrupo);
            contactosPorGrupo.put(nombreGrupo, new TreeSet<>());
            System.out.println("Grupo creado");
        }
    }

    public void agregarContactoAGrupo(String nombre, String grupo) {
        if (!contactos.containsKey(nombre)) {
            System.out.println("El contacto no existe");
        } else if (!grupos.contains(grupo)) {
            System.out.println("El grupo no existe");
        } else {
            contactosPorGrupo.get(grupo).add(nombre);
            System.out.println("Contacto agregado al grupo");
        }
    }

    public void listarGrupos() {
        System.out.println("Grupos");

        for (String grupo : grupos) {
            System.out.println(grupo);
        }
    }

    public void mostrarContactosPorGrupo(String nombreGrupo) {
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("El grupo no existe");
            return;
        }

        Set<String> nombres = contactosPorGrupo.get(nombreGrupo);

        if (nombres.isEmpty()) {
            System.out.println("El grupo no tiene contactos.");
        } else {
            System.out.println("Contactos del grupo" + nombreGrupo);

            for (String nombre : nombres) {
                System.out.println(contactos.get(nombre));
            }
        }
    }
}
